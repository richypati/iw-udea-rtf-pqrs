//package co.com.inversionesxyz;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import co.com.inversionesxyz.bl.IEncuestaService;
//import co.com.inversionesxyz.dto.Encuesta;
//import co.com.inversionesxyz.exception.BasicDBOperationException;
//
//public class MainBorrar {
//
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = 
//				new ClassPathXmlApplicationContext(new String[]{"spring-configuration.xml"});
//		IEncuestaService service = (IEncuestaService) context.getBean("encuestaService");
//
//		int idSolicitud = 1;
//		Encuesta encuesta = null;
//		try {
//			encuesta = service.consultarPorSolicitud(idSolicitud);
//		} catch (BasicDBOperationException e) {
//			e.printStackTrace();
//		}
//		
//		if (encuesta == null){
//			System.out.println("La encuesta es nula");
//		}else{
//			System.out.println("Respuesta Pregunta A: "+ encuesta.getRespuestaPreguntaA());
//		}
//		
//		context.close();
//
//	}
//
//}
