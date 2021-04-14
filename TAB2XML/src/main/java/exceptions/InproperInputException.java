package exceptions;

public class InproperInputException  extends Exception{

	public String message;
		
	public InproperInputException (int measure, int row, int col) 
	{
		this.message = "Measure: " + measure + ", row: " + row + ", col: " + col;
	}
	
}
