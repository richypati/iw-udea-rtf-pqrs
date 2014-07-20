package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEncuestaBL {

	public void responderEncuesta(String idSolicitud,
			String respuestaPreguntaUno, String respuestaPreguntaDos)
			throws BasicDBOperationException;
	
}
