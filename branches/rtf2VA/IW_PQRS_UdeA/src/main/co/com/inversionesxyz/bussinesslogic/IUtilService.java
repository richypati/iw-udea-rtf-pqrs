package co.com.inversionesxyz.bussinesslogic;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IUtilService {

	public void notificarSolicitudACliente(String idSolicitud,
			String nombreCliente, String emailCliente) throws BasicDBOperationException;

	public void notificarSolicitudDelegada(String idSolicitud,
			String nombreAnalista, String emailAnalista) throws BasicDBOperationException;

	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente) throws BasicDBOperationException;
}