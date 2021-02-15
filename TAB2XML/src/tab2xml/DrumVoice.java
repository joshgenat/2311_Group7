package tab2xml;

public class DrumVoice {

	int voiceValue; 
	
	int FindVoiceValue (int row, int [] rowSymbols)
	{
		if (rowSymbols[row] == 8)
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
