package co.com.inversionesxyz.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path ("prueba")
public class Servicio {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/get")
	public String Get() {
		return "HOLAAA";
	}
}


