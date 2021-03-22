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
		duration(doc, note, o, j);
		instrumentId(doc, note, o, j);
		voice(doc, note, o, j);
		type(doc, note, o, j);
		stem(doc, note, o, j);
        noteHead(doc, note, o, j);
        
        if(o.notes.get(j))  
		//beamNumber(doc, note, o, j);
        if(o.notes.get(j).)
        //beamNumber2(doc, note, o, j);
		
	}
	
	static void chord(Document doc, Element note) {
		Element chord = doc.createElement("chord");
		note.appendChild(chord); 
	}
	
	static void unpitched(Document doc, Element note, DrumNoteObject o, int j) {
		Element unpitched = doc.createElement("unpitched");    
		note.appendChild(unpitched);
			
			displayStep(doc, unpitched, o, j);
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
		
	static void duration(Document doc, Element note, DrumNoteObject o, int j) {
		Element duration = doc.createElement("duration");   
		duration.appendChild(doc.createTextNode("" + o.notes.get(j).duration) ); 
		note.appendChild(duration);	
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
	
	static void stem(Document doc, Element note, DrumNoteObject o, int j) {
		Element stem = doc.createElement("stem");   
		stem.appendChild(doc.createTextNode("" + o.notes.get(j).stem) ); 
		note.appendChild(stem);	
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
		beamNumber.appendChild(doc.createTextNode("" + o.notes.get(j).beamNumber) );
		note.appendChild(beamNumber);	
	}
	
	static void beamNumber2(Document doc, Element note, DrumNoteObject o, int j) {
		Element beamNumber2 = doc.createElement("beam");   
		beamNumber2.setAttribute("number", "2");
		beamNumber2.appendChild(doc.createTextNode("" + o.notes.get(j).beamNumber2) );
		note.appendChild(beamNumber2);	
	}
}
