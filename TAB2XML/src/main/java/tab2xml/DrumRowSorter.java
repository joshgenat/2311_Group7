package tab2xml;

public class DrumRowSorter {

	static int [] rowSymbols; 	
	
	public int [] rowSymbolsSorter(char [][] tab)
	{
		rowSymbols = new int[tab.length];
		//i checks rowSymbols and j checks col 
		for (int i = 0; i < tab.length; i++)
        {
			if ((tab[i][0] == 'C' && tab[i][1] == 'C') || (tab[i][0] == 'C' && tab[i][1] == ' '))
        	{
        		rowSymbols[i] = 1;
        		//clash cymbal
        				
        	}
        	
        	else if (tab[i][0] == 'H' && tab[i][1] == 'H')
        	{
        		rowSymbols[i] = 2;
        		//hi Hat 
        		
        	}
        		
        	else if ((tab[i][0] == 'R' && tab[i][1] == 'D') || (tab[i][0] == 'R' && tab[i][1] == ' ') || (tab[i][0] == 'R' && tab[i][1] == 'C'))
        	{
        		rowSymbols[i] = 3;
        		//ride cymbal
        		
        	}
        	
        	else if ((tab[i][0] == 'S' && tab[i][1] == 'N') || (tab[i][0] == 'S' && tab[i][1] == 'D'))
        	{
        		rowSymbols[i] = 4;
        		//snare 
        	
      		
        	}
        	
        	else if ((tab[i][0] == 'T' && tab[i][1] == '1') || (tab[i][0] == 'T' && tab[i][1] == ' ') || (tab[i][0] == 'H' && tab[i][1] == 'T'))
        	{
     
        		rowSymbols[i] = 5;
        		//high tom 
        		
        		
        	}
        	
        	else if ((tab[i][0] == 'T' && tab[i][1] == '2') || (tab[i][0] == 'M' && tab[i][1] == 'T')|| (tab[i][0] == 't' && tab[i][1] == ' '))
        	{
        		rowSymbols[i] = 6;
        		// low tom
        		
        		
        	}
        	
        	else if (tab[i][0] == 'F' && tab[i][1] == 'T')
        	{
        		rowSymbols[i] = 7;
        		//floor tom or low floor tom
        		
        		
        	}
        	
        	else if ((tab[i][0] == 'B' && tab[i][1] == 'D') || (tab[i][0] == 'B' && tab[i][1] == ' '))
        	{
        		rowSymbols[i] = 8;
        		//bass drum 
        		
        		
        	}
        	
        	else if ((tab[i][0] == 'H' && tab[i][1] == 'f') || (tab[i][0] == 'F' && tab[i][1] == 'H'))
        	{
        		rowSymbols[i] = 9;
        		
        		
        	}
        }
            	
		return rowSymbols;		
	}
}
	
