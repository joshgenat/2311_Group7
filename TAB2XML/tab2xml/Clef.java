package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Clef {
	
	public static void clef(Document doc, Element attributes) {
	Element clef = doc.createElement("clef");    
	attributes.appendChild(clef); 
		
		Element sign = doc.createElement("sign");        
		sign.appendChild(doc.createTextNode("TAB") ); 
		clef.appendChild(sign); 
			
		Element line= doc.createElement("line");        
		line.appendChild(doc.createTextNode("5") ); 
		clef.appendChild(line);
	}
}
