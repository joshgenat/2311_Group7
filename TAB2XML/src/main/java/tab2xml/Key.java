package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Key {
	// For Drums
	static void key(Document doc, Element attributes, DrumNoteObject o) {
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
		
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("" + o.fifths) ); 
			key.appendChild(fifths);
	}
	
	// For Guitars
	static void key(Document doc, Element attributes, GuitarNoteObject g) {
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
		
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("" + g.fifths) ); 
			key.appendChild(fifths);
	}
}
