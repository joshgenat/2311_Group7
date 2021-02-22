package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Barline {

	static void barline(Document doc, Element measureNumber, GuitarNoteObject g) {
		Element barline = doc.createElement("barline");
		barline.setAttribute("location", "right");
		measureNumber.appendChild(barline); 
		
			barStyle(doc, barline, g); 
	}
	
		static void barStyle(Document doc, Element barline, GuitarNoteObject g) {
			Element barstyle = doc.createElement("bar-style");        
			barstyle.appendChild(doc.createTextNode("" + g.barStyle) ); 
			barline.appendChild(barstyle); 
		}
}
