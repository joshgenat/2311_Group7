package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Clef {
	
	public static void clef(Document doc, Element attributes, int i, String j) {
	Element clef = doc.createElement("clef");    
	attributes.appendChild(clef); 
		
	if (i != 0)
	sign(doc, clef, j);
	
	if (i != 0)
	line(doc, clef, i);
	}
	
	static void sign(Document doc, Element clef, String i) {
		Element sign = doc.createElement("sign");        
		sign.appendChild(doc.createTextNode("" + i) ); 
		clef.appendChild(sign); 
	}
	
	static void line(Document doc, Element clef, int i) {
		Element line= doc.createElement("line");        
		line.appendChild(doc.createTextNode("" + i) ); 
		clef.appendChild(line);
	}
}
