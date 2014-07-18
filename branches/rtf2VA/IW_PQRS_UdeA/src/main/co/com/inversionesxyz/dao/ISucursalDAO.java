package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Sucursal;


public interface ISucursalDAO {
	public void persist(Sucursal analistaDAO);
	public void attachDirty(Sucursal instance);
	public void delete(Sucursal persistentInstance);
	public Sucursal findById(String id);
}
