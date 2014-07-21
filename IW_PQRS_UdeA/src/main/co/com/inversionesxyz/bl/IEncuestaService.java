package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEncuestaService {

	public Encuesta consultarPorSolicitud(int idSolicitud) throws BasicDBOperationException;
	
}
