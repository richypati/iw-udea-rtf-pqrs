package co.com.inversionesxyz;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.inversionesxyz.bussinesslogic.IAnalistaService;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.exception.BasicDBOperationException;

import com.google.gson.Gson;

public class MainBorrar {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-configuration.xml" });
		IAnalistaService service = (IAnalistaService) context
				.getBean("analistaService");

		try {
			Gson gson = new Gson();
			

			List<InformacionAnalista> infoAnalistas = (List<InformacionAnalista>) service.consultarAnalistas();
			System.out.println(gson.toJson(infoAnalistas));
			
			
		} catch (BasicDBOperationException e) {
			e.printStackTrace();
		}

		context.close();

	}

}