package tab2xml;

public class GuitarConverter {
	
	//Main
	
	public static void main(String args[]) {
		char[][] test1 = {
				{'e', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'B', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '3', '-', '|'},
				{'G', '|', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'D', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '|'},
				{'A', '|', '-', '-', '-', '-', '-', '1', '0', '-', '-', '2', '0', '-', '-', '-', '-', '|'},
				{'E', '|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '|'}
		};
		char[][] test2 = {
				{'|', '0', '0', '0', '0', '0', '0', '0', '0'},
				{'|', '1', '2', '3', '4', '5', '6', '7', '8'},
				{'|', '2', '8', '8', '8', '8', '8', '0', '0'},
				{'|', '3', '0', '0', '0', '0', '0', '0', '0'},
				{'|', '4', '2', '3', '4', '5', '6', '7', '8'},
				{'|', '5', '8', '8', '8', '8', '8', '0', '0'},
				{'|', '6', '0', '0', '0', '0', '0', '0', '0'},
				{'7', '7', '2', '3', '4', '5', '6', '7', '8'},
				{'8', '8', '8', '8', '8', '8', '8', '0', '0'},
				{'9', '9', '0', '0', '0', '0', '0', '0', '0'},
				{'!', '!', '2', '3', '4', '5', '6', '7', '8'},
				{'@', '@', '8', '8', '8', '8', '8', '0', '0'},
				{'#', '#', '8', '8', '8', '8', '8', '0', '0'}
		};
		
		GuitarNoteObject[][] notes = converter(test1);
		//notes = removeNull(notes);
		
		System.out.println("\n test \n");
		
		for(int i = 0; i < test1.length; i++) {
			for(int j = 0; j < test1[0].length; j++) {
					System.out.print(test1[i][j]);
				}
			System.out.println();
		}
		
		System.out.println("\n result \n");
		
		for(int i = 0; i < notes.length; i++) {
			for(int j = 0; j < notes[0].length; j++) {
					System.out.print(notes[i][j] + " ");
				}
			System.out.println();
		}
		char fret = '9';
		GuitarNoteObject testNote = indexToNote(0, 5, (int)fret - 48);
		System.out.println(testNote);
			
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
	
	public static GuitarNoteObject[][] converter(char[][] in) { 
		GuitarNoteObject[][] out = new GuitarNoteObject[in.length][in[0].length];
		int fret;
		for(int i = 0; i < in.length; i++) {
			for(int j = 0; j < in[0].length - 1; j++) {
				if(isTab(in[i][j])) {
					if(in[i][j] == '-')
						out[i][j] = new GuitarNoteObject(i);
					else {
						if(in[i][j+1] == '-') {
							fret = ((int)in[i][j] - 48);
							out[i][j] = indexToNote(i, j, fret);
						}
						else {
							fret = 10*((int)in[i][j] - 48) + ((int)in[i][j+1] - 48);
							out[i][j] = indexToNote(i, j, fret);
							out[i][j+1] = new GuitarNoteObject(i);
							j++;
						}
					}
				}
			}
		}
		
		return out;
	}
	
	/* OLD
	 * public static GuitarNoteObject[][] converter(char[][] in) { 
		GuitarNoteObject[][] out = new GuitarNoteObject[in.length][in[0].length];;
		GuitarNoteObject[] col;
		boolean hasNotes = false;
		int i, i2, j, j2, fret;
		i2 = 0;
		for(i = 0; i < out.length; i++) {
			if(isTab(in[i][0])) {
				col = new GuitarNoteObject[in[0].length];
				for(j = 0; j < out[i].length; j++) {
					if(in[i][j] == '-')
						col[j] = new GuitarNoteObject(i);
					else {
						if(in[i][j] == '-')
							fret = (int)in[i][j];
						else
							fret = 10*(int)in[i][j] + (int)in[i+1][j];
						col[j] = indexToNote(i, j, fret);
						hasNotes = true;
					}
					
				}
				if(hasNotes) {
					hasNotes = false;
					out[i2] = col;
					i2++;
					i++;
				}
			}
		}
		
		return out;
	}
	*/

	public static GuitarNoteObject indexToNote(int i, int j, int fret) {
		System.out.println("indexToNote fret: " + fret);
		int rem;
		int octave;
		if(i < 2) {
			rem = (4 + fret + 7 * i) % 12;
			octave = (4 - i) + (fret + 4 + 7 * i) / 12;
		}
		else {
			rem = (5 + fret + 7 * i) % 12;
			octave = ((53 - 5*i)  + fret) / 12;
		}
		
		return new GuitarNoteObject(intToNote(rem), octave, j, fret);
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
	
	public static boolean isTab(char c) {
		switch(c) {
			case '0':
				return true;
			case '1':
				return true;
			case '2':
				return true;
			case '3':
				return true;
			case '4':
				return true;
			case '5':
				return true;
			case '6':
				return true;
			case '7':
				return true;
			case '8':
				return true;
			case '9':
				return true;
			case '-':
				return true;
			default:
				return false;
		}
	}
	
	public static GuitarNoteObject[][] removeNull(GuitarNoteObject[][] in){
		int i, j;
		for(i = 0; i <= in.length; i++){
			if(in[i][0] == null) 
				break;
		}
		GuitarNoteObject[][] out = new GuitarNoteObject[i][in[0].length];
		for(j = 0; j < i; j++) {
			out[j] = in[j];
		}
		return out;
	}
	
	public String stringToNote(String in) {
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
