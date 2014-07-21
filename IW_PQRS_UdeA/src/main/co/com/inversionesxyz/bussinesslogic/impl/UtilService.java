package co.com.inversionesxyz.bussinesslogic.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.bussinesslogic.IEmailService;
import co.com.inversionesxyz.bussinesslogic.IUtilService;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class UtilService implements IUtilService {

	IEmailService emailBL;

	@Override
	public void notificarSolicitudACliente(String idSolicitud,
			String nombreCliente, String emailCliente)
			throws BasicDBOperationException {

		String subjectSolicitudACliente = "Solicitud Enviada";
		String body = MessageFormat.format(
				"Apreciado(a) {0}, su solicitud ha sido abierta con id: {1}.",
				nombreCliente, 
				idSolicitud);

		emailBL.enviar(emailCliente, subjectSolicitudACliente, body);

	}

	@Override
	public void notificarSolicitudDelegada(String idSolicitud,
			String nombreAnalista, String emailAnalista)
			throws BasicDBOperationException {

		String subjectSolicitudDelegada = "Se le ha delegado una solicitud";
		String body = MessageFormat.format(
				"Apreciado(a) {0}, la solicitud ha con id {1} le ha sido delegada.",
				nombreAnalista, 
				idSolicitud);

		emailBL.enviar(emailAnalista, subjectSolicitudDelegada, body);
	}

	@Override
	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente) throws BasicDBOperationException {

		String subjectRespuestaALaSolicitud = "Respuesta a la solicitud";
		String body= MessageFormat.format(
				"Apreciado(a) {0}, esta es la respuesta a la solicitud con id {1}: {2}",
				solicitud.getNombreCliente(),
				solicitud.getId(),
				solicitud.getRespuestaSolicitud());
		
		emailBL.enviar(emailCliente, subjectRespuestaALaSolicitud, body);
	}
}
