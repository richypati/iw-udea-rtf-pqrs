package co.com.inversionesxyz.bl.impl;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public class EmailBL {

	public void enviar(String receiver, String subject, String body) throws BasicDBOperationException {
		try {
			// Se lee el archivo de configuración
			ResourceBundle configuracion = ResourceBundle
					.getBundle("email-configuration");

			// Obtiene las propiedades
			Properties properties = System.getProperties();

			// Se configura el host
			properties.setProperty("mail.smtp.host",
					configuracion.getString("mail.smtp.host"));

			// TLS si está disponible. Encriptacion
			properties.setProperty("mail.smtp.starttls.enable",
					configuracion.getString("mail.smtp.starttls.enable"));

			// Se configura el puerto
			properties.setProperty("mail.smtp.port",
					configuracion.getString("mail.smtp.port"));

			// Se configura la autenticación

			properties.setProperty("mail.smtp.auth",
					configuracion.getString("mail.smtp.auth"));

			Session session = Session.getDefaultInstance(properties);

			MimeMessage message = new MimeMessage(session);
			System.out.println(configuracion.getString("mail.smtp.user"));
			message.setFrom(new InternetAddress(configuracion
					.getString("mail.smtp.user")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receiver));

			message.setSubject(subject);
			message.setText(body);

			Transport t = session.getTransport("smtp");
			t.connect(configuracion.getString("mail.smtp.user"),
					configuracion.getString("mail.smtp.pws"));
			t.sendMessage(message, message.getAllRecipients());
			t.close();

		} catch (AddressException e) {
			throw new BasicDBOperationException(
					"El e-mail ingresado es inválido",
					e);
		} catch (MessagingException e) {
			throw new BasicDBOperationException(e);
		}
	}
}
