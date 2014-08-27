package co.com.inversionesxyz.bussinesslogic;

import java.util.List;

import co.com.inversionesxyz.dto.Producto;

/**
 * Interface que define los metodos que va a proveer la logica de negocio de la gestion de productos
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface IProductoService {
	
	/**
	 * Permite realizar la consulta de todos los productos
	 * @return List<Producto> Lista de productos
	 */
	public List<Producto> consultarProductos();
}
