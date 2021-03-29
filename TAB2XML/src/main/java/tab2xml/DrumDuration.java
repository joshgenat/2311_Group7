package tab2xml;

import java.util.ArrayList;

public class DrumDuration {
	
	
	/**
	 * i added a new parameter to the Duration class, which is a array of the dividers in the tab. By dividers they are the columns with the '|' in them. These are very important for drum tabs, because they signal to us when to restart the duration count and also if they are not read, the duration 
	 * will be a odd number which is impossible. How this code works is we first subtract the current column value of the note we're looking at to the column value of the next note, this is how we calculate duration. If the columns are the same, then we look at the note after that to calculate duration 
	 * The dividers array exist because the values in this array, tell us when the durationcount has reached it's limit and should restart. fOR example if col = 12 and nextCol = 21, durationcount would be equal to 9, which is not possible. This means the tab ended and needs a restart. 
	 * We look in the dividers array and there should be a value which is between col and nextCol, for example 20. Now we know the col note ends at 20, so 20 - 12 is 8, which is a more realistic answer.  
	 * 
	 */
	
	// remove barlines cols 
	
	 int durationcount;
	 boolean breaksDivider = false; 
	
	public int NoteDurationLength(int col,  int nextCol, int nextNextCol, ArrayList<Integer> barLineCols)
	{
		
		if (col != nextCol)
		{
			for (int i = 0; i < barLineCols.size(); i++) 
			{
				if(i+1 < barLineCols.size()) 
				{
					if ((barLineCols.get(i) < col) && (nextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
					{
					durationcount = barLineCols.get(i+1) - col; 
					breaksDivider  = true;
					
					}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextCol - col; 
					breaksDivider = true;
					
				}
				
				if (nextCol == 0)
				{
					durationcount = barLineCols.get(barLineCols.size()-1) - col;
				}
				
				if((nextCol<col) && (barLineCols.get(i)>col))
				{
					 durationcount = barLineCols.get(i) - col;
					 break;
				}
			}
				
			
		}
		
		if (col == nextCol)
		{
			
			for (int i = 0; i < barLineCols.size(); i++) 
			{
				if(i+1 < barLineCols.size()) 
				{
					if ((barLineCols.get(i) < col) && (nextNextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
						{
						durationcount = barLineCols.get(i+1) - col; 
						breaksDivider  = true;
					
						}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextNextCol - col;
					breaksDivider = true;
					
				}
				
				if (nextNextCol == 0)
				{
					durationcount = barLineCols.get(barLineCols.size()-1) - col;
				}
				
				if((nextNextCol<col) && (barLineCols.get(i)>col))
				{
					 durationcount = barLineCols.get(i) - col;
					 break;
				}
			}
			
		}
		breaksDivider = false;
		
	
	return durationcount;
	}




}

