package tab2xml;

public class GuitarNotes {
	String note;
	int octave;
	int string;
	int fret;
	
	public GuitarNotes(String note, int octave, int string, int fret){
		this.note = note;
		this.octave = octave;
		this.string = string;
		this.fret = fret;
	}
	
	public GuitarNotes(int string){
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
