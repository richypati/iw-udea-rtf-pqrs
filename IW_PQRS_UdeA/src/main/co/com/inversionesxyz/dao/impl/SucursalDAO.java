package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.dao.ISucursalDAO;
import co.com.inversionesxyz.dto.Sucursal;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Solicitud
 * @see .Sucursal
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SucursalDAO extends AbstractDAO<Sucursal> implements ISucursalDAO{

	public SucursalDAO() {
		super(Sucursal.class);
	}

	@Override
	public Sucursal consultarPorCodigo(String codigo) {
		try{
			return getByField(codigo);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la solicitud por campo: {0}",
					codigo), e.getCause());
		}
	}

	
}
