package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.DetalleCliente;

public interface IDetalleClienteDAO {
	public void persist(DetalleCliente analistaDAO);
	public void attachDirty(DetalleCliente instance);
	public void delete(DetalleCliente persistentInstance);
	public DetalleCliente findById(String id);
}
