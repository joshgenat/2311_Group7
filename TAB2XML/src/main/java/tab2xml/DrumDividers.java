package tab2xml;

public class DrumDividers {

	int [] dividers;

	int [] TabDividers(char [][] drumTab)
	{
		dividers = new int [100];
	
	for (int col = 0; col<drumTab[0].length; col++)
	{
	    	 
	    	 if (drumTab[0][col] == '|')
	    		{
	    		 int i = 0;
	    		 dividers[i] = col;
	    		 i++;
	
	    		}
	    	}
	return dividers;
}
}
