package tab2xml;

public class GuitarConverter {
	
	//Main
	
	public static void main(String args[]) {
		char[][] test1 = {
				{'e', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'B', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '-', '4', '-', '|'},
				{'G', '|', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '3', '-', '|'},
				{'D', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'A', '|', '-', '-', '-', '-', '-', '1', '0', '-', '-', '2', '0', '-', '-', '-', '-', '-', '-', '-', '-', '2', '1', '|'},
				{'E', '|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'}
		};
		char[][] test2 = {
				{'|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '-', '4', '-', '|'},
				{'|', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '3', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '1', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '1', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'}
				
		};
		
		GuitarNoteObject[][] notes = converter(test2);
		//notes = removeNull(notes);
		
		System.out.println("\n test \n");
		
		for(int i = 0; i < test2.length; i++) {
			for(int j = 0; j < test2[0].length; j++) {
					System.out.print(test2[i][j]);
				}
			System.out.println();
		}
		
		System.out.println("\n result \n");
		
		for(int i = 0; i < notes.length; i++) {
			for(int j = 0; j < notes[0].length; j++) {
				if(notes[i][j] != null)
					System.out.print(notes[i][j] + "*" + notes[i][j].duration + "* ");
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
		GuitarChord chords[] = new GuitarChord[in[0].length];
		int fret;
		int lastChord = 0;
		int dur = 1;
		boolean hasNotes = false;


		for(int i = 0; i < in[0].length - 2; i++) {
			GuitarChord chord = new GuitarChord(in.length);
			if(isTab(in[0][i])) {
				hasNotes = false;
				i++;
				for(int j = 0; j < in.length; j++) {
					if(in[j][i] == '-') {
						out[j][i] = new GuitarNoteObject(j);
						chord.put(out[j][i]);
					}	
					else {
						if(in[j][i+1] == '-') {
							fret = ((int)in[j][i] - 48);
							out[j][i] = indexToNote(j, i, fret);
							chord.put(out[j][i]);
						}
						else {
							fret = 10*((int)in[j][i] - 48) + ((int)in[j][i+1] - 48);
							out[j][i] = indexToNote(j, i, fret);
							chord.put(out[j][i]);
							
						}
						hasNotes = true;
					}
					for(int i2 = 0; i2 < in.length; i2++) {
						out[i2][i+1] = new GuitarNoteObject(i);
					}
				}
				
			}
			chords[i] = chord;
			if(hasNotes) {
				chords[lastChord].setDuration(dur);
				dur = 1;
				lastChord = i;

				System.out.println(chord);
			}
			else if(!hasNotes) {
				dur++;
			}
			if(i == in[0].length - 3)
				chords[lastChord].setDuration(dur);
		}	
		
		return out;
	}
	

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
