package co.com.inversionesxyz.bl.impl;

import java.util.Date;

import co.com.inversionesxyz.bl.IEncuestaBL;
import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class EncuestaBL implements IEncuestaBL {

	IEncuestaDAO encuestaDAO;

	@Override
	public void responderEncuesta(int idSolicitud, String respuestaPreguntaA,
			String respuestaPreguntaB) throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(respuestaPreguntaA)) {
			throw new BasicDBOperationException(
					"La respuesta A no puede ser vacía.");
		}
		if ("".equals(respuestaPreguntaB)) {
			throw new BasicDBOperationException(
					"La respuesta B no puede ser vacía.");
		}

		Encuesta encuesta = new Encuesta();
		encuesta.setSolicitudId(idSolicitud);
		encuesta.setRespuestaPreguntaA(respuestaPreguntaA);
		encuesta.setRespuestaPreguntaB(respuestaPreguntaB);
		encuesta.setFechaEnvio(new Date());

		encuestaDAO.insertar(encuesta);
	}

}
