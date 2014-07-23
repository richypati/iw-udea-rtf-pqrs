package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.bussinesslogic.IUtilService;
import co.com.inversionesxyz.dao.IAnalistaDAO;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.EmailException;

/**
 * Clase que define las operaciones a realizar sobre las solicitudes
 * 
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SolicitudService implements ISolicitudService {

	@Autowired
	ISolicitudDAO solicitudDAO;
	
	@Autowired
	IAnalistaDAO analistaDAO;
	
	IUtilService utilService = new UtilService();

	@Override
	public void guardarSolicitud(Solicitud solicitud) {
		Calendar calendar = Calendar.getInstance();
		solicitud.setEstado("ABIERTO");
		solicitud.setFechaCreacion(calendar.getTime());
		solicitudDAO.insertar(solicitud);
	}

	@Override
	public Solicitud consultarSolicitud(int idSolicitud) {
		return solicitudDAO.consultar(idSolicitud);
	}

	@Override
	public void DelegarSolicitud(int idSolicitud, String dni) throws EmailException {
		Solicitud solicitud=solicitudDAO.consultar(idSolicitud);
		InformacionAnalista infoAnalista = analistaDAO.consultarPorCodigo(dni);
		solicitud.setInformacionAnalista(infoAnalista);
		solicitudDAO.actualizar(solicitud);
		utilService.notificarSolicitudDelegada(idSolicitud, infoAnalista.getNombre(), infoAnalista.getCorreo());
	}

	@Override
	public void ResponderSolicitud(Solicitud solicitud, String respuesta) throws EmailException {
		Calendar calendar = Calendar.getInstance();
		solicitud.setEstado("RESUELTO");
		solicitud.setRespuestaSolicitud(respuesta);
		solicitud.setFechaAtencion(calendar.getTime());
		solicitudDAO.actualizar(solicitud);
		utilService.notificarRespuestaALaSolicitud(solicitud, solicitud.getEmailCliente());
	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
		return solicitudDAO.consultarColeccion("estado",estado);
	}

	@Override
	public void CancelarSolicitud(int idSolicitud, String emailCliente, String motivo) throws EmailException {
		solicitudDAO.actualizarEstado(idSolicitud, "CANCELADO");
		utilService.notificarSolicitudCancelada(idSolicitud, emailCliente, motivo);
	}
	
	@Override
	public void ActualizarSolicitud(Solicitud solicitud){
		solicitudDAO.actualizar(solicitud);
	}

}
