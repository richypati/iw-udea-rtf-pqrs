package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.IEncuestaService;
import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;

/**
 * Clase que define las operaciones a realizar sobre las encuestas
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class EncuestaService implements IEncuestaService {

	@Autowired
	IEncuestaDAO encuestaDAO;

	@Override
	public void almacenarEncuesta(int idSolicitud, String respuestaPreguntaA, String respuestaPreguntaB)  {
		Calendar calendar = Calendar.getInstance();
		
		Encuesta encuesta = new Encuesta();
		encuesta.setSolicitudId(idSolicitud);
		encuesta.setRespuestaPreguntaA(respuestaPreguntaA);
		encuesta.setRespuestaPreguntaB(respuestaPreguntaB);
		encuesta.setFechaEnvio(calendar.getTime());

		encuestaDAO.insertar(encuesta);
	}

}
