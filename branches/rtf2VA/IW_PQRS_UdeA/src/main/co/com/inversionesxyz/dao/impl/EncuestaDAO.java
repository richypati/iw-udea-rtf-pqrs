package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Encuesta
 * @see .Encuesta
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 */
public class EncuestaDAO extends AbstractDAO<Encuesta> implements IEncuestaDAO{
	
	public EncuestaDAO() {
		super(Encuesta.class);
	}

	private static final Log log = LogFactory.getLog(EncuestaDAO.class);


	@Override
	public Encuesta consultarPorSolicitud(int idSolicitud) throws BasicDBOperationException {
		try{
			return getByField(idSolicitud);
		}catch(Exception e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible consultar la encuesta de la solicitud {0}. Causa {1}",
					idSolicitud,
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la encuesta de la solicitud {0}",
					idSolicitud));
		}
		
	}

	@Override
	public void insertar(Encuesta encuesta) throws BasicDBOperationException {
		try{
			insert(encuesta);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible insertar la encuesta de la solicitud {0}. Causa {1}",
					encuesta.getSolicitudId(),
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar la encuesta de la solicitud {0}",
					encuesta.getSolicitudId()));
		}
	}

	@Override
	public void eliminar(Encuesta encuesta) throws BasicDBOperationException {
		try{
			delete(encuesta);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible eliminar la encuesta de la solicitud {0}. Causa {1}",
					encuesta.getSolicitudId(),
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible eliminar la encuesta de la solicitud {0}",
					encuesta.getSolicitudId()));
		}
	}
		
}
