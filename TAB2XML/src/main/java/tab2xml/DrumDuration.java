package tab2xml;

public class DrumDuration {
	
	int durationcount;

	
	public int duration(int row, int col, int nextRow, int nextCol, int nextNextRow, int nextNextCol)
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

