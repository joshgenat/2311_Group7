package tab2xml;
import exceptions.*;

public class DrumNoteType {
	
	String noteType;
	int dotnumber;
	// need to leave duration 
	
	public String DrumNoteLength (int duration, int divisions, char [][] drumTab, int row, int col) throws Exception
	
	{
		int drumTabLength = 0;
		boolean read = false;
		for(int i = 0; i < drumTab[0].length; i++) {
			if(drumTab[0][i] == '|') {
				read = !read;
			}
			if(read) {
				drumTabLength++;
			}
		}
		drumTabLength--;
		// for divisions of 4 our system supports  tabs of length 
		if ((divisions == 4) && (drumTabLength == 16))
			
		{
			//4/4 time signature 
			
			// make a parameter of divisions
			
			
			if (duration == 1)
			{
				noteType = "16th";
			}
			else if (duration == 2)
			{
				noteType = "eighth";
			}
			else if (duration == 3)
			{
				noteType = "eighth";
			}
			else if (duration == 4)
			{
				noteType = "quarter";
			}
			else if (duration == 6)
			{
				noteType = "quarter";
			}
			else if (duration == 7)
			{
				noteType = "quarter";
			}
			else if (duration == 8)
			{
				noteType = "half";
			}
			else if (duration == 12)
			{
				noteType = "half";
			}
			else if (duration == 14)
			{
				noteType = "half";
			}
			else if (duration == 15)
			{
				noteType = "half";
			}
			else if (duration == 16)
			{
				noteType = "whole";
			}
			else
			{
				//thorw exception because duration for one note is not supported for my program for length 16, division 4 
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 16 with division of 4");
				
			}
			
		}
		
		if ((divisions == 2) && (drumTabLength == 8))
			
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
			else if (duration == 3)
			{
				noteType = "quarter";
			}
			else if (duration == 4)
			{
				noteType = "half";
			}
			else if (duration == 6)
			{
				noteType = "half";
			}
			else if (duration == 7)
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
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 8 with division of 2");
			}
			
		}
		
		if ((divisions == 1) && (drumTabLength == 4))
			
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
			else if (duration == 3)
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
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 4 with division of 1");
			}
			
		}
		
		if ((divisions == 6) && (drumTabLength == 18))
		
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
			else if (duration == 9)
			{
				noteType = "quarter";
			}
			else if (duration == 12)
			{
				noteType = "half";
			}
			else if (duration == 18)
			{
				noteType = "half";
			}
			else
			{
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 18 with division of 6");
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 3) && (drumTabLength == 9))
			
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
			else if (duration == 9)
			{
				noteType = "half";
			}
			else
			{
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 9 with division of 3");
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		if ((divisions == 4) && (drumTabLength == 12))
			
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
			else if (duration == 6)
			{
				noteType = "quarter";
			}
			else if (duration == 7)
			{
				noteType = "quarter";
			}
			else if (duration == 8)
			{
				noteType = "half";
			}
			else if (duration == 12)
			{
				noteType = "half";
			}
			else
			{
				throw new DurationException("duration: " + duration + "of note at row: " + row + " column: " + col + "invalid for tab of length 12 with division of 4");
				//throw exception saying duration is not supported by our program, refer to user manual for list of non supported durations 
			}
			
		}
		
		
		
		
	return noteType;	
		
	}
	
 public int DotValue (int duration, int divisions, char [][] drumTab) throws Exception
	
	{
		
	
	if ((divisions == 4) && (drumTab[0].length == 16))
		
	{
		//4/4 time signature 
		
		// make a parameter of divisions
		
		
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 3)
		{
			dotnumber = 1;
		}
		else if (duration == 4)
		{
			dotnumber = 0;
		}
		else if (duration == 6)
		{
			dotnumber = 1;
		}
		else if (duration == 7)
		{
			dotnumber = 2;
		}
		else if (duration == 8)
		{
			dotnumber = 0;
		}
		else if (duration == 12)
		{
			dotnumber = 1;
		}
		else if (duration == 14)
		{
			dotnumber = 2;
		}
		else if (duration == 15)
		{
			dotnumber = 3;
		}
		else if (duration == 16)
		{
			dotnumber = 0;
		}
		
	}
	
	if ((divisions == 2) && (drumTab[0].length == 8))
		
	{
		//4/4 time signature
		
		// make a parameter of divisionss
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 3)
		{
			dotnumber = 0;
		}
		else if (duration == 4)
		{
			dotnumber = 1;
		}
		else if (duration == 6)
		{
			dotnumber = 0;
		}
		else if (duration == 7)
		{
			dotnumber = 1;
		}
		else if (duration == 8)
		{
			dotnumber = 0;
		}
	}
		
	
	if ((divisions == 1) && (drumTab[0].length == 4))
		
	{
		//time signature 4/4
		
		// make a parameter of divisionss
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 3)
		{
			dotnumber = 1;
		}
		else if (duration == 4)
		{
			dotnumber = 0;
		}
		
		
	}
	
	if ((divisions == 6) && (drumTab[0].length == 18))
	
	{
		// time signature 6/8 and 3/4
		
		// make a parameter of divisionss
		
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 3)
		{
			dotnumber = 0;
		}
		else if (duration == 6)
		{
			dotnumber = 0;
		}
		else if (duration == 9)
		{
			dotnumber = 1;
		}
		else if (duration == 12)
		{
			dotnumber = 0;
		}
		else if (duration == 18)
		{
			dotnumber = 1;
		}
		
	}
	
	if ((divisions == 3) && (drumTab[0].length == 9))
		
	{
		// time signature 6/8 and 3/4
		
		// make a parameter of divisionss
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 3)
		{
			dotnumber = 0;
		}
		else if (duration == 6)
		{
			dotnumber = 0;
		}
		else if (duration == 9)
		{
			dotnumber = 1;
		}
		
	}
	
	if ((divisions == 4) && (drumTab[0].length == 12))
		
	{
		// time signature 6/8 and 3/4
		
		// make a parameter of divisionss
		if (duration == 1)
		{
			dotnumber = 0;
		}
		else if (duration == 2)
		{
			dotnumber = 0;
		}
		else if (duration == 4)
		{
			dotnumber = 0;
		}
		else if (duration == 6)
		{
			dotnumber = 1;
		}
		else if (duration == 7)
		{
			dotnumber = 2;
		}
		else if (duration == 8)
		{
			dotnumber = 0;
		}
		else if (duration == 12)
		{
			dotnumber = 1;
		}
		
	}
	
	
	 return dotnumber;
}	
}


