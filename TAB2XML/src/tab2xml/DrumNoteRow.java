package tab2xml;

public class DrumNoteRow {


	int [] rowCoordinates;
	int [] colCoordinates;
	int counter = 0;
	boolean mutipleVoices = false;
	
	int [] RowReader(char [][] drumTab, int [] rowSymbols)
	{
		
		for (int col = 0; col < drumTab[col].length; col++)
        {
			
            for (int row = 0; row < drumTab.length; row++)
            {
            	//if (rowSymbols[row] == 8) means voice two
            	while ((drumTab[row][col] == 'x') && (rowSymbols[row] != 8))
            	{
            		rowCoordinates[counter] = row;
            		colCoordinates[counter] = col;
            		counter++;
            	}
            }
            
        }
		 // run the loop a second time, now to find the notes in voice 2 
		
		for (int col2 = 0; col2 < drumTab[col2].length; col2++)
        {
			
            for (int row2 = 0; row2 < drumTab.length; row2++)
            {
            	
            	
            	if(rowSymbols[row2] == 8 && mutipleVoices == false)
            	{
            		mutipleVoices = true;
            		rowCoordinates[counter] = 100;
            		colCoordinates[counter] = 100;
            		counter++;
            		
            	}
            	
            	while (rowSymbols[row2] == 8)
            	{
            		rowCoordinates[counter] = row2;
            		colCoordinates[counter] = col2;
            		counter++;
            	}
            
            }
            
        }
		return rowCoordinates;
		
		
		
	}
	
}
