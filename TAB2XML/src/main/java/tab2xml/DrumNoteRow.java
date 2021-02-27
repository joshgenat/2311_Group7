package tab2xml;

public class DrumNoteRow {

	int [] rowCoordinates;
	int [] colCoordinates;
	int counter = 0;
	boolean mutipleVoices = false;
	boolean checker = false; 
	int oldDivider = 0;
	int currentDivider = 0;
	
	int [] RowReader(char [][] drumTab, int [] rowSymbols)
	{
		counter = 0;
		mutipleVoices = false;
		rowCoordinates = new int[100];
		colCoordinates = new int[100];
		checker = false; 
		oldDivider = 0;
		currentDivider = 0;
		
		
		
		
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
            	if ((drumTab[row1][col1] == 'x' || drumTab[row1][col1] == 'o')  && (rowSymbols[row1] != 8))
            	{
            		rowCoordinates[counter] = row1;
            		colCoordinates[counter] = col1;
            		counter++;
            	}
            }
            
        }
		 // run the loop a second time, now to find the notes in voice 2 
		
		for (int col2 = oldDivider; col2 < currentDivider; col2++)
        {
			
            for (int row2 = drumTab.length - 1;row2>=0; row2--)
            {
            	
            	
            	if(((drumTab[row2][col2] == 'x' || drumTab[row2][col2] == 'o') && (rowSymbols[row2]== 8)) && mutipleVoices == false)
            	{
            		mutipleVoices = true;
            		rowCoordinates[counter] = 100;
            		colCoordinates[counter] = 100;
            		counter++;
            		
            	}
            	
            	 if ((drumTab[row2][col2] == 'x' || drumTab[row2][col2] == 'o')  && (rowSymbols[row2]== 8))
            	{
            		rowCoordinates[counter] = row2;
            		colCoordinates[counter] = col2;
            		counter++;
            	}
            
            }
            
        }
		 	}
		     }
		}
		return rowCoordinates;
		
		
		
	}
	
}
