package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DrumNote {

	static void note(Document doc, Element measureNumber, DrumNoteObject o, int j) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
		if (o.notes.get(j).chord == true) 
			chord(doc, note);
		
		unpitched(doc, note, o, j);
		stem(doc, note, o, j);
		instrumentId(doc, note, o, j);
		voice(doc, note, o, j);
		type(doc, note, o, j);
        noteHead(doc, note, o, j);
      
        /*
=======
        
>>>>>>> branch 'develop' of https://github.com/joshgenat/2311_Group7
        if(o.beam1Statusfinder.get(j) == null)  
		beamNumber(doc, note, o, j);
        if(o.beam2Statusfinder.get(j) == null)
        beamNumber2(doc, note, o, j);
        
//        for (int i = 0; i < r; i++)
        dot(doc, note, o);
<<<<<<< HEAD
		*/
	}
	
	static void chord(Document doc, Element note) {
		Element chord = doc.createElement("chord");
		note.appendChild(chord); 
	}
	
	static void unpitched(Document doc, Element note, DrumNoteObject o, int j) {
		Element unpitched = doc.createElement("unpitched");    
		note.appendChild(unpitched);
			
			displayStep(doc, unpitched,  o, j);
			displayOctave(doc, unpitched, o, j);
		
	}
	
		static void displayStep(Document doc, Element unpitched, DrumNoteObject o, int j) {
			Element displayStep = doc.createElement("display-step");        
			displayStep.appendChild(doc.createTextNode("" + o.notes.get(j).displayStep) ); 
			unpitched.appendChild(displayStep);
		}
	
		static void displayOctave(Document doc, Element unpitched, DrumNoteObject o, int j) {
			Element displayOctave = doc.createElement("display-octave");        
			displayOctave.appendChild(doc.createTextNode("" + o.notes.get(j).displayOctave) ); 
			unpitched.appendChild(displayOctave);
		}
		
	static void stem(Document doc, Element note, DrumNoteObject o, int j) {
		Element stem = doc.createElement("stem");   
		stem.appendChild(doc.createTextNode("" + o.notes.get(j).stem) ); 
		note.appendChild(stem);	
	}
	
	static void instrumentId(Document doc, Element note, DrumNoteObject o, int j) {
		Element instrumentId = doc.createElement("instrument");   
		instrumentId.setAttribute("id", "" + o.notes.get(j).instrumentID);
		note.appendChild(instrumentId);	
	}
	
	static void voice(Document doc, Element note, DrumNoteObject o, int j) {
		Element voice = doc.createElement("voice");   
		voice.appendChild(doc.createTextNode("" + o.notes.get(j).voiceNumber) ); 
		note.appendChild(voice);	
	}
	
	static void type(Document doc, Element note, DrumNoteObject o, int j) {
		Element type = doc.createElement("type");   
		type.appendChild(doc.createTextNode(o.notes.get(j).type)); 
		note.appendChild(type);	
	}
	
	static void noteHead(Document doc, Element note, DrumNoteObject o, int j) {
		// Check if noteHead is an 'x' or an 'o'
		if (o.noteHeadType.get(j).equals('x')) {
		Element noteHead = doc.createElement("notehead"); 
		noteHead.appendChild(doc.createTextNode("x") ); 
		note.appendChild(noteHead);
		}
	}
	
	static void beamNumber(Document doc, Element note, DrumNoteObject o, int j) {
		Element beamNumber = doc.createElement("beam");   
		beamNumber.setAttribute("number", "1");
		beamNumber.appendChild(doc.createTextNode("" + o.beam1Statusfinder.get(j)) );
		note.appendChild(beamNumber);	
	}
	
	static void beamNumber2(Document doc, Element note, DrumNoteObject o, int j) {
		Element beamNumber2 = doc.createElement("beam");   
		beamNumber2.setAttribute("number", "2");
		beamNumber2.appendChild(doc.createTextNode("" + o.beam2Statusfinder.get(j)) );
		note.appendChild(beamNumber2);	
	}
	
	static void dot(Document doc, Element note, DrumNoteObject o) {
		Element dot = doc.createElement("dot");   
		dot.appendChild(doc.createTextNode(""));
		note.appendChild(dot);	
	}

	// Note Tester
	
	public static String noteTest(int[] s) {
		StringBuilder sb = new StringBuilder();
		sb.append("<note>");  
		
		if (s[0] != 0)
			chord(s, sb);
		
		
				
		
		sb.append("\n</note>");
		return sb.toString();
	}
	static void chord(int[] s, StringBuilder sb) {
		sb.append("\n\t<chord>" + s[0] + "</chord>");
	}
	
	static void unpitched(int[] s, StringBuilder sb) {
		sb.append("\n\t<unpitched>" + s[0] + "</unpitched>");
		
		displayStep(s, sb);
		displayOctave(s, sb);
	}
	
		static void displayStep(int[] s, StringBuilder sb) {
			sb.append("\n\t<displayStep>" + s[0] + "</displayStep>");
		}
	
		static void displayOctave(int[] s, StringBuilder sb) {
			sb.append("\n\t<displayOctave>" + s[0] + "</displayOctave>");
		}
		
	static void stem(int[] s, StringBuilder sb) {
		sb.append("\n\t<stem>" + s[0] + "</stem>");
	}
	
	static void instrumentID(int[] s, StringBuilder sb) {
		sb.append("\n\t<instrumentID>" + s[0] + "</instrumentID>");
	}
	
	static void voice(int[] s, StringBuilder sb) {
		sb.append("\n\t<voice>" + s[0] + "</voice>");
	}
	
	static void type(int[] s, StringBuilder sb) {
		sb.append("\n\t<type>" + s[0] + "</type>");
	}
	
	static void noteHead(int[] s, StringBuilder sb) {
		sb.append("\n\t<noteHead>" + s[0] + "</noteHead>");
	}
	
		
}


