package tab2xml;

public class BassConverter {
	
	//Main
	
	public static void main(String args[]) {
		char[][] test4 = {
				{'|', '|', '|', '|'},
				{'7', '7', '7', '7'},
				{'8', '8', '8', '8'},
				{'|', '|', '|', '|'},
				{'1', '1', '-', '-'},
				{'-', '5', '4', '-'}
		};
		char[][] test5 = {
				{'0', '0', '0', '0', '0'},
				{'1', '1', '1', '1', '1'},
				{'-', '-', '8', '-', '5'}
		};
		
		GuitarNoteObject[][] notes = converter(test4);
		notes = removeNull(notes);
		
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
	public static GuitarNoteObject[][] converter(char[][] in) { 
		GuitarNoteObject[][] out = new GuitarNoteObject[in.length][in[0].length]; 
		int i, i2, j, j2;
		i2 = 0;
		for(i = 0; i < out.length; i++) {
			if(charToInt(in[i][0]) != -1 || in[i][0] == '-') {
				for(j = 0; j < out[i].length; j++) {
					for(j2 = 0; j2 < out[i].length; j2++) {
						if(in[i][j] == '-') // j2 == j
							out[i2][j] = new GuitarNoteObject(i);	//tmp = tmp + in[i][j]; 
						else
							out[i2][j] = indexToNote(i, j, in[i][j]); //tmp = tmp + '-';
					}
					//out[i][j] = StringToNote(tmp);
				}
			i2++;
			}
		}
		
		return out;
	}
	
	/*
	 * Returns a note string that corresponds to the tab column
	 * @param	in	String representing a column of characters from a tab e.g "-1-4--"
	 * @return		Note string, corresponding to tab
	 */
	
	public static GuitarNoteObject indexToNote(int i, int j, char c) {
		int k = charToInt(c);
		int rem = (4 + k + 5 * j) % 12;
		
		return new GuitarNoteObject(intToNote(rem), ((16 + 5 * j + k) / 12), i, k);
	}
	
	public static String intToNote(int a) {
		switch(a) {
			case 0:
				return "C";
			case 1:
				return "C#";
			case 2:
				return "D";
			case 3:
				return "D#";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "F#";
			case 7:
				return "G";
			case 8:
				return "G#";
			case 9:
				return "A";
			case 10:
				return "A#";
			case 11:
				return "B";
			default:
				return null;
		}
	}
	
	public static int charToInt(char c) {
		
		switch(c) {
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case '!':
				return 10;
			case '@':
				return 11;
			case '#':
				return 12;
			case '$':
				return 13;
			case '%':
				return 14;
			case '^':
				return 15;
			case '&':
				return 16;
			case '*':
				return 17;
			case '(':
				return 19;
			case ')':
				return 20;
			case '=':
				return 21;
			default:
				return -1;
		}
	}
	
	public static GuitarNoteObject[][] removeNull(GuitarNoteObject[][] in){
		int i, j;
		for(i = 1; i <= in.length; i++){
			if(in[i][0] == null) 
				break;
		}
		GuitarNoteObject[][] out = new GuitarNoteObject[i][in[0].length];
		for(j = 0; j < i; j++) {
			out[j] = in[j];
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
						return "E1";
					case "-0--":
						return "A1";
					case "--0-":
						return "D2";
					case "---0":
						return "G2";
					case "1---":
						return "F1";
					case "-1--":
						return "A#1";
					case "--1-":
						return "D#2";
					case "---1":
						return "G#2";
					case "2---":
						return "F#1";
					case "-2--":
						return "B1";
					case "--2-":
						return "E2";
					case "---2":
						return "A2";
					case "3---":
						return "G1";
					case "-3--":
						return "C2";
					case "--3-":
						return "F2";
					case "---3":
						return "A#2";
					case "4---":
						return "G#1";
					case "-4--":
						return "C#2";
					case "--4-":
						return "F#2";
					case "---4":
						return "B2";
					case "5---":
						return "A1";
					case "-5--":
						return "D2";
					case "--5-":
						return "G2";
					case "---5":
						return "C3";
					case "6---":
						return "A#1";
					case "-6--":
						return "D#2";
					case "--6-":
						return "G#2";
					case "---6":
						return "C#3";
					case "7---":
						return "B1";
					case "-7--":
						return "E2";
					case "--7-":
						return "A2";
					case "---7":
						return "D3";
					case "8---":
						return "C2";
					case "-8--":
						return "F2";
					case "--8-":
						return "A#2";
					case "---8":
						return "D#3";
					case "9---":
						return "C#2";
					case "-9--":
						return "F#2";
					case "--9-":
						return "B2";
					case "---9":
						return "E3";
					case "!---":
						return "D2";
					case "-!--":
						return "G2";
					case "--!-":
						return "C3";
					case "---!":
						return "F3";
					case "@---":
						return "D#2";
					case "-@--":
						return "G#2";
					case "--@-":
						return "C#3";
					case "---@":
						return "F#3";
					case "#---":
						return "E2";
					case "-#--":
						return "A2";
					case "--#-":
						return "D3";
					case "---#":
						return "G3";
					default:
						return "-";
				}
			case 5:
				switch(in) {
					case "0----":
						return "B0";
					case "-0---":
						return "E1";
					case "--0--":
						return "A1";
					case "---0-":
						return "D2";
					case "----0":
						return "G2";
					case "1----":
						return "C1";
					case "-1---":
						return "F1";
					case "--1--":
						return "A#1";
					case "---1-":
						return "D#2";
					case "----1":
						return "G#2";
					case "2----":
						return "C#1";
					case "-2---":
						return "F#1";
					case "--2--":
						return "B1";
					case "---2-":
						return "E2";
					case "----2":
						return "A2";
					case "3----":
						return "D1";
					case "-3---":
						return "G1";
					case "--3--":
						return "C2";
					case "---3-":
						return "F2";
					case "----3":
						return "A#2";
					case "4----":
						return "D#1";
					case "-4---":
						return "G#1";
					case "--4--":
						return "C#2";
					case "---4-":
						return "F#2";
					case "----4":
						return "B2";
					case "5----":
						return "E1";
					case "-5---":
						return "A1";
					case "--5--":
						return "D2";
					case "---5-":
						return "G2";
					case "----5":
						return "C3";
					case "6----":
						return "F1";
					case "-6---":
						return "A#1";
					case "--6--":
						return "D#2";
					case "---6-":
						return "G#2";
					case "----6":
						return "C#3";
					case "7----":
						return "F#1";
					case "-7---":
						return "B1";
					case "--7--":
						return "E2";
					case "---7-":
						return "A2";
					case "----7":
						return "D3";
					case "8----":
						return "G1";
					case "-8---":
						return "C2";
					case "--8--":
						return "F2";
					case "---8-":
						return "A#2";
					case "----8":
						return "D#3";
					case "9----":
						return "G#1";
					case "-9---":
						return "C#2";
					case "--9--":
						return "F#2";
					case "---9-":
						return "B2";
					case "----9":
						return "E3";
					case "!----":
						return "A1";
					case "-!---":
						return "D2";
					case "--!--":
						return "G2";
					case "---!-":
						return "C3";
					case "----!":
						return "F3";
					case "@-----":
						return "A#1";
					case "-@---":
						return "D#2";
					case "--@--":
						return "G#2";
					case "---@-":
						return "C#3";
					case "----@":
						return "F#3";
					case "#----":
						return "B1";
					case "-#---":
						return "E2";
					case "--#--":
						return "A2";
					case "---#-":
						return "D3";
					case "----#":
						return "G3";
					default:
						return "-";
				}
			default:
				throw new IllegalArgumentException();
		}
		
		
	}
}
