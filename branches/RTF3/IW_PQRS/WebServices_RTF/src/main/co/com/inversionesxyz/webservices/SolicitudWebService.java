package co.com.inversionesxyz.webservices;

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
	 * @return Response respuesta con la solicitud identificada por id y un codigo que indica si la peticion fue fallida o no
	 * @throws WebApplicationException cuando no es posible consultar la solicitud
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarSolicitud/{id}")
	public Response consultarSolicitud(@PathParam("id") int id){
		try{
			return Response.ok(solicitudService.consultarSolicitud(id)).build();
		}catch(IllegalArgumentException iae){
			iae.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	/**
	 * Permite insertar una nueva solicitud
	 * @param solicitud nueva solicitud
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 * @throws WebApplicationException cuando no es posible insertar la solicitud
	 */	
	@POST
	@Path("/realizarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response realizarSolicitud(Solicitud solicitud){
		try{
			return Response.ok(solicitudService.guardarSolicitud(solicitud)).build();
		}catch(IllegalStateException e){
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarPorSucursal/{codigoSucursal}")
	public List<Solicitud> consultarPorSucursal(@PathParam("codigoSucursal") String codigoSucursal){
		return solicitudService.consultarPorSucursal(codigoSucursal);
	}
	
	/**
	 * Permite insertar la respuesta a una solicitud
	 * @param id identificador de la solicitud
	 * @param respuesta nueva respuesta a la solicitud
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 * @throws WebApplicationException | EmailException cuando no es posible insertar la solicitud
	 */	
	@POST
	@Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN})
	@Path("/darRespuestaASolicitud/{id}/{respuesta}")
	public Response darRespuestaASolicitud(@PathParam("id")int id, @PathParam("respuesta") String respuesta){
		try {
			Solicitud solicitud = solicitudService.consultarSolicitud(id);
			solicitud.setRespuestaSolicitud(respuesta);
			solicitudService.ResponderSolicitud(solicitud);
			return Response.ok().build();
		} catch (IllegalStateException | EmailException e) {
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
	}
	
	public void setSolicitudService(ISolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}

}
