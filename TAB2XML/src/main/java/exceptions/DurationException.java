package exceptions;

public class DurationException extends Exception{

    public String message;
	
	public DurationException (String message) 
	{
		this.message = message;
	}
}
