package exceptions;

public class DurationException extends Exception{

    String message;
	
	public DurationException (String message) 
	{
		this.message = message;
		System.out.println(message);
	}
}
