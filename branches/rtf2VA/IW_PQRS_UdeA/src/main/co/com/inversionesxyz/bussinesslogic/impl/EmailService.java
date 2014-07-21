package co.com.inversionesxyz.bussinesslogic.impl;

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

public class EmailService {

	public void enviar(String receiver, String subject, String body) throws BasicDBOperationException {
		try {
			ResourceBundle configuracion = ResourceBundle.getBundle("email-configuration");
			Properties properties = System.getProperties();
			properties.setProperty(
					"mail.smtp.host",
					configuracion.getString("mail.smtp.host"));

			properties.setProperty(
					"mail.smtp.starttls.enable",
					configuracion.getString("mail.smtp.starttls.enable"));

			properties.setProperty(
					"mail.smtp.port",
					configuracion.getString("mail.smtp.port"));

			properties.setProperty(
					"mail.smtp.auth",
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
