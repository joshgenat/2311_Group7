package tab2xml;

public class DrumNoteType {
	
	String noteType;
	int dotnumber;
	
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
		else if (duration == 3)
		{
			noteType = "eighth";
			// one dot
		}
		else if (duration == 6)
		{
			noteType = "quarter";
			//one dot
		}
		else if (duration == 12)
		{
			noteType = "half";
			//one dot
		
		}
		else if (duration == 24)
		{
			noteType = "whole";
			//one dot 
		
		}
		
		else if (duration == 7)
		{
			noteType = "quarter";
			//two dot 
		
		}
		
		else if (duration == 14)
		{
			noteType = "half";
			//two dot 
		
		}
		else if (duration == 15)
		{
			noteType = "half";
			//three dots
		
		}
		else if (duration == 28)
		{
			noteType = "whole";
			//two dots
		
		}
		else if (duration == 30)
		{
			noteType = "whole";
			//three dots
		
		}
		else if (duration == 31)
		{
			noteType = "whole";
			//four dots
		
		}
		else
		{
			//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
		}
		
		
	return noteType;	
		
	}
	
public int DotValue (int duration)
	
	{
		
		
		if (duration == 6)
		{
			dotnumber = 1;
		}
		else if (duration == 12)
		{
			dotnumber = 1;
		
		}
		else if (duration == 24)
		{
			dotnumber = 1;
		
		}
		
		else if (duration == 7)
		{
			dotnumber = 2;
		
		}
		
		else if (duration == 14)
		{
			dotnumber = 2;
		
		}
		else if (duration == 15)
		{
			dotnumber = 3;
		
		}
		else if (duration == 28)
		{
			dotnumber = 2;
		
		}
		else if (duration == 30)
		{
			dotnumber = 3;
		
		}
		else if (duration == 31)
		{
			dotnumber = 4;
		
		}
		else
		{
			dotnumber = 0;
		}

		
	return dotnumber;	
		
	}
	
}

