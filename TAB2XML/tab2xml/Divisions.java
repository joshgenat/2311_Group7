package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Divisions {
	
	static void divisions(Document doc, Element attributes, int i, int j) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + i) ); 
		attributes.appendChild(divisions); 
		
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
			
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("" + j) ); 
			key.appendChild(fifths);
	}
	
	
}
