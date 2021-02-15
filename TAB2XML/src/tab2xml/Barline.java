package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Barline {

	static void barline(Document doc, Element measureNumber, String i) {
		Element barline = doc.createElement("barline");
		barline.setAttribute("location", "right");
		measureNumber.appendChild(barline); 
		
			barStyle(doc, barline, i); 
	}
	
	static void barStyle(Document doc, Element barline, String i) {
		Element barstyle = doc.createElement("staff-lines");        
		barstyle.appendChild(doc.createTextNode("" + i) ); 
		barline.appendChild(barstyle); 
	}
}
