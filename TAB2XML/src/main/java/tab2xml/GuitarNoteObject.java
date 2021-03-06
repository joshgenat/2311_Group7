package tab2xml;

import java.util.ArrayList;

import exceptions.InproperInputException;

public class GuitarNoteObject {

	String title = "Untitled";
	Tab tab;
	int divisions;
	int fifths;
	int beats;
	int beatsType;
	String sign;
	int line;
	int staffLines;
	char type;
	ArrayList<GuitarNotes> notes = new ArrayList<GuitarNotes>();
	ArrayList<Character> tStep = new ArrayList<>();
	ArrayList<Integer> tOctave = new ArrayList<>();
	ArrayList<Integer> repeats = new ArrayList<>();
	ArrayList<Integer> b = new ArrayList<>();
	ArrayList<Integer> bt = new ArrayList<>();
	ArrayList<Integer> div = new ArrayList<>();
	int maxMeasure;
	GuitarChord chords[];
	
	GuitarConverter convert = new GuitarConverter();
	
	public GuitarNoteObject(Tab tab, String sign) throws Exception {
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
		this.setSign(sign);
		line = 5;
		divisions = 4;
		fifths = 0;
		beats = 6;
		beatsType = 8;
		type = 'a';
		if(tab.Type.equals("Bass")) { type = 'b'; }
		for(int i = 0; i < tab.nodes.size(); i++) {
			repeats.add(tab.nodes.get(i).repeat);
			divisions = tab.nodes.get(i).divisions;
			this.setBeats(tab.nodes.get(i).timeSignature);
			b.add(this.beats);
			bt.add(this.beatsType);
			div.add(divisions);
			chords = convert.converter(tab.nodes.get(i).nodes, i + 1, type);
			for(int j = 0; j < chords.length; j++) {
				if(chords[j] == null) break;
				for(int k = 0; k < chords[j].notes.length; k++) {
					if(chords[j].notes[k].octave != -1)
						notes.add(chords[j].notes[k]);
				}
			}
		}
		maxMeasure = notes.get(notes.size()-1).measure;
		this.beats = b.get(0);
		this.beatsType = bt.get(0);
	}
	
	public void setSign(String sign) {
		switch(sign) {
		case "Treble":
			this.sign = "G";
			this.line = 2;
			break;
		case "Bass":
			this.line = 4;
			this.sign = "F";
			break;
		case "Tenor":
			this.line = 3;
			this.sign = "C";
			break;
		case "Tab":
			this.sign = "TAB";
			this.line = 6;
			break;
		default: 
			this.sign = "G";
			this.line = 2;
		}
	}
	
	public void setBeats(String time) throws NumberFormatException {
		if(time.isBlank()) {
			this.beats = 4;
			this.beatsType = 4;
		}
		else {
			String[] split = time.split("/");
			this.beats = Integer.parseInt(split[0]);
			this.beatsType = Integer.parseInt(split[1]);
		}
	}
}

