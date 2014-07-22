package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;

/**
 * Clase que define las operaciones a realizar sobre las solicitudes
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SolicitudService implements ISolicitudService {

	@Autowired
	ISolicitudDAO solicitudDAO;

	@Override
	public void guardarSolicitud(Solicitud solicitud){
		Calendar calendar = Calendar.getInstance();
		
		solicitud.setEstado("ABIERTO");
		solicitud.setFechaCreacion(calendar.getTime());

		solicitudDAO.insertar(solicitud);
	}

	@Override
	public Solicitud consultarSolicitud(String idSolicitud){
		return solicitudDAO.consultar(idSolicitud);
	}

	@Override
	public void DelegarSolicitud(String idSolicitud, String dni) {
		// solicitudDAO.delegar
	}

	@Override
	public void ResponderSolicitud(String idSolicitud, String respuesta){
		// Aqui que va?
	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado){
		return solicitudDAO.consultarColeccion(estado);
	}

	@Override
	public void CancelarSolicitud(String idSolicitud, String motivo){
		// Aqui que va?
	}

	@Override
	public void actualizarEstadoSolicitud(String idSolicitud, String estado){
		//solicitudDAO.update()
	}

	

}
