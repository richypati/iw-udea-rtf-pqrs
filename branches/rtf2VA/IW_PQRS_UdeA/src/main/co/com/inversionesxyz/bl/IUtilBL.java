package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.dto.Solicitud;

public interface IUtilBL {

	public void notificarSolicitudACliente(String idSolicitud,
			String nombreCliente, String emailCliente);

	public void notificarSolicitudDelegada(String idSolicitud,
			String nombreAnalista, String emailAnalista);

	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente);
}