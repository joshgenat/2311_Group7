package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Divisions {
	
	static void divisions(Document doc, Element attributes, DrumNoteObject o) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + o.divisions) ); 
		attributes.appendChild(divisions); 
		
	}
	

	
	
}
