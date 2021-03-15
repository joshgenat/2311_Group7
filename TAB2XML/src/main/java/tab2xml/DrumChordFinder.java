package tab2xml;

import java.util.ArrayList;

public class DrumChordFinder {

	//
	
	 int durationcount;
	 boolean breaksDivider = false; 
	 boolean drumChordsFinder; 
	 ArrayList<Boolean> DrumChordFinder;
	
	public boolean ChordFinder (int col,  int nextCol, int nextNextCol, ArrayList<Integer> barLineCols)
	{
		DrumChordFinder = new ArrayList<Boolean>();
		
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
					DrumChordFinder.add(false);
					
					}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextCol - col; 
					breaksDivider = true;
					DrumChordFinder.add(false);
					
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
						DrumChordFinder.add(true);
					
						}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextNextCol - col;
					drumChordsFinder = true;
					breaksDivider = true;
					DrumChordFinder.add(true);
					
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
		
	
	return drumChordsFinder;
	}




}
