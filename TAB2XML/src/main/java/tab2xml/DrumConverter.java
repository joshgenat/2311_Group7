package tab2xml;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class DrumConverter {

	public static void main(String[] args) {
		

		char checker = ' ';
		String type;
		
		int crashRow = 0;
		int hiHatFootRow = 0;
		int hiHatRow = 0;
		int snearRow = 0;
		int bassRow = 0;
		int lowTomRow = 0;
		int highTomRow = 0;
		int floorTomRow = 0;
		
		ArrayList<String> drumType = new ArrayList<String>();
		
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
            	
                System.out.print(tester[row][col]);

                switch (checker) {
               
                case 'C':
            	  type = "Crash Cymbal";
            	  crashRow = row + 1;
            	  drumType.add (type);
                  break;
              
               case 'H':
            	   	if (tester[row][col+1] == 'f')
            	   	{
            	  	  type = "Hi-Hat with Foot";	
              	   	  hiHatFootRow = row + 1;
              	   	drumType.add (type);
            	   	}
            	   	else 
            	   	{
            	   	  type = "Hi-Hat";        	   	
            	   	  hiHatRow = row + 1;
            	   	drumType.add (type);
            	   	}
                  break;
               
               case 'S':
            	   type = "Snare Drum";
         	   	   snearRow = row + 1;
         	   	   drumType.add (type);
                    break;
               
               case 'B':
            	   type = "Bass Drum";
            	   bassRow = row + 1;
            	   drumType.add (type);
                   break;
                   
               case 'T':
            	   if (tester[row][col+1] == '1')
            	   {
             	  	  type = "Low Tom";	
            		  lowTomRow = row + 1;
            		  drumType.add (type);
            	   }
             	   	else if (tester[row][col+1] == '2')
             	   	{
             	   	  type = "Hi Tom";
             	   	highTomRow = row + 1;
             	   	drumType.add (type);
             	   	}   
                   break;
               
               case 'F':
            	   if (tester[row][col+1] == 'T')
            	   {
              	  	  type = "Floor Tom";
            	      floorTomRow = row + 1;
            	      drumType.add (type);
            	   }
                   break;
              
                default:
                	break;
                }	
            	
            } 
            System.out.println();
                           	
        }
	}
}

	
           


