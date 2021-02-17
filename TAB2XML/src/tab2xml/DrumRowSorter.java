package tab2xml;

public class DrumRowSorter {

	static int [] rowSymbols; 	
	
	public int [] rowSymbolsSorter(char [][] tab)
	{
		rowSymbols = new int[tab.length];
		//i checks rowSymbols and j checks col 
		for (int i = 0; i < tab.length; i++)
        {
            	if (tab[i][0] == 'C' && tab[i][1] == 'C')
            	{
            		rowSymbols[i] = 1;
            				
            	}
            	
            	else if (tab[i][0] == 'H' && tab[i][1] == 'H')
            	{
            		rowSymbols[i] = 2;
            		
            	}
            		
            	else if (tab[i][0] == 'R' && tab[i][1] == 'D')
            	{
            		rowSymbols[i] = 3;
            		
            	}
            	
            	else if (tab[i][0] == 'S' && tab[i][1] == 'N')
            	{
            		rowSymbols[i] = 4;
            	
          		
            	}
            	
            	else if (tab[i][0] == 'T' && tab[i][1] == '1')
            	{
            		rowSymbols[i] = 5;
            		
            		
            	}
            	
            	else if (tab[i][0] == 'T' && tab[i][1] == '2')
            	{
            		rowSymbols[i] = 6;
            		
            		
            	}
            	
            	else if (tab[i][0] == 'F' && tab[i][1] == 'T')
            	{
            		rowSymbols[i] = 7;
            		
            		
            	}
            	
            	else if (tab[i][0] == 'B' && tab[i][1] == 'D')
            	{
            		rowSymbols[i] = 8;
            		
            		
            	}
            	
            	else if ((tab[i][0] == 'H' && tab[i][1] == 'f') || (tab[i][0] == 'F' && tab[i][1] == 'H'))
            	{
            		rowSymbols[i] = 9;
            		
            		
            	}
        }
            	
		return rowSymbols;		
	}
}
	
