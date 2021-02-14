package tab2xml;

public class DrumRowSorter {

	int [] row; 
	char [][] reader;
	String type;
	
	int [] RowSorter()
	{
		//i checks row and j checks col 
		for (int i = 0; i < reader.length; i++)
        {
			
            for (int j = 0; j < reader[i].length; j++)
            {
            	if (reader[i][j] == 'C' && reader[i][j+1] == 'C')
            	{
            		row[i] = 1;
            				
            	}
            	
            	if (reader[i][j] == 'H' && reader[i][j+1] == 'H')
            	{
            		row[i] = 2;
            		
            	}
            		
            	if (reader[i][j] == 'R' && reader[i][j+1] == 'D')
            	{
            		row[i] = 3;
            		
            	}
            	
            	if (reader[i][j] == 'S' && reader[i][j+1] == 'N')
            	{
            		row[i] = 4;
            	
          		
            	}
            	
            	if (reader[i][j] == 'T' && reader[i][j+1] == '1')
            	{
            		row[i] = 5;
            		
            		
            	}
            	
            	if (reader[i][j] == 'T' && reader[i][j+1] == '2')
            	{
            		row[i] = 6;
            		
            		
            	}
            	
            	if (reader[i][j] == 'F' && reader[i][j+1] == 'T')
            	{
            		row[i] = 7;
            		
            		
            	}
            	
            	if (reader[i][j] == 'B' && reader[i][j+1] == 'D')
            	{
            		row[i] = 9;
            		
            		
            	}
            	
            	if ((reader[i][j] == 'H' && reader[i][j+1] == 'f') || (reader[i][j] == 'F' && reader[i][j+1] == 'H'))
            	{
            		row[i] = 9;
            		
            		
            	}
            }
        }
            	
    
		
		return row;
		
	}
}
	
