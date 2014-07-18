package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Encuesta;

public interface IEncuestaDAO {
	public void persist(Encuesta analistaDAO);
	public void attachDirty(Encuesta instance);
	public void delete(Encuesta persistentInstance);
	public Encuesta findById(String id);
}
