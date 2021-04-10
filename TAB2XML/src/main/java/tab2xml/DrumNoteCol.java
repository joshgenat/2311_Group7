package tab2xml;

import java.util.ArrayList;

public class DrumNoteCol {


	
	//ArrayList<Integer> rowCoordinate;
	ArrayList<Integer> colCoordinate;
	//boolean mutipleVoices;
	boolean checker; 
	int oldDivider;
	int currentDivider;
	
	ArrayList <Integer> ColReader(char [][] drumTab, int [] rowSymbols)
	{
		//mutipleVoices = false;
		//rowCoordinate = new ArrayList<Integer>();
		colCoordinate = new ArrayList<Integer>();
		checker = false; 
		oldDivider = 0;
		currentDivider = 0;
		
		
		
		/*
		 * This for loop which goes through the tab, and finds the column values for the barlines 
		 * The first two if statement find the column barline value and put the value in currentDivider, since a tab has more than one barline
		 * we put the old barline column value inside oldDivider. 
		 */
		for (int col = 0; col<drumTab[0].length; col++)
		{
		     for (int row = drumTab.length - 1; row >= 0 ; row--)
		     {
		    	 
		    	 if (currentDivider == col)
		    	 {
		    		checker = true;
		    		break; 
		    	 }		    	 
		    	
		    	 else if (drumTab[row][col] == '|')
		    		{
		    		 oldDivider = currentDivider;
		    		 currentDivider = col;
		    		 checker = false;
		    		}
		
		

	if (checker == false)
	{

		for (int col1 = oldDivider; col1 < currentDivider; col1++)
        {
			
            for (int row1 = drumTab.length - 1; row1 >=0; row1--)
            {
            	//if (rowSymbols[row] == 8) means voice two
            	if ((drumTab[row1][col1] == 'x' || drumTab[row1][col1] == 'o' || drumTab[row1][col1] == 'f')  && (rowSymbols[row1] != 8))
            	{
            		//rowCoordinate.add(row1);
            		colCoordinate.add(col1);

            	}
            }
            
        }
		 
		
		
		// run the loop a second time, now to find the notes in voice 2 
		for (int col2 = oldDivider; col2 < currentDivider; col2++)
        {
			
            for (int row2 = drumTab.length - 1;row2>=0; row2--)
            {
            	
            	
            	
            	 if ((drumTab[row2][col2] == 'x' || drumTab[row2][col2] == 'o')  && (rowSymbols[row2]== 8))
            	{
            		//rowCoordinate.add(row2);
             		colCoordinate.add(col2);
            	}
            
            }
            
        }
		 	}
		     }
		}
		return colCoordinate;
		
		
		
	}
	
}
