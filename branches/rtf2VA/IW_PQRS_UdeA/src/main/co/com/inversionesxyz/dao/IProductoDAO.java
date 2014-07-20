package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Interface que define los metodos que va a proveer el dao de Producto
 * @author Jennifer P�rez
 * @author Ricardo Pati�o
 *
 */
public interface IProductoDAO {
	/**
	 * Permite consultar la informaci�n de un producto por el codigo del mismo
	 * @param codigo codigo de un producto
	 * @return Producto
	 * @throws BasicDBOperationException
	 */
	public Producto consultarPorCodigo(String codigo) throws BasicDBOperationException;
}
