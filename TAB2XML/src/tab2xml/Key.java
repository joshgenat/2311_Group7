package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Key {
	static void key(Document doc, Element attributes, DrumNoteObject o) {
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
		
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("" + o.key) ); 
			key.appendChild(fifths);
	}
}
