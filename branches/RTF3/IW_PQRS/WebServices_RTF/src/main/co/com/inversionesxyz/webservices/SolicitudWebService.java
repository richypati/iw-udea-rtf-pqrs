package co.com.inversionesxyz.webservices;

import java.text.MessageFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;
import co.com.inversionesxyz.exception.EmailException;

@Path("solicitud")
@Component
public class SolicitudWebService {
	
	@Autowired
	private ISolicitudService solicitudService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarSolicitud/{id}")
	public Solicitud consultarSolicitud(@PathParam("id") int id){
		return solicitudService.consultarSolicitud(id);
	}
	
	@POST
	@Path("/realizarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public void realizarSolicitud(Solicitud solicitud){
		solicitudService.guardarSolicitud(solicitud);
	}
	
	public void setSolicitudService(ISolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarPorSucursal/{codigoSucursal}")
	public List<Solicitud> consultarPorSucursal(@PathParam("codigoSucursal") String codigoSucursal){
		return solicitudService.consultarPorSucursal(codigoSucursal);
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/darRespuestaASolicitud/{id}/{respuesta}")
	public String darRespuestaASolicitud(@PathParam("id")int id, @PathParam("respuesta") String respuesta){
		Solicitud solicitud = solicitudService.consultarSolicitud(id);
		try {
			solicitudService.ResponderSolicitud(solicitud, respuesta);
		} catch (EmailException e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible dar respuesta a la solicitud: {0}", id),
					e.getCause());
		}
		return "Se ha dado respuesta a la solicitud";
	}

}
