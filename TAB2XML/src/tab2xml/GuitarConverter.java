package tab2xml;

public class GuitarConverter {
	
	//Main
	
	public static void main(String args[]) {
		char[][] test1 = {
				{'0', '0', '0', '0', '0', '0'},
				{'7', '7', '7', '7', '7', '7'},
				{'8', '8', '8', '8', '8', '8'}
		};
		char[][] test2 = {
				{'0', '0', '0', '0', '0', '0', '0'},
				{'7', '7', '7', '7', '7', '7', '7'},
				{'8', '8', '8', '8', '8', '8', '8'}
		};
		String[][] notes = Converter(test2);
		
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
	 * 5--3------
	 * -------9-- 
	 * 
	 * @param	in	2d char array parsed from tab format
	 * @return	out	2d String array of notes at their corresponding positions on the tab
	 */
	
	
	public static String[][] Converter(char[][] in) { 
		String[][] out;
		String tmp; 
		int i, j, j2;
		out = new String[in.length][in[0].length];
		for(i = 0; i < out.length; i++) {
			tmp = "";
			for(j = 0; j < out[i].length; j++) {
				tmp = "";
				for(j2 = 0; j2 < out[i].length; j2++) {
					if(in[i][j] == '-') // j2 == j
						out[i][j] = "-";	//tmp = tmp + in[i][j]; 
					else
						out[i][j] = IndexToNote(i, j, in[i][j]); //tmp = tmp + '-';
				}
				//out[i][j] = StringToNote(tmp);
			}
		}
		
		return out;
	}
	
	/*
	 * Returns a note string that corresponds to the tab column
	 * @param	in	String representing a column of characters from a tab e.g "-1-4--"
	 * @return		Note string, corresponding to tab
	 */
	
	public static String IndexToNote(int i, int j, char c) {
		int k = CharToInt(c);
		int rem = (4 + k + 5 * j) % 12;
		
		return rem + IntToNote(rem) + ((28 + 5 * j + k) / 12);
	}
	
	public static String IntToNote(int a) {
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
	
	public static int CharToInt(char c) {
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
				return '\0';
		}
	}
	
	public String StringToNote(String in) {
		switch(in) {
			case "0-----":
				return "E4";
			case "-0----":
				return "B3";
			case "--0---":
				return "G3";
			case "---0--":
				return "D3";
			case "----0-":
				return "A2";
			case "-----0":
				return "E2";
			case "1-----":
				return "F4";
			case "-1----":
				return "C4";
			case "--1---":
				return "Ab3";
			case "---1--":
				return "Eb3";
			case "----1-":
				return "Bb2";
			case "-----1":
				return "F2";
			case "2-----":
				return "F#4";
			case "-2----":
				return "C#4";
			case "--2---":
				return "A3";
			case "---2--":
				return "E3";
			case "----2-":
				return "B2";
			case "-----2":
				return "F#2";
			case "3-----":
				return "G4";
			case "-3----":
				return "D4";
			case "--3---":
				return "Bb3";
			case "---3--":
				return "F3";
			case "----3-":
				return "C3";
			case "-----3":
				return "G2";
			case "4-----":
				return "Ab4";
			case "-4----":
				return "Eb4";
			case "--4---":
				return "B3";
			case "---4--":
				return "F#3";
			case "----4-":
				return "C#3";
			case "-----4":
				return "Ab2";
			case "5-----":
				return "A4";
			case "-5----":
				return "E4";
			case "--5---":
				return "C4";
			case "---5--":
				return "G3";
			case "----5-":
				return "D3";
			case "-----5":
				return "A2";
			case "6-----":
				return "Bb4";
			case "-6----":
				return "F4";
			case "--6---":
				return "C#4";
			case "---6--":
				return "Ab3";
			case "----6-":
				return "Eb3";
			case "-----6":
				return "Bb2";
			case "7-----":
				return "B4";
			case "-7----":
				return "F#4";
			case "--7---":
				return "D4";
			case "---7--":
				return "A3";
			case "----7-":
				return "E3";
			case "-----7":
				return "B2";
			case "8-----":
				return "C5";
			case "-8----":
				return "G4";
			case "--8---":
				return "Eb4";
			case "---8--":
				return "Bb3";
			case "----8-":
				return "F3";
			case "-----8":
				return "C3";
			case "9-----":
				return "C#5";
			case "-9----":
				return "Ab4";
			case "--9---":
				return "E4";
			case "---9--":
				return "B3";
			case "----9-":
				return "F#3";
			case "-----9":
				return "C#3";
			case "!-----":
				return "D5";
			case "-!----":
				return "A4";
			case "--!---":
				return "F4";
			case "---!--":
				return "C4";
			case "----!-":
				return "G3";
			case "-----!":
				return "D3";
			case "@-----":
				return "Eb5";
			case "-@----":
				return "Bb4";
			case "--@---":
				return "F#4";
			case "---@--":
				return "C#4";
			case "----@-":
				return "Ab3";
			case "-----@":
				return "Eb3";
			case "#-----":
				return "E5";
			case "-#----":
				return "B4";
			case "--#---":
				return "G4";
			case "---#--":
				return "D4";
			case "----#-":
				return "A3";
			case "-----#":
				return "E3";
			default:
				return "-";
		}
	}
}
