package tab2xml;

public class GuitarChord {
	public GuitarNotes[] notes;
	int pos;
	private int addAt;
	private int size;
	private int duration;
	private int numNotes;
	private boolean isChord;
	private boolean skipped;
	
	public GuitarChord(GuitarNotes[] notes, int i) {
		this.notes = notes;
		pos = i;
	}
	
	public GuitarChord(int size) {
		notes = new GuitarNotes[size];
		for(int i = 0; i < size; i++)
			notes[i] = null;
		addAt = 0;
		size = 0;
		numNotes = 0;
		isChord = false;
	}
	
	public void put(GuitarNotes a) {
		if(addAt < notes.length) {
			notes[addAt] = a;
			addAt++;
			size++;
			if(!a.note.equals("-"))
				numNotes++;
		}
		
		if(numNotes > 1) {
			setChordBoolTrue();
		}
	}
	
	
	public void setDurations(int dur) {
		for(int i = 0; i < size; i++) {
			if(!notes[i].note.equals("-"))
				notes[i].setDuration(dur);
		}
	}
	
	private void setChordBoolTrue() {
		skipped = false;
		for(int i = 0; i < notes.length; i++) {
			if(notes[i] != null && notes[i].step != '-') {
				if(skipped) {
					notes[i].isChord = true;
				}else
					skipped = true;
			}
		}
	}
	
	public void setMeasures() {
		for(int i = 0; i < notes.length; i++) {
			if(notes[i] != null)
				notes[i].nextMeasure = true;
		}
	}
	

	
	public String toString() {
		String out = "";
		for(int i = 0; i < size; i++) {
			out = out + notes[i] + ", ";
		}
		return out;
	}
}
