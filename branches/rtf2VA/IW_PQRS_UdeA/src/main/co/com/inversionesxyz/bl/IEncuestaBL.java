package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEncuestaBL {

	public void responderEncuesta(int idSolicitud,
			String respuestaPreguntaA, String respuestaPreguntaB)
			throws BasicDBOperationException;
	
}
