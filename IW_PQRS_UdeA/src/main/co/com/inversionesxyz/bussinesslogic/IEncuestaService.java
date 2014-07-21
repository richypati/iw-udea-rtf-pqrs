package co.com.inversionesxyz.bussinesslogic;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEncuestaService {

	public void responderEncuesta(int idSolicitud,
			String respuestaPreguntaA, String respuestaPreguntaB)
			throws BasicDBOperationException;
	
}
