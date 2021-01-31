package tab2xml;

public class Guitar_Converter {
	
	//Main
	public static void main(String args[]) {
		char[][] test = {
				{'1', '-', '-', '-', '5', '-'},
				{'-', '2', '-', '4', '-', '6'},
				{'-', '-', '3', '-', '-', '-'}
		};
		String[][] notes = GuitarConverter(test);
		
		for(int i = 0; i < notes.length; i++) {
			for(int j = 0; j < notes[i].length; j++) {
					System.out.print(notes[i][j] + ", ");
				}
			System.out.println();
		}
			
		//System.out.println(test[0][1]);
	}
	
	/*
	 * Returns 2D array of notes, stored as strings
	 * argument is a 2D array that has been parsed from a tab
	 * e.g 
	 * 1---------	Stored as a 2d array of chars representing
	 * -----0----	the characters and numbers, char[rows][columns]
	 * -2---0----	example, first column {'1', '-', '-', '-', '5', '-'}
	 * -----0----
	 * ---3------
	 * -------9-- 
	 * 
	 * @param	in	2d char array parsed from tab format
	 * @return	out	2d String array of notes at their corresponding positions on the tab
	 */
	public static String[][] GuitarConverter(char[][] in) { 
		String[][] out;
		String tmp; 
		int i, j, j2;
		out = new String[in.length][in[0].length];
		for(i = 0; i < out.length; i++) {
			tmp = "";
			for(j = 0; j < out[i].length; j++) {
				tmp = "";
				for(j2 = 0; j2 < out[i].length; j2++) {
					if(j2 == j)
						tmp = tmp + in[i][j];
					else
						tmp = tmp + '-';
				}
				out[i][j] = StringToNote(tmp);
			}
			
			
		}
		
		
		return out;
	}
	
	/*
	 * Returns a note string that corresponds to the tab column
	 * @param	in	String representing a column of characters from a tab e.g "-1-4--"
	 * @return		Note string, corresponding to tab
	 */
	public static String StringToNote(String in) {
		
		switch(in) {
			case "0-----":
				return "E";
			case "-0----":
				return "B";
			case "--0---":
				return "G";
			case "---0--":
				return "D";
			case "----0-":
				return "A";
			case "-----0":
				return "E";
			case "1-----":
				return "F";
			case "-1----":
				return "C";
			case "--1---":
				return "G#";
			case "---1--":
				return "D#";
			case "----1-":
				return "A#";
			case "-----1":
				return "F";
			case "2-----":
				return "F#";
			case "-2----":
				return "C#";
			case "--2---":
				return "A";
			case "---2--":
				return "E";
			case "----2-":
				return "B";
			case "-----2":
				return "F#";
			case "3-----":
				return "G";
			case "-3----":
				return "D";
			case "--3---":
				return "A#";
			case "---3--":
				return "F";
			case "----3-":
				return "C";
			case "-----3":
				return "G";
			case "4-----":
				return "G#";
			case "-4----":
				return "D#";
			case "--4---":
				return "B";
			case "---4--":
				return "F#";
			case "----4-":
				return "C#";
			case "-----4":
				return "G#";
			case "5-----":
				return "A";
			case "-5----":
				return "E";
			case "--5---":
				return "C";
			case "---5--":
				return "G";
			case "----5-":
				return "D";
			case "-----5":
				return "A";
			case "6-----":
				return "A#";
			case "-6----":
				return "F";
			case "--6---":
				return "C#";
			case "---6--":
				return "G#";
			case "----6-":
				return "D#";
			case "-----6":
				return "A#";
			case "7-----":
				return "B";
			case "-7----":
				return "F#";
			case "--7---":
				return "D";
			case "---7--":
				return "A";
			case "----7-":
				return "E";
			case "-----7":
				return "B";
			case "8-----":
				return "C";
			case "-8----":
				return "G";
			case "--8---":
				return "D#";
			case "---8--":
				return "A#";
			case "----8-":
				return "F";
			case "-----8":
				return "C";
			case "9-----":
				return "C#";
			case "-9----":
				return "G#";
			case "--9---":
				return "E";
			case "---9--":
				return "B";
			case "----9-":
				return "F#";
			case "-----9":
				return "C#";
			/*
			case "10-----":
				return "D";
			case "-10----":
				return "A";
			case "--10---":
				return "F";
			case "---10--":
				return "C";
			case "----10-":
				return "G";
			case "-----10":
				return "D";
			case "11-----":
				return "D#";
			case "-11----":
				return "A#";
			case "--11---":
				return "F#";
			case "---11--":
				return "C#";
			case "----11-":
				return "G#";
			case "-----11":
				return "D#";
			case "12-----":
				return "E";
			case "-12----":
				return "B";
			case "--12---":
				return "G";
			case "---12--":
				return "D";
			case "----12-":
				return "A";
			case "-----12":
				return "E";
				*/
			default:
				return "-";
		}
		
	}
}
