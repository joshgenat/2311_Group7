package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Divisions {
	
//	public static  String divisions(Document doc, Element attributes, int i) {
	
	public static  String divisions(int i, int j, int k) {
//		Element divisions = doc.createElement("divisions");        
//		divisions.appendChild(doc.createTextNode("" + i) ); 
//		attributes.appendChild(divisions); 
//		
//		Element key = doc.createElement("key");    
//		attributes.appendChild(key); 
//			
//			Element fifths = doc.createElement("fifths");        
//			fifths.appendChild(doc.createTextNode("5") ); 
//			key.appendChild(fifths);
//			
		return ("<divisions>" + i + "</divisions>\r\n" + 
				"\t<key>\r\n" + 
				"\t\t<fifths>" + j + "</fifths>\r\n" + 
				"\t</key>");
	}
	
	
}
