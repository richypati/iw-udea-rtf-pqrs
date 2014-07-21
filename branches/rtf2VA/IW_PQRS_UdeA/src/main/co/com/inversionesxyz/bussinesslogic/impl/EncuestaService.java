package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Date;

import co.com.inversionesxyz.bussinesslogic.IEncuestaService;
import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class EncuestaService implements IEncuestaService {

	IEncuestaDAO encuestaDAO;

	@Override
	public void responderEncuesta(int idSolicitud, String respuestaPreguntaA,
			String respuestaPreguntaB) throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacio.");
		}
		if ("".equals(respuestaPreguntaA)) {
			throw new BasicDBOperationException(
					"La respuesta A no puede ser vacia.");
		}
		if ("".equals(respuestaPreguntaB)) {
			throw new BasicDBOperationException(
					"La respuesta B no puede ser vacia.");
		}

		Encuesta encuesta = new Encuesta();
		encuesta.setSolicitudId(idSolicitud);
		encuesta.setRespuestaPreguntaA(respuestaPreguntaA);
		encuesta.setRespuestaPreguntaB(respuestaPreguntaB);
		encuesta.setFechaEnvio(new Date());

		encuestaDAO.insertar(encuesta);
	}

}
