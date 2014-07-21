package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una Solicitud
 * @see .Solicitud
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 */
public class SolicitudDAO extends AbstractDAO<Solicitud> implements ISolicitudDAO{

	public SolicitudDAO() {
		super(Solicitud.class);
	}

	private static final Log log = LogFactory.getLog(SolicitudDAO.class);

	@Override
	public Solicitud consultar(String campo) throws BasicDBOperationException {
		try{
			return getByField(campo);
		}catch(Exception e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible consultar la solicitud por campo: {0}. Causa {1}",
					campo,
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la solicitud por campo: {0}",
					campo));
		}
	}

	@Override
	public void insertar(Solicitud solicitud) throws BasicDBOperationException {
		try{
			insert(solicitud);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible insertar la solicitud del cliente {0}. Causa {1}",
					solicitud.getEmailCliente(),
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar la solicitud del cliente {0}",
					solicitud.getEmailCliente()));
		}		
	}

	@Override
	public List<Solicitud> consultarColeccion(String campo) throws BasicDBOperationException {
		try{
			return consultarColeccion(campo);
		}catch(Exception e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible consultar la lista de solicitudes por campo: {0}. Causa {1}",
					campo,
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la lista de solicitudes por campo: {0}",
					campo));
		}
	}

	@Override
	public void actualizar(Solicitud solicitud) throws BasicDBOperationException {
		try{
			update(solicitud);
		}catch(Exception e){
			log.error(MessageFormat.format(
					"No fue posible actualizar la solicitud {0}. Causa {1}",
					solicitud.getId(),
					e.getCause()));
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible actualizar la solicitud {0}",
					solicitud.getId()));
		}
	}
	

	
	
}
