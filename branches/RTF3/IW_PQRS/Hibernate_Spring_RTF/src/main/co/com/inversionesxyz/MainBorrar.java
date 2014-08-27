package co.com.inversionesxyz;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.inversionesxyz.bussinesslogic.IProductoService;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.exception.BasicDBOperationException;

import com.google.gson.Gson;

public class MainBorrar {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-configuration.xml" });
		IProductoService service = (IProductoService) context
				.getBean("productoService");

		try {
			Gson gson = new Gson();
			

			List<Producto> productos = (List<Producto>) service.consultarProductos();
			System.out.println(gson.toJson(productos));
			
			
		} catch (BasicDBOperationException e) {
			e.printStackTrace();
		}

		context.close();

	}

}