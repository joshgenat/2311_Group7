package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Divisions {
	
	// For Drums
	static void divisions(Document doc, Element attributes, DrumNoteObject o) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + o.divisions) ); 
		attributes.appendChild(divisions); 
		
	}
	
	// For Guitars
	static void divisions(Document doc, Element attributes, GuitarNoteObject g) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + g.divisions) ); 
		attributes.appendChild(divisions); 
		
	}
	
	// ForBOTH
	static void divisions(Document doc, Element attributes, int div) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + div) ); 
		attributes.appendChild(divisions); 
		
	}
	
	// Divisions Tester
	public static String divisionsTest(int[] s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<divisions>");  
		sb.append("\n" + s[0]); 
		sb.append("\n</divisions>");
		
		return sb.toString();
	}
	
}
