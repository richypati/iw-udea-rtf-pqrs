package co.com.inversionesxyz.webservices;

import java.text.MessageFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;
import co.com.inversionesxyz.exception.EmailException;

/**
 * Clase que implementa las operaciones basadas en servicios web Rest a realizar sobre una solicitud
 * @author Jennifer Perez
 * @author Ricardo Patino
 */

@Path("solicitud")
@Component
public class SolicitudWebService {
	
	@Autowired
	private ISolicitudService solicitudService;

	/**
	 * Permite consultar una solicitud por su id
	 * @param id codigo de la solicitud
	 * @return Solicitud identificada por id
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarSolicitud/{id}")
	public Solicitud consultarSolicitud(@PathParam("id") int id){
		try{
			return solicitudService.consultarSolicitud(id);
		}catch(IllegalArgumentException iae){
			iae.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	/**
	 * Permite insertar una nueva solicitud
	 * @param solicitud nueva solicitud
	 */	
	@POST
	@Path("/realizarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public void realizarSolicitud(Solicitud solicitud){
		solicitudService.guardarSolicitud(solicitud);
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
	
	public void setSolicitudService(ISolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}

}
