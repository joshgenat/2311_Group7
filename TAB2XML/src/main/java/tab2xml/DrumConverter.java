package tab2xml;

public class DrumConverter {

	public static void main(String[] args) {
		
		boolean isDrum = false; 
		char checker = ' ';
		String type;
		char[][] tester = 
				{
				{'C', ' ', '-', '-', '-', 'x', '-', '-', '-'},
				{'R', ' ', '-', '-', 'o', 'x', '-', '-', '-'},
				{'S', 'D', '-', '-', '-', '-', '-', 'x', '-'},
				{'F', 'T', '-', '-', '-', '-', 'x', '-', 'x'},
				{'B', ' ', '-', '-', '-', '-', '-', '-', 'o'},
				{'H', 'f', '-', 'o', '-', '-', '-', '-', 'x'} 
				};
		
		for (int row = 0; row < tester.length; row++)
        {
            for (int col = 0; col < tester[row].length; col++)
            {
            	checker = tester[row][col];
            	
            	// the following statement is to help us see if the tab is for drums
            	if ((checker == 'x' || checker == 'o') && isDrum == false)
        		{
        		isDrum = true;
        		type = "drum";
        		}
                System.out.print(tester[row][col]);
                
                /* the following loop is to help us find drum tab notations 
                 * 
                 */     
                if (checker == 'c' || checker == 'H' || checker == 'S' || checker == 'B' || checker == 'T' || checker == 'F')
                {
                	if (tester[row][col+1] == 'D' || tester[row][col+1] == 'T' || tester[row][col+1] == 'f' || tester[row][col+1] == '1' || tester[row][col+1] == '2')
                	{
                		/* 
                		 * this will allow us to see is the checker and the character after it
                		 * are equal to any of the drum tab notations we are looking for 
                		 * such as 'S''D' = Snare Drum, 'F''T' = floor tom, 'T''2' = low tom
                		 */
                		
                	}
                	else if (tester[row][col+1] == ' ' || tester[row][col-1] == ' ')
                	{
                		/* just like the above if statement, expect this else if statement 
                		 * will allow us to find the single letter notations such as C = crash cymbal
                		 * H = hi-hat, B = bass drum 
                		 */
                	}
	
                }
            }
            System.out.println();
	}

}
}

