package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Producto;


public interface IProductoDAO {
	public void persist(Producto analistaDAO);
	public void attachDirty(Producto instance);
	public void delete(Producto persistentInstance);
	public Producto findById(String id);
}
