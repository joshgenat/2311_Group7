package tab2xml;

public class GuitarConverter {
	

	public static GuitarChord[] converter(char[][] in) { 
		GuitarNotes[][] out = new GuitarNotes[in.length][in[0].length];
		GuitarChord chords[] = new GuitarChord[in[0].length];
		int[] skip = new int[in.length];
		int threshold = 3;
		int fret;
		int lastChord = 0;
		int dur = 1;
		boolean hasNotes = false;
		int i2 = 0;
		int measure = 0;

		for(int i = 0; i < in[0].length - 2; i++) {
			GuitarChord chord = new GuitarChord(in.length);
			hasNotes = false;
			
			if(in[0][i] == '|')
				measure++;
			
			if(isTab(in[0][i]) && isTab(in[0][i+1])) {
				//i++;
				for(int j = 0; j < in.length; j++) {
					if(in[j][i] == '-') {
						out[j][i] = new GuitarNotes(j+1);
						chord.put(out[j][i]);
						skip[j] = 0;
					}	
					else {
						if(skip[j] == 0) {
							if(in[j][i+1] == '-') {
								fret = ((int)in[j][i] - 48);
								out[j][i] = indexToNote(j, i, fret, measure);
								chord.put(out[j][i]);
								skip[j] = 0;
								
							}
							else {
								fret = 10*((int)in[j][i] - 48) + ((int)in[j][i+1] - 48);
								out[j][i] = indexToNote(j, i, fret, measure);
								chord.put(out[j][i]);
								skip[j] = 1;
							}
							hasNotes = true;
						}
						else {
							skip[j] = 0;
							out[j][i] = new GuitarNotes(j+1);
							chord.put(out[j][i]);
						}
					}
						
				}
				
					/*
					 * for(int i3 = 0; i3 < in.length; i3++) { out[i3][i+1] = new GuitarNotes(i3+1);
					 * }
					 */
				
			}
			else {
				dur = 0;
				if(i > threshold)
					chords[lastChord].setMeasures();
			};
			
			chords[i2] = chord;
			if(hasNotes) {
				chords[lastChord].setDurations((dur+1)/2);
				dur = 1;
				lastChord = i2;
				//System.out.println(chord);
				i2++;
			}
			else if(!hasNotes) {
				dur++;
			}
			
			if(i == in[0].length - 3)
				chords[lastChord].setDurations((dur+1)/2);
		}	
		return chords;
	}
	

	public static GuitarNotes indexToNote(int i, int j, int fret, int measure) {
		//System.out.println("indexToNote fret: " + fret);
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
		
		return new GuitarNotes(intToNote(rem), octave, i+1 , fret, measure);
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
}
