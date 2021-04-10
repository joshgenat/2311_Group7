package tab2xml;

import java.util.ArrayList;

public class DrumChordFinder {

	//make a few changes you probably don't need barlines anymore, if andy makes changes 
	
	 int durationcount;
	 boolean breaksDivider = false; 
	 boolean drumChordsFinder = false; 
	
	
	public boolean ChordFinder (int col,  int nextCol, int nextNextCol, int preCol, ArrayList<Integer> barLineCols)
	{ 
	
				
				if(preCol == col)
				{
					drumChordsFinder = true;
				}
				else
				{
					drumChordsFinder = false;
				}

		
	
	return drumChordsFinder;
	}




}
