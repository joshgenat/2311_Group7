package exceptions;

public class InproperInputException  extends Exception{

	String message;
		
	public InproperInputException (String message) 
	{
		this.message = message;
	}
	
}
