package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.IProductoService;
import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dto.Producto;

/**
 * Clase que define las operaciones a realizar sobre los productos
 * 
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class ProductoService implements IProductoService{
	
	@Autowired
	IProductoDAO productoDAO;

	@Override
	public List<Producto> consultarProductos() {
		return productoDAO.consultarTodos();
	}
	
	public void setProductoDAO(IProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

}
