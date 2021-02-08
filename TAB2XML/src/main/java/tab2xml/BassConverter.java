package tab2xml;

public class BassConverter {
	
	//Main
	public static void main(String args[]) {
		char[][] test4 = {
				{'1', '-', '-', '6'},
				{'-', '2', '4', '-'},
				{'-', '-', '3', '-'}
		};
		char[][] test5 = {
				{'4', '-', '-', '-', '-'},
				{'3', '-', '7', '-', '-'},
				{'-', '-', '8', '-', '5'}
		};
		
		char[][] test6 = {
				{'4', '-', '-', '-', '-', '-'},
				{'3', '-', '7', '-', '-', '-'},
				{'-', '-', '8', '-', '5', '-'}
		};
		
		String[][] notes4 = GuitarConverter(test4);
		String[][] notes5 = GuitarConverter(test5);
		//String[][] notes6 = GuitarConverter(test6);
		
		for(int i = 0; i < notes4.length; i++) {
			for(int j = 0; j < notes4[i].length; j++) {
					System.out.print(notes4[i][j] + ", ");
				}
			System.out.println();
		}
		
		for(int i = 0; i < notes5.length; i++) {
			for(int j = 0; j < notes5[i].length; j++) {
					System.out.print(notes5[i][j] + ", ");
				}
			System.out.println();
		}
			
		//System.out.println(test[0][1]);
	}
	
	/*
	 * Returns 2D array of notes, stored as strings
	 * argument is a 2D array that has been parsed from a tab
	 * Can accept 4, or 5 string bass parsed tabs
	 * e.g 
	 * 1---------	Stored as a 2d array of chars representing
	 * -----0----	the characters and numbers, char[rows][columns]
	 * -2---0----	example, first column {'1', '-', '-', '-'}
	 * -----0---- 
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
				out[i][j] = StringToNote(tmp, in[0].length);
			}
			
			
		}
		
		
		return out;
	}
	
	/*
	 * Returns a note string that corresponds to the tab column
	 * @param	in	String representing a column of characters from a tab e.g "-1-4--"
	 * @param	n	Number of strings for the bass guitar, must be 4 or 5
	 * @return		Note string, corresponding to tab
	 * @throws	IllegalArgumentException	if parsed tab is not 4 or 5 strings long
	 */
	public static String StringToNote(String in, int n) {
		
		switch(n) {
			case 4:
				switch(in) {
					case "0---":
						return "E4";
					case "-0--":
						return "B3";
					case "--0-":
						return "G3";
					case "---0":
						return "D3";
					case "1---":
						return "F4";
					case "-1--":
						return "C4";
					case "--1-":
						return "Ab3";
					case "---1":
						return "Eb3";
					case "2---":
						return "F#4";
					case "-2--":
						return "C#4";
					case "--2-":
						return "A3";
					case "---2":
						return "E3";
					case "3---":
						return "G4";
					case "-3--":
						return "D4";
					case "--3-":
						return "Bb3";
					case "---3":
						return "F3";
					case "4---":
						return "Ab4";
					case "-4--":
						return "Eb4";
					case "--4-":
						return "B3";
					case "---4":
						return "F#3";
					case "5---":
						return "A4";
					case "-5--":
						return "E4";
					case "--5-":
						return "C4";
					case "---5":
						return "G3";
					case "6---":
						return "Bb4";
					case "-6--":
						return "F4";
					case "--6-":
						return "C#4";
					case "---6":
						return "Ab3";
					case "7---":
						return "B4";
					case "-7--":
						return "F#4";
					case "--7-":
						return "D4";
					case "---7":
						return "A3";
					case "8---":
						return "C5";
					case "-8--":
						return "G4";
					case "--8-":
						return "Eb4";
					case "---8":
						return "Bb3";
					case "9---":
						return "C#5";
					case "-9--":
						return "Ab4";
					case "--9-":
						return "E4";
					case "---9":
						return "B3";
					case "!---":
						return "D5";
					case "-!--":
						return "A4";
					case "--!-":
						return "F4";
					case "---!":
						return "C4";
					case "@---":
						return "Eb5";
					case "-@--":
						return "Bb4";
					case "--@-":
						return "F#4";
					case "---@":
						return "C#4";
					case "#---":
						return "E5";
					case "-#--":
						return "B4";
					case "--#-":
						return "G4";
					case "---#":
						return "D4";
					default:
						return "-";
				}
			case 5:
				switch(in) {
					case "0----":
						return "E4";
					case "-0---":
						return "B3";
					case "--0--":
						return "G3";
					case "---0-":
						return "D3";
					case "----0":
						return "A2";
					case "1----":
						return "F4";
					case "-1---":
						return "C4";
					case "--1--":
						return "Ab3";
					case "---1-":
						return "Eb3";
					case "----1":
						return "Bb2";
					case "2----":
						return "F#4";
					case "-2---":
						return "C#4";
					case "--2--":
						return "A3";
					case "---2-":
						return "E3";
					case "----2":
						return "B2";
					case "3----":
						return "G4";
					case "-3---":
						return "D4";
					case "--3--":
						return "Bb3";
					case "---3-":
						return "F3";
					case "----3":
						return "C3";
					case "4----":
						return "Ab4";
					case "-4---":
						return "Eb4";
					case "--4--":
						return "B3";
					case "---4-":
						return "F#3";
					case "----4":
						return "C#3";
					case "5----":
						return "A4";
					case "-5---":
						return "E4";
					case "--5--":
						return "C4";
					case "---5-":
						return "G3";
					case "----5":
						return "D3";
					case "6----":
						return "Bb4";
					case "-6---":
						return "F4";
					case "--6--":
						return "C#4";
					case "---6-":
						return "Ab3";
					case "----6":
						return "Eb3";
					case "7----":
						return "B4";
					case "-7---":
						return "F#4";
					case "--7--":
						return "D4";
					case "---7-":
						return "A3";
					case "----7":
						return "E3";
					case "8----":
						return "C5";
					case "-8---":
						return "G4";
					case "--8--":
						return "Eb4";
					case "---8-":
						return "Bb3";
					case "----8":
						return "F3";
					case "9----":
						return "C#5";
					case "-9---":
						return "Ab4";
					case "--9--":
						return "E4";
					case "---9-":
						return "B3";
					case "----9":
						return "F#3";
					case "!----":
						return "D5";
					case "-!---":
						return "A4";
					case "--!--":
						return "F4";
					case "---!-":
						return "C4";
					case "----!":
						return "G3";
					case "@-----":
						return "Eb5";
					case "-@---":
						return "Bb4";
					case "--@--":
						return "F#4";
					case "---@-":
						return "C#4";
					case "----@":
						return "Ab3";
					case "#----":
						return "E5";
					case "-#---":
						return "B4";
					case "--#--":
						return "G4";
					case "---#-":
						return "D4";
					case "----#":
						return "A3";
					default:
						return "-";
				}
			default:
				throw new IllegalArgumentException();
		}
		
		
	}
}
