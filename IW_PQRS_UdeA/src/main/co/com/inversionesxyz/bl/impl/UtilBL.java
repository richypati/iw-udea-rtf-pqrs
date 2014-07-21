package co.com.inversionesxyz.bl.impl;

import java.text.MessageFormat;

import co.com.inversionesxyz.bl.IEmailBL;
import co.com.inversionesxyz.bl.IUtilBL;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class UtilBL implements IUtilBL {

	IEmailBL emailBL;

	@Override
	public void notificarSolicitudACliente(String idSolicitud,
			String nombreCliente, String emailCliente)
			throws BasicDBOperationException {

		String subjectSolicitudACliente = "Solicitud Enviada";
		String body = MessageFormat.format(
				"Señor {1}, su solicitud ha sido abierta con id: {2}.",
				nombreCliente, idSolicitud);

		emailBL.enviar(emailCliente, subjectSolicitudACliente, body);

	}

	@Override
	public void notificarSolicitudDelegada(String idSolicitud,
			String nombreAnalista, String emailAnalista)
			throws BasicDBOperationException {

		String subjectSolicitudDelegada = "Se le ha delegado una solicitud";
		String body = MessageFormat.format(
				"Señor {1}, la solicitud ha con id {2} le ha sido delegada.",
				nombreAnalista, idSolicitud);

		emailBL.enviar(nombreAnalista, subjectSolicitudDelegada, body);
	}

	@Override
	public void notificarRespuestaALaSolicitud(Solicitud solicitud,
			String emailCliente) throws BasicDBOperationException {

		String subjectRespuestaALaSolicitud = "Respuesta a la solicitud";
		// String body= MessageFormat.format("Señor",);
	}

}
