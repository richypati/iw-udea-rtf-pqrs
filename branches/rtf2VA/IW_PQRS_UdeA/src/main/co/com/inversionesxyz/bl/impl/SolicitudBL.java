package co.com.inversionesxyz.bl.impl;

import java.util.List;

import co.com.inversionesxyz.bl.ISolicitudBL;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;

public class SolicitudBL implements ISolicitudBL {

	ISolicitudDAO solicitudDAO;

	@Override
	public void guardarSolicitud(Solicitud solicitud) {
		
		

	}

	@Override
	public void actualizarSolicitud(Solicitud solicitud) {
		// TODO Auto-generated method stub

	}

	@Override
	public Solicitud consultarSolicitud(String idSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DelegarSolicitud(String idSolicitud, String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ResponderSolicitud(String idSolicitud, String respuesta) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Solicitud> obtenerSolicitudes(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CancelarSolicitud(String idSolicitud, String motivo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarEstadoSolicitud(String idSolicitud, String estado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void responderEncuesta(String idSolicitud,
			String respuestaPreguntaUno, String respuestaPreguntaDos) {
		// TODO Auto-generated method stub

	}

}
