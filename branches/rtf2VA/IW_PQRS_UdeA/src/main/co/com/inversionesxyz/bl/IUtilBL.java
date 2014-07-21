package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IUtilBL {

	public void notificarSolicitudACliente(String idSolicitud,
			String nombreCliente, String emailCliente) throws BasicDBOperationException;

	public void notificarSolicitudDelegada(String idSolicitud,
			String nombreAnalista, String emailAnalista) throws BasicDBOperationException;

	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente) throws BasicDBOperationException;
}