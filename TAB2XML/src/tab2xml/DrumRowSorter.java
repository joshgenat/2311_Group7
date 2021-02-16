package tab2xml;

public class DrumRowSorter {

	static int [] rowSymbols; 	
	
	public int [] rowSymbolsSorter(char [][] tab)
	{
		rowSymbols = new int[tab.length];
		//i checks rowSymbols and j checks col 
		for (int i = 0; i < tab.length; i++)
        {
	
            for (int j = 0; j < tab[i].length; j++)
            {
            	if (tab[i][j] == 'C' && tab[i][j+1] == 'C')
            	{
            		rowSymbols[i] = 1;
            				
            	}
            	
            	else if (tab[i][j] == 'H' && tab[i][j+1] == 'H')
            	{
            		rowSymbols[i] = 2;
            		
            	}
            		
            	else if (tab[i][j] == 'R' && tab[i][j+1] == 'D')
            	{
            		rowSymbols[i] = 3;
            		
            	}
            	
            	else if (tab[i][j] == 'S' && tab[i][j+1] == 'N')
            	{
            		rowSymbols[i] = 4;
            	
          		
            	}
            	
            	else if (tab[i][j] == 'T' && tab[i][j+1] == '1')
            	{
            		rowSymbols[i] = 5;
            		
            		
            	}
            	
            	else if (tab[i][j] == 'T' && tab[i][j+1] == '2')
            	{
            		rowSymbols[i] = 6;
            		
            		
            	}
            	
            	else if (tab[i][j] == 'F' && tab[i][j+1] == 'T')
            	{
            		rowSymbols[i] = 7;
            		
            		
            	}
            	
            	else if (tab[i][j] == 'B' && tab[i][j+1] == 'D')
            	{
            		rowSymbols[i] = 8;
            		
            		
            	}
            	
            	else if ((tab[i][j] == 'H' && tab[i][j+1] == 'f') || (tab[i][j] == 'F' && tab[i][j+1] == 'H'))
            	{
            		rowSymbols[i] = 9;
            		
            		
            	}
            }
        }
            	
		return rowSymbols;		
	}
}
	
