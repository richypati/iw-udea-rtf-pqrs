package co.com.inversionesxyz.bl.impl;

import java.util.Date;
import java.util.List;

import co.com.inversionesxyz.bl.ISolicitudBL;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class SolicitudBL implements ISolicitudBL {

	ISolicitudDAO solicitudDAO;

	@Override
	public void guardarSolicitud(Solicitud solicitud)
			throws BasicDBOperationException {

		if ("".equals(solicitud.getTipo())) {
			throw new BasicDBOperationException(
					"El tipo de solicitud no debe ser vacía.");
		}
		if ("".equals(solicitud.getDescripcion())) {
			throw new BasicDBOperationException(
					"La descripción no debe ser vacía.");
		}
		if ("".equals(solicitud.getTipoDocumento())) {
			throw new BasicDBOperationException(
					"El tipo de documento no debe ser vacío.");
		}
		if ("".equals(solicitud.getNombreCliente())) {
			throw new BasicDBOperationException("El nombre no debe ser vacío.");
		}
		if ("".equals(solicitud.getEmailCliente())) {
			throw new BasicDBOperationException("El email no debe ser vacía.");
		}
		if (null == solicitud.getProducto()) {
			throw new BasicDBOperationException(
					"El producto no debe ser vacío.");
		}

		solicitud.setEstado("ABIERTO");
		solicitud.setFechaCreacion(new Date());

		// solicitudDAO.persist(solicitud);
	}

	@Override
	public Solicitud consultarSolicitud(String idSolicitud)
			throws BasicDBOperationException {

		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"ID de la solicitud vacía, se debe ingresar el ID para poder realizar la consulta.");
		}
		// return solicitudDAO.findByID(idSolicitud);
		return null;
	}

	@Override
	public void DelegarSolicitud(String idSolicitud, String dni)
			throws BasicDBOperationException {

		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(dni)) {
			throw new BasicDBOperationException(
					"El DNI del analista no puede ser vacío.");
		}

		// solicitudDAO.delegar
	}

	@Override
	public void ResponderSolicitud(String idSolicitud, String respuesta)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(respuesta)) {
			throw new BasicDBOperationException(
					"La respuesta no puede ser vacío.");
		}

	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado)
			throws BasicDBOperationException {

		if ("".equals(estado)) {
			throw new BasicDBOperationException(
					"El estado no debe ser vacío para poder realizar la consulta.");
		}

		// return solicitudDAO.findbyState(estado);
		return null;
	}

	@Override
	public void CancelarSolicitud(String idSolicitud, String motivo)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(motivo)) {
			throw new BasicDBOperationException("El motivo no puede ser vacío.");
		}

	}

	@Override
	public void actualizarEstadoSolicitud(String idSolicitud, String estado)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacía.");
		}
		if ("".equals(estado)) {
			throw new BasicDBOperationException("El estado no puede ser vacío.");
		}

		// solicitudDAO.update()
	}

	

}
