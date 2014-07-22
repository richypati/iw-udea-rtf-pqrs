package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Encuesta
 * @see .Encuesta
 * @author Jennifer Perez
 * @author Ricardo Patino
 */

public class EncuestaDAO extends AbstractDAO<Encuesta> implements IEncuestaDAO{
	
	public EncuestaDAO() {
		super(Encuesta.class);
	}

	@Override
	public Encuesta consultarPorSolicitud(int idSolicitud) {
		try{
			return getByField(idSolicitud);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la encuesta de la solicitud {0}",
					idSolicitud), e.getCause());
		}
		
	}

	@Override
	public void insertar(Encuesta encuesta) {
		try{
			insert(encuesta);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar la encuesta de la solicitud {0}",
					encuesta.getSolicitudId()), e.getCause());
		}
	}

	@Override
	public void eliminar(Encuesta encuesta) {
		try{
			delete(encuesta);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible eliminar la encuesta de la solicitud {0}",
					encuesta.getSolicitudId()), e.getCause());
		}
	}
		
}
