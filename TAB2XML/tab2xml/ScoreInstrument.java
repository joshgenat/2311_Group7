package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ScoreInstrument {

	public static void scoreInstrument(Document doc, Element rootElement, String i) {
		Element scoreInstrument = doc.createElement("score-instrument"); 
		scoreInstrument.setAttribute("id", "" + i);
		rootElement.appendChild(scoreInstrument); 
		
		instrumentName(doc, scoreInstrument, "Bass Drum");
			 
	}
	
	static void instrumentName(Document doc, Element scoreInstrument, String i) {
		Element instrumentName = doc.createElement("instrument-name"); 
		instrumentName.appendChild(doc.createTextNode("Bass Drum") ); 
		scoreInstrument.appendChild(instrumentName);  
	}
}
