package tab2xml;

public class GuitarNoteObject {
	String name;
	char note;
	int octave;
	int string;
	int fret;
	int duration;
	int division = 1;
	
	public GuitarNoteObject(String name, int octave, int string, int fret){
		this.name = name;
		this.note = name.charAt(0);
		this.octave = octave;
		this.string = string;;
		this.fret = fret;
	}
	
	public GuitarNoteObject(int string){
		this.name = "-";
		this.note = '\0';
		this.octave = -1;
		this.string = string;
		this.fret = 0;
	}
	
	public String toString() {
		if(octave != -1)
			return name + octave;
		else
			return name;
	}
}
