package tab2xml;

public class DrumDisplaySteps {

	static int i;
	static String displayStep;
	
	// need to change this based off the what insturment it is 
	
	String StepOrganizer(int row, int col)
	{
		if (row == 0)
		{
			displayStep = "A";
		}
		
		else if (row == 1)
		{
			displayStep = "G";
		}
		
		else if (row == 2)
		{
			displayStep = "C";
		}
		
		else if (row == 3)
		{
			displayStep = "E";
		}
		
		else if (row == 4)
		{
			displayStep = "D";
		}
		
		else if (row == 5)
		{
			displayStep = "F";
		}
		else 
		{
			displayStep = "inValid Entry";
		}
		
		return displayStep;
	
						
	}
	
}
