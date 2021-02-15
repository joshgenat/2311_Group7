package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Key {
	static void key(Document doc, Element attributes, int i) {
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
		
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("" + i) ); 
			key.appendChild(fifths);
	}
}
