package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DrumNote {

	static void note(Document doc, Element measureNumber, int i) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
		unpitched(doc, note, 1, 2);
		
		duration(doc, note, 1);
		instrumentId(doc, note, 1);
		voice(doc, note, 1);
		type(doc, note, "eigth");
		stem(doc, note, "up");
		noteHead(doc, note, "x");
		beamNumber(doc, note, "begin");
		
	}
	
	static void unpitched(Document doc, Element note, int i, int j) {
		Element unpitched = doc.createElement("unpitched");    
		note.appendChild(unpitched);
			
			displayStep(doc, unpitched, i);
			displayOctave(doc, unpitched, j);
		
	}
	
		static void displayStep(Document doc, Element unpitched, int i) {
			Element displayStep = doc.createElement("display-step");        
			displayStep.appendChild(doc.createTextNode("" + i) ); 
			unpitched.appendChild(displayStep);
		}
	
		static void displayOctave(Document doc, Element unpitched, int j) {
			Element displayOctave = doc.createElement("display-octave");        
			displayOctave.appendChild(doc.createTextNode("" + j) ); 
			unpitched.appendChild(displayOctave);
		}
		
	static void duration(Document doc, Element note, int i) {
		Element duration = doc.createElement("duration");   
		duration.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(duration);	
	}
	
	static void instrumentId(Document doc, Element note, int i) {
		Element instrumentId = doc.createElement("instrument");   
		instrumentId.setAttribute("id", "P1-I50");
		note.appendChild(instrumentId);	
	}
	
	static void voice(Document doc, Element note, int i) {
		Element voice = doc.createElement("voice");   
		voice.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(voice);	
	}
	
	static void type(Document doc, Element note, String i) {
		Element type = doc.createElement("type");   
		type.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(type);	
	}
	
	static void stem(Document doc, Element note, String i) {
		Element stem = doc.createElement("stem");   
		stem.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(stem);	
	}
	
	static void noteHead(Document doc, Element note, String i) {
		Element noteHead = doc.createElement("notehead");   
		noteHead.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(noteHead);	
	}
	
	static void beamNumber(Document doc, Element note, String i) {
		Element beamNumber = doc.createElement("beam");   
		beamNumber.setAttribute("number", "1");
		beamNumber.appendChild(doc.createTextNode("" + i) );
		note.appendChild(beamNumber);	
	}
}
