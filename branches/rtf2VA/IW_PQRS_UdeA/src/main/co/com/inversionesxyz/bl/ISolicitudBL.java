package co.com.inversionesxyz.bl;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface ISolicitudBL {

	public void guardarSolicitud(Solicitud solicitud)
			throws BasicDBOperationException;

	public Solicitud consultarSolicitud(String idSolicitud)
			throws BasicDBOperationException;

	public void DelegarSolicitud(String idSolicitud, String dni)
			throws BasicDBOperationException;

	public void ResponderSolicitud(String idSolicitud, String respuesta)
			throws BasicDBOperationException;

	public List<Solicitud> obtenerSolicitudesPorEstado(String estado)
			throws BasicDBOperationException;

	public void CancelarSolicitud(String idSolicitud, String motivo)
			throws BasicDBOperationException;

	public void actualizarEstadoSolicitud(String idSolicitud, String estado)
			throws BasicDBOperationException;

	
}
