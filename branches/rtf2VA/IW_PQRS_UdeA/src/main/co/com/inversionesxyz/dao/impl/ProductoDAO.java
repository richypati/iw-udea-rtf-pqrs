package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre un Producto
 * @see .Producto
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 */
public class ProductoDAO extends AbstractDAO<Producto> implements IProductoDAO{

	public ProductoDAO() {
		super(Producto.class);
	}

	private static final Log log = LogFactory.getLog(ProductoDAO.class);

	@Override
	public Producto consultarPorCodigo(String codigo) throws BasicDBOperationException {
		try{
			return getByField(codigo);
		}catch(Exception e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible consultar el producto {0}. Causa {1}",
					codigo,
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar el producto {0}",
					codigo));
		}
	}

	@Override
	public void insertar(Producto producto) throws BasicDBOperationException {
		try{
			insert(producto);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible insertar el producto de codigo {0}. Causa {1}",
					producto.getCodigo(),
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar el producto de codigo {0}",
					producto.getCodigo()));
		}		
	}
	
}
