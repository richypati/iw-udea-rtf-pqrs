package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Date;
import java.util.List;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class SolicitudService implements ISolicitudService {

	ISolicitudDAO solicitudDAO;

	@Override
	public void guardarSolicitud(Solicitud solicitud)
			throws BasicDBOperationException {

		if ("".equals(solicitud.getTipo())) {
			throw new BasicDBOperationException(
					"El tipo de solicitud no debe ser vacio.");
		}
		if ("".equals(solicitud.getDescripcion())) {
			throw new BasicDBOperationException(
					"La descripcion no debe ser vacia.");
		}
		if ("".equals(solicitud.getTipoDocumento())) {
			throw new BasicDBOperationException(
					"El tipo de documento no debe ser vacio.");
		}
		if ("".equals(solicitud.getNombreCliente())) {
			throw new BasicDBOperationException("El nombre no debe ser vacio.");
		}
		if ("".equals(solicitud.getEmailCliente())) {
			throw new BasicDBOperationException("El email no debe ser vacio.");
		}
		if (null == solicitud.getProducto()) {
			throw new BasicDBOperationException(
					"El producto no debe ser vacio.");
		}

		solicitud.setEstado("ABIERTO");
		solicitud.setFechaCreacion(new Date());

		solicitudDAO.insertar(solicitud);
	}

	@Override
	public Solicitud consultarSolicitud(String idSolicitud)
			throws BasicDBOperationException {

		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"ID de la solicitud vacia, se debe ingresar el ID para poder realizar la consulta.");
		}
		return solicitudDAO.consultar(idSolicitud);
	}

	@Override
	public void DelegarSolicitud(String idSolicitud, String dni)
			throws BasicDBOperationException {

		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacio.");
		}
		if ("".equals(dni)) {
			throw new BasicDBOperationException(
					"El DNI del analista no puede ser vacio.");
		}

		// solicitudDAO.delegar
	}

	@Override
	public void ResponderSolicitud(String idSolicitud, String respuesta)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacio.");
		}
		if ("".equals(respuesta)) {
			throw new BasicDBOperationException(
					"La respuesta no puede ser vacio.");
		}

	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado)
			throws BasicDBOperationException {

		if ("".equals(estado)) {
			throw new BasicDBOperationException(
					"El estado no debe ser vacio para poder realizar la consulta.");
		}

		return solicitudDAO.consultarColeccion(estado);
	}

	@Override
	public void CancelarSolicitud(String idSolicitud, String motivo)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacio.");
		}
		if ("".equals(motivo)) {
			throw new BasicDBOperationException("El motivo no puede ser vacio.");
		}

	}

	@Override
	public void actualizarEstadoSolicitud(String idSolicitud, String estado)
			throws BasicDBOperationException {
		if ("".equals(idSolicitud)) {
			throw new BasicDBOperationException(
					"El id de la solicitud no puede ser vacia.");
		}
		if ("".equals(estado)) {
			throw new BasicDBOperationException("El estado no puede ser vacio.");
		}

		//solicitudDAO.update()
	}

	

}
