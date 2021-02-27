package tab2xml;

public class DrumNoteCol {


	int [] rowCoordinates;
	int [] colCoordinates;
	int counter = 0;
	boolean mutipleVoices = false;
	boolean checker = false; 
	int oldDivider = 0;
	int currentDivider = 0;
	
	
	int [] ColReader(char [][] drumTab, int [] rowSymbols)
	{
		
		counter = 0;
		mutipleVoices = false;
		rowCoordinates = new int[100];
		colCoordinates = new int[100];
		checker = false; 
		oldDivider = 0;
		currentDivider = 0;
		
		
		for (int col3 = 0; col3<drumTab[0].length; col3++)
		{
		     for (int row3 = drumTab.length - 1; row3 >= 0 ; row3--)
		     {
		    	 
		    	 if (currentDivider == col3)
		    	 {
		    		checker = true;
		    		break; 
		    	 }		    	 
		    	
		    	 else if (drumTab[row3][col3] == '|')
		    		{
		    		 oldDivider = currentDivider;
		    		 currentDivider = col3;
		    		 checker = false;
		    		}
		
		

		 		if (checker == false)
		 	{
		
		for (int col = oldDivider; col < currentDivider; col++)
        {
			
            for (int row = drumTab.length - 1; row >=0; row--)
            {
            	
            	 if ((drumTab[row][col] == 'x'  || drumTab[row][col] == 'o')  && (rowSymbols[row]!= 8))
            	{
            		rowCoordinates[counter] = row;
            		colCoordinates[counter] = col;
            		counter++;
            	}
            }
            
        }
		 
		
		
		// run the loop a second time, now to find the notes in voice 2 
		
		for (int col2 = oldDivider; col2 < currentDivider; col2++)
        {
			
            for (int row2 = drumTab.length - 1;row2>=0; row2--)
            {
            	
            	
            	if(((drumTab[row2][col2] == 'x'  || drumTab[row2][col2] == 'o')  && (rowSymbols[row2]== 8)) && mutipleVoices == false)
            	{
            		mutipleVoices = true;
            		rowCoordinates[counter] = 100;
            		colCoordinates[counter] = 100;
            		counter++;
            		
            	}
            	
            	 if ((drumTab[row2][col2] == 'x' || drumTab[row2][col2] == 'o') && (rowSymbols[row2]== 8))
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
		return colCoordinates;
		
		
		
	}
	
}
