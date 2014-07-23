package co.com.inversionesxyz.bussinesslogic.impl;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.IEmailService;
import co.com.inversionesxyz.bussinesslogic.IUtilService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.EmailException;

/**
 * Clase que define las operaciones a realizar sobre las notificaciones que se
 * hacen a los clientes sobre las operaciones que realiza en el sistema y ue
 * requieren del envio de un correo electronico
 * 
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class UtilService implements IUtilService {

	@Autowired
	IEmailService emailBL;

	@Override
	public void notificarSolicitudACliente(int idSolicitud,
			String nombreCliente, String emailCliente) throws EmailException {

		String subjectSolicitudACliente = "Solicitud Enviada";
		String body = MessageFormat.format(
				"Apreciado(a) {0}, su solicitud ha sido abierta con id: {1}.",
				nombreCliente, idSolicitud);

		emailBL.enviar(emailCliente, subjectSolicitudACliente, body);

	}

	@Override
	public void notificarSolicitudDelegada(int idSolicitud,
			String nombreAnalista, String emailAnalista) throws EmailException {

		String subjectSolicitudDelegada = "Se le ha delegado una solicitud";
		String body = MessageFormat
				.format("Apreciado(a) {0}, la solicitud ha con ID {1} le ha sido delegada.",
						nombreAnalista, idSolicitud);

		emailBL.enviar(emailAnalista, subjectSolicitudDelegada, body);
	}

	@Override
	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente) throws EmailException {

		String subjectRespuestaALaSolicitud = "Respuesta a la solicitud";
		String body = MessageFormat
				.format("Apreciado(a) {0}, esta es la respuesta a la solicitud con ID {1}: {2}",
						solicitud.getNombreCliente(), solicitud.getId(),
						solicitud.getRespuestaSolicitud());

		emailBL.enviar(emailCliente, subjectRespuestaALaSolicitud, body);
	}

	@Override
	public void notificarSolicitudCancelada(int idSolicitud,
			String emailCliente, String motivo) throws EmailException {

		String subjectSolicitudCancelada = "Solicitud Cancelada";
		String body = MessageFormat
				.format("Apreciado cliente, la solicitud con ID {1} ha sido cancelada por el siguiente motivo: {2}",
						idSolicitud, motivo);

		emailBL.enviar(emailCliente, subjectSolicitudCancelada, body);
	}
}
