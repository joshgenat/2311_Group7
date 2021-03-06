package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Time {
	public static void time(Document doc, Element attributes, DrumNoteObject o) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
		
		if (o != null)
		beats(doc, time, o);
			
		if (o != null)
		beatType(doc, time,o);
	}
	
	static void beats(Document doc, Element time, DrumNoteObject o) {
		Element beats = doc.createElement("beats");        
		beats.appendChild(doc.createTextNode("" + o.beats) ); 
		time.appendChild(beats); 
	}
	
	static void beatType(Document doc, Element time, DrumNoteObject o) {
		Element beatType= doc.createElement("beat-type");        
		beatType.appendChild(doc.createTextNode("" + o.beatsType) ); 
		time.appendChild(beatType);
	}
}
