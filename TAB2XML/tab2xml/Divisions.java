package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Divisions {
	
	static void divisions(Document doc, Element attributes, int i) {
		Element divisions = doc.createElement("divisions");        
		divisions.appendChild(doc.createTextNode("" + i) ); 
		attributes.appendChild(divisions); 
		
		Element key = doc.createElement("key");    
		attributes.appendChild(key); 
			
			Element fifths = doc.createElement("fifths");        
			fifths.appendChild(doc.createTextNode("5") ); 
			key.appendChild(fifths);
	}
	
	
	public static  String divisions(int i) {
		return ("<divisions>" + i + "</divisions>\r\n" + 
					"\t<key>\r\n" + 
						"\t\t<fifths>" + i + "</fifths>\r\n" + 
					"\t</key>");
	}
	
	
}
