package tab2xml;

import java.util.ArrayList;

public class DrumDividers {

	/**
	 * One issue we were having with calculating duration is sometimes the duration would be odd numbers, this is our system skipped the columns of  '|' characters
	 * this columns is meant to symbolize the end of 16 beats, and therefore the duration count should end right here. I didn't want to include the '|' characters in my rowValue and colValue arrays
	 * so this class is might to go through the inputed drum tab and return an array with the columns at which the '|' appear. For example it should return an array like {2,19.32.48}
	 * Was having some out of bounds errors at the beginning but fixed it, if you can think of a better way to do this pls go ahead - uthith 
	 */

	
	ArrayList<Integer> barLineCols; 

	ArrayList<Integer> DrumBarLines(char [][] drumTab)
	{
		barLineCols = new ArrayList<Integer>();
	
	for (int col = 0; col<drumTab[0].length; col++)
	{
	    	 
	    	 if (drumTab[0][col] == '|')
	    		{
	    		 barLineCols.add(col);
	    		}
	    	}
	return barLineCols;
}
}
