package co.com.inversionesxyz.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.EmailException;
import co.com.inversionesxyz.webservices.dto.SolicitudWS;

/**
 * Clase que implementa las operaciones basadas en servicios web Rest a realizar sobre una solicitud
 * @author Jennifer Perez
 * @author Ricardo Patino
 */

@Path("solicitud")
@Component
public class SolicitudWebService {
	
	private static final Log log = LogFactory.getLog(SolicitudWebService.class);
	
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
	@Path("/consultarSolicitud")
	public Response consultarSolicitud(@QueryParam("id") int id){
		try{
			return Response.ok(solicitudService.consultarSolicitud(id)).build();
		}catch(IllegalArgumentException iae){
			iae.printStackTrace();
			log.error(iae.getStackTrace());
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	/**
	 * Permite insertar una nueva solicitud
	 * @param solicitud nueva solicitud
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 * @throws EmailException 
	 * @throws WebApplicationException cuando no es posible insertar la solicitud
	 */	
	@POST
	@Path("/realizarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response realizarSolicitud(SolicitudWS solicitud) throws EmailException{
		try{
			return Response.ok(solicitudService.guardarSolicitud(solicitud)+"").build();
		}catch(IllegalStateException e){
			log.error(e.getStackTrace());
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
		
	}
	
	/**
	 * Permite consultar una lista de solicitudes por sucursal
	 * @param codigoSucursal codigo de la sucursal por la que se consulta
	 * @return Response respuesta con la lista de solicitudes que tienen asignada la sucursal @param y un codigo que indica si la peticion fue fallida o no
	 * @throws WebApplicationException cuando no es posible consultar las solicitudes
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarPorSucursal/{codigoSucursal}")
	public Response consultarPorSucursal(@PathParam("codigoSucursal") String codigoSucursal){
		try{
			List<Solicitud> listaDeSolicitudes = solicitudService.consultarPorSucursal(codigoSucursal);
			GenericEntity<List<Solicitud>> entity = new GenericEntity<List<Solicitud>>(listaDeSolicitudes){};
			return Response.ok(entity).build();
		}catch(IllegalArgumentException iae){
			log.error(iae.getStackTrace());
			iae.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	/**
	 * Permite insertar la respuesta a una solicitud
	 * @param id identificador de la solicitud
	 * @param respuesta nueva respuesta a la solicitud
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 * @throws WebApplicationException | EmailException cuando no es posible responder la solicitud
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
			log.error(e.getStackTrace());
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
	}
	
	/**
	 * Permite realizar la busqueda de las solicitudes con cierto estado
	 * @param estado estado de las solicitudes a buscar
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarPorEstado")
	public Response consultarPorEstado(@QueryParam("estado") String estado){
		try{
			ArrayList<Solicitud> listaDeSolicitudes = (ArrayList<Solicitud>) solicitudService.consultarPorEstado(estado);
			GenericEntity<ArrayList<Solicitud>> entity = new GenericEntity<ArrayList<Solicitud>>(listaDeSolicitudes){};
			return Response.ok(entity,MediaType.APPLICATION_JSON).build();
		}catch(IllegalArgumentException iae){
			log.error(iae.getStackTrace());
			iae.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	/**
	 * Permite relizar asignar una solicitud a un analista
	 * @param idSolicitud ID de la solicitud a asignar
	 * @param dniAnalista DNI del analista a quien se va a asignar la solicitud
	 * @return Response respuesta con un codigo que indica si la peticion fue fallida o no
	 */
	@GET
	@Path("/asignarSolicitudAAnalista")
	public Response asignarSolicitud(@QueryParam("idSolicitud") int idSolicitud, @QueryParam("dniAnalista") String dniAnalista){
		try {
			solicitudService.DelegarSolicitud(idSolicitud, dniAnalista);
			return Response.ok().build();
		} catch (IllegalStateException | EmailException e) {
			log.error(e.getStackTrace());
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obtenerSolicitudesPorAnalista")
	public Response obtenerSolicitudesPorAnalista(@QueryParam("dni") String dni){
		try{
			List<Solicitud> listaDeSolicitudes = solicitudService.consultarSolicitudesPorAnalista(dni);
			GenericEntity<List<Solicitud>> entity = new GenericEntity<List<Solicitud>>(listaDeSolicitudes){};
			if(listaDeSolicitudes.isEmpty()){
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}
			return Response.ok(entity).build();
		}catch(IllegalArgumentException iae){
			log.error(iae.getStackTrace());
			iae.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	public void setSolicitudService(ISolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}

}
