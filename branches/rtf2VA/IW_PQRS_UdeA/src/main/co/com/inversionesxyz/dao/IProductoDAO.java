package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Producto;

/**
 * Interface que define los metodos que va a proveer el dao de Producto
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 *
 */
public interface IProductoDAO {
	/**
	 * Permite consultar la información de un producto por el codigo del mismo
	 * @param codigo codigo de un producto
	 * @return Producto
	 */
	public Producto consultarPorCodigo(String codigo);
	
	/**
	 * Permite insertar un producto en la base de datos
	 * @param producto producto a insertar
	 */
	public void insertar(Producto producto);
}
