package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Barline {

	static void barline(Document doc, Element measureNumber) {
		Element barline = doc.createElement("barline");
		barline.setAttribute("location", "right");
		measureNumber.appendChild(barline); 
		
			Element barstyle = doc.createElement("staff-lines");        
			barstyle.appendChild(doc.createTextNode("light-heavy") ); 
			barline.appendChild(barstyle); 
	}
}
