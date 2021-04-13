package exceptions;

public class InproperInputException  extends Exception{

	public String message;
		
	public InproperInputException (int measure, int row, int col) 
	{
		this.message = "Bad Tab! measure: " + measure + ", row: " + row + ", col: " + col;
	}
	
}
