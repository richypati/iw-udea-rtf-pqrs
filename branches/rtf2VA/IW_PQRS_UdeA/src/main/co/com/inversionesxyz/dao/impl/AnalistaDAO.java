package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.inversionesxyz.dao.IAnalistaDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.exception.BasicDBOperationException;


/**
 * Clase que define las operaciones a realizar en base de datos sobre un Analista como detalle de un mensaje
 * @see .InformacionAnalista
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 */
public class AnalistaDAO extends AbstractDAO<InformacionAnalista> implements IAnalistaDAO{

	public AnalistaDAO() {
		super(InformacionAnalista.class);
	}

	private static final Log log = LogFactory.getLog(AnalistaDAO.class);

	@Override
	public InformacionAnalista consultarPorCodigo(String codigo) throws BasicDBOperationException  {
		try{
			return getByField(codigo);
		}catch (Exception e) {
			log.error(MessageFormat.format(
					"No fue posible consultar el analista con codigo {0}. Causa {1}",
					codigo,
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar el analista con codigo {0}",
					codigo));
		}
		
	}
		
	
	
}
