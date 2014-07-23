package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre un Producto
 * @see .Producto
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class ProductoDAO extends AbstractDAO<Producto> implements IProductoDAO{

	public ProductoDAO() {
		super(Producto.class);
	}

	@Override
	public Producto consultarPorCodigo(String codigo){
		try{
			return getByField(codigo);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar el producto {0}",
					codigo), e.getCause());
		}
	}

	@Override
	public void insertar(Producto producto) {
		try{
			insert(producto);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar el producto de codigo {0}",
					producto.getCodigo()), e.getCause());
		}		
	}
	
}
