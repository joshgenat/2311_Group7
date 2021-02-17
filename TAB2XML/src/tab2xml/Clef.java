package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Clef {
	
	public static void clef(Document doc, Element attributes, DrumNoteObject o) {
	Element clef = doc.createElement("clef");    
	attributes.appendChild(clef); 
		
	if (o != null)
	sign(doc, clef, o);
	
	if (o != null)
	line(doc, clef, o);
	}
	
	static void sign(Document doc, Element clef, DrumNoteObject o) {
		Element sign = doc.createElement("sign");        
		sign.appendChild(doc.createTextNode("" + o) ); 
		clef.appendChild(sign); 
	}
	
	static void line(Document doc, Element clef, DrumNoteObject o) {
		Element line= doc.createElement("line");        
		line.appendChild(doc.createTextNode("" + o) ); 
		clef.appendChild(line);
	}
}
