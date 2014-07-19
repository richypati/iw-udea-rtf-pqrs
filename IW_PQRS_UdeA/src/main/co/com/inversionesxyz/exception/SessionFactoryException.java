package co.com.inversionesxyz.exception;

public class SessionFactoryException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SessionFactoryException(){}
	
	public SessionFactoryException(String message){
		super(message);
	}
	
	public SessionFactoryException(Throwable cause){
		super(cause);
	}
	
	public SessionFactoryException(String message, Throwable cause){
		super (message, cause);
	}

}
