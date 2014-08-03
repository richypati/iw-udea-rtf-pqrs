package co.com.inversionesxyz.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dto.Solicitud;

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
	
	public void setSolicitudService(ISolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}

}
