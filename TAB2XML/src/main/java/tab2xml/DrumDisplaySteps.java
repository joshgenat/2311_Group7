package tab2xml;

public class DrumDisplaySteps {

	static int i;
	char displayStep;
	
	public char StepOrganizer(int row, int col)
	{
		if (row == 0)
		{
			displayStep = 'A';
		}
		
		else if (row == 1)
		{
			displayStep = 'G';
		}
		
		else if (row == 2)
		{
			displayStep = 'C';
		}
		
		else if (row == 3)
		{
			displayStep = 'E';
		}
		
		else if (row == 4)
		{
			displayStep = 'D';
		}
		
		else if (row == 5)
		{
			displayStep = 'F';
		}
		
		
		return displayStep;
	
						
	}
	
}
