package co.com.inversionesxyz.bl;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;

public interface ISolicitudBL {

	public void guardarSolicitud(Solicitud solicitud);

	public void actualizarSolicitud(Solicitud solicitud);

	public Solicitud consultarSolicitud(String idSolicitud);

	public void DelegarSolicitud(String idSolicitud, String dni);

	public void ResponderSolicitud(String idSolicitud, String respuesta);

	public List<Solicitud> obtenerSolicitudes(String estado);
	
	public void CancelarSolicitud(String idSolicitud, String motivo);
	
	public void actualizarEstadoSolicitud(String idSolicitud, String estado);
	
	public void responderEncuesta(String idSolicitud, String respuestaPreguntaUno, String respuestaPreguntaDos);
}
