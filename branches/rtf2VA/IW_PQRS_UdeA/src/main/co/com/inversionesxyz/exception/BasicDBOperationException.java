package co.com.inversionesxyz.exception;

public class BasicDBOperationException extends Exception{
	
private static final long serialVersionUID = 1L;
	
	public BasicDBOperationException(){}
	
	public BasicDBOperationException(String message){
		super(message);
	}
	
	public BasicDBOperationException(Throwable cause){
		super(cause);
	}
	
	public BasicDBOperationException(String message, Throwable cause){
		super (message, cause);
	}

}
