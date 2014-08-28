package co.com.inversionesxyz.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.inversionesxyz.bussinesslogic.IAnalistaService;

@Path("analista")
@Component
public class AnalistaWebService {

	private static final Log log = LogFactory.getLog(AnalistaWebService.class);
	
	@Autowired
	private IAnalistaService analistaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarTodos")
	public Response consultarInfoAnalistas() {
		try{
			return Response.ok(analistaService.consultarAnalistas()).build();
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	public void setAnalistaService(IAnalistaService analistaService) {
		this.analistaService = analistaService;
	}
}
