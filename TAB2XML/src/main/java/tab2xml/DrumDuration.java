package tab2xml;

public class DrumDuration {
	
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

