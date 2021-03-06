package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.dao.IAnalistaDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre un Analista como detalle de un mensaje
 * @see .InformacionAnalista
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class AnalistaDAO extends AbstractDAO<InformacionAnalista> implements IAnalistaDAO{

	public AnalistaDAO() {
		super(InformacionAnalista.class);
	}

	@Override
	public InformacionAnalista consultarPorCodigo(String codigo) {
		try{
			return getByField(codigo);
		}catch (Exception e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar el analista con codigo {0}",
					codigo), e.getCause());
		}
		
	}
		
	
	
}
