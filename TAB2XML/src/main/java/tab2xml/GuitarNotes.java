package tab2xml;

public class GuitarNotes {
	
	String note;
	String type = "";
	int alter;
	int octave;
	int string;
	int fret;
	int duration = 0;
	int voice = 1;
	char step;
	
	public GuitarNotes(String note, int octave, int string, int fret){
		this.note = note;
		this.step = note.charAt(0);
		this.octave = octave;
		this.string = string;;
		this.fret = fret;
		
		if(note.length() == 2)
			alter = 1;
	}
	
	public GuitarNotes(int string){
		this.note = "-";
		this.octave = -1;
		this.string = string;
		this.fret = 0;
	}
	
	public void setDuration (int dur) {
		duration = dur;
		type = "whole";
		switch(dur) {
			case(8):
				type = "whole";
				break;
			case(4):
				type = "half";
				break;
			case(2):
				type = "quarter";
				break;
			case(1):
				type = "eighth";
		}
	}
	
	public String toString() {
		if(octave != -1)
			return note + octave;
		else
			return note;
	}
}
