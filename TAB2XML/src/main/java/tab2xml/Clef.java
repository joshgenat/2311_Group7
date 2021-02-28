package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Clef {
	
	 //For Drums
	public static void clef(Document doc, Element attributes, DrumNoteObject o) {
	Element clef = doc.createElement("clef");    
	attributes.appendChild(clef); 
		

	sign(doc, clef, o);
	
	line(doc, clef, o);
	}
	
		static void sign(Document doc, Element clef, DrumNoteObject o) {
			Element sign = doc.createElement("sign");        
			sign.appendChild(doc.createTextNode("" + o.sign) ); 
			clef.appendChild(sign); 
		}
	
		static void line(Document doc, Element clef, DrumNoteObject o) {
			Element line= doc.createElement("line");        
			line.appendChild(doc.createTextNode("" + o.line) ); 
			clef.appendChild(line);
		}
		
		
	//For Guitars
	public static void clef(Document doc, Element attributes, GuitarNoteObject g) {
		Element clef = doc.createElement("clef");    
		attributes.appendChild(clef); 
				
		sign(doc, clef, g);
		line(doc, clef, g);
		}
			
			static void sign(Document doc, Element clef, GuitarNoteObject g) {
				Element sign = doc.createElement("sign");        
				sign.appendChild(doc.createTextNode("" + g.sign) ); 
				clef.appendChild(sign); 
			}
			
			static void line(Document doc, Element clef, GuitarNoteObject g) {
				Element line= doc.createElement("line");        
				line.appendChild(doc.createTextNode("" + g.line) ); 
				clef.appendChild(line);
          }
}
