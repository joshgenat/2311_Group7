package tab2xml;

//h
public class GuitarNotes {
	
	public String note;
	public String type;
	public int alter;
	public int octave;
	public int string;
	public int fret;
	public int duration = 0;
	public int voice = 1;
	public int measure;
	public char step;
	public boolean isChord;
	public boolean nextMeasure;
	public boolean isHammer;
	public GuitarNotes hammerTo;
	public boolean isPull;
	public GuitarNotes pullTo;
	
	public GuitarNotes(String note, int octave, int string, int fret, int measure){
		this.note = note;
		this.step = note.charAt(0);
		this.octave = octave;
		this.string = string;
		this.fret = fret;
		this.measure = measure;
		isChord = false;
		isHammer = false;
		isPull = false;
		hammerTo = null;
		pullTo = null;
		type = "16th";
		
		if(note.length() == 2)
			alter = 1;
	}
	
	public GuitarNotes(int string){
		this.note = "-";
		this.octave = -1;
		this.string = string;
		this.fret = -1;
		type = "16th";
		this.step = '-';
		measure = -1;
	}
	
	public void setDuration (int dur) {
		duration = dur;
		if(hammerTo != null) {
			hammerTo.duration = dur;
		}
		if(pullTo != null) {
			pullTo.duration = dur;
		}
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
				break;
			default:
				type = "16th";
		}
	}
	
	public void setHammer(GuitarNotes a) {
		isHammer = true;
		hammerTo = a;
	}
	
	public void setPull(GuitarNotes a) {
		isPull = true;
		pullTo = a;
	}
	
	public String toString() {
		if(octave != -1)
			return note + octave;
		else
			return note;
	}
}
