package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Cliente;
import co.com.inversionesxyz.dto.ClienteId;


public interface IClienteDAO {
	public void persist(Cliente analistaDAO);
	public void attachDirty(Cliente instance);
	public void delete(Cliente persistentInstance);
	public Cliente findById(ClienteId id);
}
