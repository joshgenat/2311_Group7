package tab2xml;

public class DrumNoteReader {


	int [] rowCoordinates;
	int [] colCoordinates;
	int counter = 0;
	boolean mutipleVoices = false;
	
	void Reader(char [][] drumTab, int [] rowSymbols)
	{
		for (int i = 0; i < drumTab.length; i++)
        {
			
            for (int j = 0; j < drumTab[i].length; j++)
            {
            	//if (rowSymbols[row] == 8) means voice two
            	while ((drumTab[i][j] == 'x') && (rowSymbols[i] == 8))
            	{
            		rowCoordinates[counter] = i;
            		colCoordinates[counter] = j;
            		counter++;
            	}
            }
            
        }
		 // run the loop a second time, now to find the notes in voice 2 
		
		for (int k = 0; k < drumTab.length; k++)
        {
			
            for (int z = 0; z < drumTab[k].length; z++)
            {
            	if(rowSymbols[k] == 8 && mutipleVoices == false)
            	{
            		mutipleVoices = true;
            		rowCoordinates[counter] = 0;
            		colCoordinates[counter] = 0;
            		counter++;
            		
            	}
            	
            	while (rowSymbols[k] == 8)
            	{
            		rowCoordinates[counter] = k;
            		colCoordinates[counter] = z;
            		counter++;
            	}
            
            }
            
        }
		
		
		
	}
	
}
