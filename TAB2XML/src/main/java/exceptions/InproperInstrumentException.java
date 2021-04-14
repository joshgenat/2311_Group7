package exceptions;

public class InproperInstrumentException extends Exception{
	public String message;
	
	public InproperInstrumentException (int col) 
	{
		this.message = "Program could not indentify Drum Instrument in col: " + col;
	}
}
