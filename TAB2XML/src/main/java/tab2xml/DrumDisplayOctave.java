package tab2xml;

public class DrumDisplayOctave {
	
	
	static int numOfOctaves;
	
	
	public int DrumOctaves(int [] rowSymbols, int row)
	{
		            	
// octave does not depend on voice, need to change this to based off the instrument that is played 
		
		if (rowSymbols[row]== 1)
		{
			//cc
			numOfOctaves = 5;
		}
		else if (rowSymbols[row]== 2)
		{
			//hi hat
			numOfOctaves = 5;
			// just for now
		}
		else if (rowSymbols[row]== 3)
		{
			//ride 
			numOfOctaves = 5;
		}
		else if (rowSymbols[row]== 4)
		{
			//snare
			numOfOctaves = 5;
		}
		else if (rowSymbols[row]== 5)
		{
			//high tom
			numOfOctaves = 5;
		}
		else if (rowSymbols[row]== 6)
		{
			//low tom
			numOfOctaves = 5;
		}
		else if (rowSymbols[row]== 7)
		{
			//floor tom
			numOfOctaves = 4;
		}
		else if (rowSymbols[row]== 8)
		{
			//bass drum tom
			numOfOctaves = 4;
		}
		else
		{
			//error for andy 
		}


		return numOfOctaves;
	}
}