package tab2xml;

public class DrumNoteType {
	
	String noteType;
	
	// need to leave duration 
	
	public String DrumNoteLength (int duration)
	
	{
		
		if (duration == 1)
		{
			noteType = "16th";
		}
		else if (duration == 2)
		{
			noteType = "eighth";
		}
		else if (duration == 4)
		{
			noteType = "quarter";
		}
		else if (duration == 8)
		{
			noteType = "half";
		}
		else if (duration == 16)
		{
			noteType = "whole";
		}
		else
		{
			noteType = "Incorrect  Value";
		}
		
	return noteType;	
		
	}
	
}

