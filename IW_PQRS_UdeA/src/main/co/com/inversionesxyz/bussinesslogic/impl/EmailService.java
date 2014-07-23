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

import co.com.inversionesxyz.bussinesslogic.IEmailService;
import co.com.inversionesxyz.exception.EmailException;

/**
 * Clase que define las operaciones a realizar sobre los correos electronicos
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class EmailService implements IEmailService{

	public void enviar(String receiver, String subject, String body) throws EmailException {
		try {
			ResourceBundle configuracion = ResourceBundle.getBundle("email-configuracion");
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
			throw new EmailException(
					"El e-mail ingresado es invalido",
					e);
		} catch (MessagingException e) {
			throw new EmailException(e);
		}
	}
}
