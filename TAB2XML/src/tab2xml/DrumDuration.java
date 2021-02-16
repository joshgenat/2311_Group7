package tab2xml;

public class DrumDuration {
	
	int durationcount;

	
	public int NoteDurationLength(int col,  int nextCol, int nextNextCol)
	{
		if (col != nextCol)
		{
			durationcount = nextCol- col;
		}
	
		if (col == nextCol)
		{
			
			durationcount = nextNextCol - col;
		}
		
	
	return durationcount;
	}



}

