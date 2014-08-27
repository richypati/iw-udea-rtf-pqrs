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

import co.com.inversionesxyz.bussinesslogic.IProductoService;

/**
 * Clase que implementa las operaciones basadas en servicios web Rest a realizar sobre un producto
 * @author Jennifer Perez
 * @author Ricardo Patino
 */

@Path("producto")
@Component
public class ProductoWebService {
	
	private static final Log log = LogFactory.getLog(ProductoWebService.class);
	
	@Autowired
	private IProductoService productoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarTodos")
	public Response consultarProductos(){
		try{
			return Response.ok(productoService.consultarProductos()).build();
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	public void setProductoService(IProductoService productoService) {
		this.productoService = productoService;
	}
}
