package tab2xml;

public class DrumDisplayOctave {
	
	
	static int numOfOctaves;
	
	
	public int DrumOctaves(char [][] tabsize, int voice)
	{
		            	

		
		if  (voice == 2)
        {
        	numOfOctaves = (tabsize.length) - 2;
        }
		else if(voice ==1)
		{
			numOfOctaves = (tabsize.length) - 1;
		}
		else 
		{
		// throw an exception saying voice value is not valid 	
		}	

		return numOfOctaves;
	}
}