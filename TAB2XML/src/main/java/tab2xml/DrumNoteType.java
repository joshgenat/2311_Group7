package tab2xml;

public class DrumNoteType {
	
	String noteType;
	int dotnumber;
	
	// need to leave duration 
	
	public String DrumNoteLength (int duration, int divisions, char [][] drumTab)
	
	{
		// for divisions of 4 our system supports  tabs of length 
		if ((divisions == 4) && (drumTab[0].length == 16))
			
		{
			//4/4 time signature 
			
			// make a parameter of divisionss
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
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 2) && (drumTab[0].length == 8))
			
		{
			//4/4 time signature
			
			// make a parameter of divisionss
			if (duration == 1)
			{
				noteType = "eighth";
			}
			else if (duration == 2)
			{
				noteType = "quarter";
			}
			else if (duration == 4)
			{
				noteType = "half";
			}
			else if (duration == 8)
			{
				noteType = "whole";
			}
			else
			{
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 1) && (drumTab[0].length == 4))
			
		{
			//time signature 4/4
			
			// make a parameter of divisionss
			if (duration == 1)
			{
				noteType = "quarter";
			}
			else if (duration == 2)
			{
				noteType = "half";
			}
			else if (duration == 4)
			{
				noteType = "whole";
			}
			else
			{
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 6) && (drumTab[0].length == 18))
		
		{
			// time signature 6/8 and 3/4
			
			// make a parameter of divisionss
			if (duration == 1)
			{
				noteType = "eighth";
			}
			else if (duration == 2)
			{
				noteType = "eighth";
			}
			else if (duration == 3)
			{
				noteType = "eighth";
			}
			else if (duration == 6)
			{
				noteType = "quarter";
			}
			else if (duration == 12)
			{
				noteType = "half";
			}
			else if (duration == 24)
			{
				noteType = "whole";
			}
			else
			{
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 3) && (drumTab[0].length == 9))
			
		{
			// time signature 6/8 and 3/4
			
			// make a parameter of divisionss
			if (duration == 1)
			{
				noteType = "eighth";
			}
			else if (duration == 2)
			{
				noteType = "eighth";
			}
			else if (duration == 3)
			{
				noteType = "quarter";
			}
			else if (duration == 6)
			{
				noteType = "half";
			}
			else if (duration == 12)
			{
				noteType = "whole";
			}
			else
			{
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 4) && (drumTab[0].length == 12))
			
		{
			// time signature 6/8 and 3/4
			
			// make a parameter of divisionss
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
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		
		
		
	return noteType;	
		
	}
	
public int DotValue (int duration, int divisions, char [][] drumTab)
	
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

