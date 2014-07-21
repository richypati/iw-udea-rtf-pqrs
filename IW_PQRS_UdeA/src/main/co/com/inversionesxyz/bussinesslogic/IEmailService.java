package co.com.inversionesxyz.bussinesslogic;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEmailService {
	public void enviar(String receiver, String subject, String body)
			throws BasicDBOperationException;
}
