package tab2xml;

public class DrumVoice {

	int voiceValue; 
	
	int FindVoiceValue (int row, int [] rowSymbols)
	{
		
		if (row == 100)
		{
			voiceValue = 0;
		}
		else if (rowSymbols[row] == 8)
		{
			voiceValue = 2;
		}
		else
		{
			voiceValue = 1;
		}
		
		return voiceValue;
		
	}
}
