package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Rol;

public interface IRolDAO {
	public void persist(Rol analistaDAO);
	public void attachDirty(Rol instance);
	public void delete(Rol persistentInstance);
	public Rol findById(String id);
}
