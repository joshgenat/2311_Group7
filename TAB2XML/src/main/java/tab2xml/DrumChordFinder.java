package tab2xml;

import java.util.ArrayList;

public class DrumChordFinder {

	//
	
	 int durationcount;
	 boolean breaksDivider = false; 
	 boolean drumChordsFinder = false; 
	
	public boolean ChordFinder (int col,  int nextCol, int nextNextCol, ArrayList<Integer> barLineCols)
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
						drumChordsFinder = true;
						breaksDivider  = true;
					
						}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextNextCol - col;
					drumChordsFinder = true;
					breaksDivider = true;
					
				}
				
				if (nextNextCol == 0)
				{
					durationcount = barLineCols.get(barLineCols.size()-1) - col;
					drumChordsFinder = true;
				}
				
				if((nextNextCol<col) && (barLineCols.get(i)>col))
				{
					 durationcount = barLineCols.get(i) - col;
					 drumChordsFinder = true;
					 break;
				}
			}
			
		}
		breaksDivider = false;
		
	
	return drumChordsFinder;
	}




}
