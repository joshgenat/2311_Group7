package tab2xml;

import java.util.ArrayList;

public class GuitarNoteObject {

	Tab tab;
	int divisions;
	int fifths;
	int beats;
	int beatsType;
	String sign;
	int line;
	int staffLines;
	ArrayList<GuitarNotes> notes = new ArrayList<GuitarNotes>();
	ArrayList<Character> tStep = new ArrayList<>();
	ArrayList<Integer> tOctave = new ArrayList<>();
	int maxMeasure;
	GuitarChord chords[];
	
	GuitarConverter convert = new GuitarConverter();
	
	public GuitarNoteObject(Tab tab) {
		//Intilization for now
		tStep.add('E');
		tStep.add('A');
		tStep.add('D');
		tStep.add('G');
		tStep.add('B');
		tStep.add('E');
		tOctave.add(2);
		tOctave.add(2);
		tOctave.add(3);
		tOctave.add(3);
		tOctave.add(3);
		tOctave.add(4);
		staffLines = 6;
		this.tab = tab;
		sign = "TAB";
		line = 5;
		divisions = 4;
		fifths = 0;
		beats = 4;
		beatsType = 4;

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
		maxMeasure = notes.get(notes.size()-1).measure;
	}
}
