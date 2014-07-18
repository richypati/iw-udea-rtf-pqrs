package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Analista;

/**
 * @author ricardo
 *
 */
public interface IAnalistaDAO {
	public void persist(Analista analista);
	public void attachDirty(Analista instance);
	public void delete(Analista persistentInstance);
	public Analista findById(String id);
}
