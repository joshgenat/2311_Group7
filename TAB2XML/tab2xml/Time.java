package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Time {
	public static void time(Document doc, Element attributes, int i, int j) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
		
			Element beats = doc.createElement("beats");        
			beats.appendChild(doc.createTextNode("" + i) ); 
			time.appendChild(beats); 
			
			Element beatType= doc.createElement("beat-type");        
			beatType.appendChild(doc.createTextNode("" + j) ); 
			time.appendChild(beatType);
	}
}
