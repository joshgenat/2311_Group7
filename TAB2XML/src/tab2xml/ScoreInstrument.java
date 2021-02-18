package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ScoreInstrument {

	public static void scoreInstrument(Document doc, Element rootElement, DrumNoteObject o, int i) {
		Element scoreInstrument = doc.createElement("score-instrument"); 
		scoreInstrument.setAttribute("id", "" + o.instruments.get(i).partID);
		rootElement.appendChild(scoreInstrument); 
		
		instrumentName(doc, scoreInstrument, o, i);
			 
	}
	
	static void instrumentName(Document doc, Element scoreInstrument, DrumNoteObject o, int i) {
		Element instrumentName = doc.createElement("instrument-name"); 
		instrumentName.appendChild(doc.createTextNode("" + o.instruments.get(i).partName) ); 
		scoreInstrument.appendChild(instrumentName);  
	}
}
