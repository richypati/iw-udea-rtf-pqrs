package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;
import java.util.List;

import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Solicitud
 * @see .Solicitud
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SolicitudDAO extends AbstractDAO<Solicitud> implements ISolicitudDAO{

	public SolicitudDAO() {
		super(Solicitud.class);
	}

	@Override
	public Solicitud consultar(String campo) {
		try{
			return getByField(campo);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la solicitud por campo: {0}",
					campo), e.getCause());
		}
	}

	@Override
	public void insertar(Solicitud solicitud) {
		try{
			insert(solicitud);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar la solicitud del cliente {0}",
					solicitud.getEmailCliente()), e.getCause());
		}		
	}

	@Override
	public List<Solicitud> consultarColeccion(String campo) {
		try{
			return consultarColeccion(campo);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la lista de solicitudes por campo: {0}",
					campo), e.getCause());
		}
	}

	@Override
	public void actualizar(Solicitud solicitud) {
		try{
			update(solicitud);
		}catch(Exception e){
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible actualizar la solicitud {0}",
					solicitud.getId()), e.getCause());
		}
	}
	

	
	
}
