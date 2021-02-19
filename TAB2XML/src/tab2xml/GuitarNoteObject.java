package tab2xml;

public class GuitarNoteObject {
	String note;
	int octave;
	int string;
	int fret;
	int duration;
	int division = 1;
	char step;
	
	public GuitarNoteObject(String note, int octave, int string, int fret){
		this.note = note;
		this.step = note.charAt(0);
		this.octave = octave;
		this.string = string;;
		this.fret = fret;
	}
	
	public GuitarNoteObject(int string){
		this.note = "-";
		this.octave = -1;
		this.string = string;
		this.fret = 0;
	}
	
	public String toString() {
		if(octave != -1)
			return note + octave;
		else
			return note;
	}
}
