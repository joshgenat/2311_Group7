package tab2xml;

public class GuitarChord {
	GuitarNoteObject[] notes;
	int pos;
	private int addAt;
	private int size;
	private int duration;
	
	public GuitarChord(GuitarNoteObject[] notes, int i) {
		this.notes = notes;
		pos = i;
	}
	
	public GuitarChord(int size) {
		notes = new GuitarNoteObject[size];
		for(int i = 0; i < size; i++)
			notes[i] = null;
		addAt = 0;
		size = 0;
	}
	
	public void put(GuitarNoteObject a) {
		if(addAt < notes.length) {
			notes[addAt] = a;
			addAt++;
			size++;
		}
	}
	
	public GuitarNoteObject get(int i) {
		return notes[i];
	}
	
	public int size() {
		return size;
	}
	
	public void setDurations(int dur) {
		for(int i = 0; i < size; i++) {
			if(!notes[i].note.equals("-"))
				notes[i].setDuration(dur);
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
