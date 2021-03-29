package tab2xml;

import java.util.ArrayList;

public class DrumChordFinder {

	//make a few changes you probably don't need barlines anymore, if andy makes changes 
	
	 int durationcount;
	 boolean breaksDivider = false; 
	 boolean drumChordsFinder = false; 
	
	
	public boolean ChordFinder (int col,  int nextCol, int nextNextCol, int preCol, ArrayList<Integer> barLineCols)
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
					drumChordsFinder = false;
					
					}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextCol - col; 
					breaksDivider = true;
					drumChordsFinder = false;
			
					
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
				
				if(preCol == col)
				{
					drumChordsFinder = true;
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
						drumChordsFinder = false;
						breaksDivider  = true;
	
					
						}
				}
				
				
				if (breaksDivider == false)
				{
					durationcount = nextNextCol - col;
					drumChordsFinder = false;
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
		
	
	return drumChordsFinder;
	}




}
