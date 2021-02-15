package tab2xml;

public class DrumDuration {
	
	//  this class will be used to calculate how long each note will be played 
	
	char checker;
	int durationcount;

	
	int duration()
	{

	if (checker == 'x'|| checker == 'o') 
	{
		durationcount = 0;
		durationcount++;
		while (checker == '-')
		{
			durationcount++;
		}
	}
	
	return durationcount;
	}



}

