package co.com.inversionesxyz.bl;

import co.com.inversionesxyz.exception.BasicDBOperationException;

public interface IEmailBL {
	public void enviar(String receiver, String subject, String body)
			throws BasicDBOperationException;
}
