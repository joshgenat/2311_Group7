package tab2xml;

import java.util.ArrayList;

public class GuitarNoteObject {

	Tab tab;
	int divisions;
	int fifths;
	int beats;
	int beatsType;
	String clef;
	ArrayList<GuitarNotes> notes = new ArrayList<GuitarNotes>();
	GuitarChord chords[];
	
	GuitarConverter convert = new GuitarConverter();
	
	public GuitarNoteObject(Tab tab) {
		this.tab = tab;
		String clef = "Guitar";
		int divisions = 4;
		int fifths = 0;
		int beats = 4;
		int beatsType = 4;

		for(int i = 0; i < tab.nodes.size(); i++) {
			chords = convert.converter(tab.nodes.get(i).nodes);
			for(int j = 0; j < chords.length; j++) {
				if(chords[j] == null) break;
				for(int k = 0; k < chords[j].notes.length; k++) {
					if(chords[j].notes[k].octave != -1)
						notes.add(chords[j].notes[k]);
				}
			}
		}
	}
}
