package co.com.inversionesxyz.exception;

public class InexistentObjectException extends Exception{
	
private static final long serialVersionUID = 1L;
	
	public InexistentObjectException(){}
	
	public InexistentObjectException(String message){
		super(message);
	}
	
	public InexistentObjectException(Throwable cause){
		super(cause);
	}
	
	public InexistentObjectException(String message, Throwable cause){
		super (message, cause);
	}

}
