package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Solicitud;


public interface ISolicitudDAO {
	public void persist(Solicitud analistaDAO);
	public void attachDirty(Solicitud instance);
	public void delete(Solicitud persistentInstance);
	public Solicitud findById(String id);
}