package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.InexistentObjectException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Encuesta
 * @see .Encuesta
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 */
public class EncuestaDAO extends AbstractDAO<Encuesta> implements IEncuestaDAO{
	
	public EncuestaDAO(Class<Encuesta> type) {
		super(type);
	}

	private static final Log log = LogFactory.getLog(EncuestaDAO.class);


	@Override
	public Encuesta consultarPorSolicitud(String idSolicitud) throws InexistentObjectException {
		try{
			return consultar(idSolicitud);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible consultar la encuesta de la solicitud {0}. Causa {1}",
					idSolicitud,
					e.getCause()));
			throw new InexistentObjectException(MessageFormat.format(
					"No fue posible consultar la encuesta de la solicitud {0}",
					idSolicitud));
		}
		
	}
	
	
}
