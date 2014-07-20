package co.com.inversionesxyz.bl.impl;

import co.com.inversionesxyz.bl.IEncuestaBL;
import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class EncuestaBL implements IEncuestaBL{
	
	IEncuestaDAO encuestaDAO;

	@Override
	public void responderEncuesta(String idSolicitud,
			String respuestaPreguntaUno, String respuestaPreguntaDos) throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(respuestaPreguntaUno)) {
			throw new BasicDBOperationException("La respuesta 1 no puede ser vacía.");
		}
		if ("".equals(respuestaPreguntaDos)) {
			throw new BasicDBOperationException("La respuesta 2 no puede ser vacía.");
		}
		
		//encuestaDAO.saveRespuestas
	}

}
