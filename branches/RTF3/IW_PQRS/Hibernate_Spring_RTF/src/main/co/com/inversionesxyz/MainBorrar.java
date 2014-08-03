package co.com.inversionesxyz;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class MainBorrar {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-configuration.xml" });
		ISolicitudService service = (ISolicitudService) context
				.getBean("solicitudService");

		int idSolicitud = 1;
		Solicitud solicitud = null;
		try {
			solicitud = service.consultarSolicitud(idSolicitud);
		} catch (BasicDBOperationException e) {
			e.printStackTrace();
		}

		if (solicitud == null) {
			System.out.println("La solicitud es nula");
		} else {
			System.out.println("Descripcion Solicitud: "
					+ solicitud.getDescripcion());
		}

		context.close();

	}

}