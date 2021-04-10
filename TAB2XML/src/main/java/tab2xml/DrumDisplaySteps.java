package tab2xml;

public class DrumDisplaySteps {

	static int i;
	static String displayStep;
	
	// need to change this based off the what insturment it is 
	
	public String StepOrganizer(int [] rowSymbols, int row)
	{
		
		
		if (rowSymbols[row]== 1)
		{
			//cc
			displayStep = "A";
		}
		else if (rowSymbols[row]== 2)
		{
			//hi hat
			displayStep = "G";
			// just for now
		}
		else if (rowSymbols[row]== 3)
		{
			//ride 
			displayStep = "F";
		}
		else if (rowSymbols[row]== 4)
		{
			//snare
			displayStep = "C";
		}
		else if (rowSymbols[row]== 5)
		{
			//high tom
			displayStep = "E";
		}
		else if (rowSymbols[row]== 6)
		{
			//low tom
			displayStep = "D";
		}
		else if (rowSymbols[row]== 7)
		{
			//floor tom
			displayStep = "A";
		}
		else if (rowSymbols[row]== 8)
		{
			//bass drum tom
			displayStep = "F";
		}
		else
		{
			//error for andy 
		}
		
		
		return displayStep;
	
						
	}

}
