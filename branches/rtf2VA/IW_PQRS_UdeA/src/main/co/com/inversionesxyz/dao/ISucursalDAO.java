package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Sucursal;
import co.com.inversionesxyz.exception.InexistentObjectException;

/**
 * Interface que define los metodos que va a proveer el dao de Sucursal
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 *
 */
public interface ISucursalDAO {
	/**
	 * Permite consultar la información de una sucursal por el codigo de la misma
	 * @param codigo codigo de una sucursal
	 * @return Sucursal
	 * @throws InexistentObjectException
	 */
	public Sucursal consultarPorCodigo(String codigo) throws InexistentObjectException;
}
