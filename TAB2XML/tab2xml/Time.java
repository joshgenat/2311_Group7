package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Time {
	public static void time(Document doc, Element attributes, int i, int j) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
		
		if (i != 0)
		beats(doc, time, i);
			
		if (j != 0)
		beatType(doc, time, j);
	}
	
	static void beats(Document doc, Element time, int i) {
		Element beats = doc.createElement("beats");        
		beats.appendChild(doc.createTextNode("" + i) ); 
		time.appendChild(beats); 
	}
	
	static void beatType(Document doc, Element time, int j) {
		Element beatType= doc.createElement("beat-type");        
		beatType.appendChild(doc.createTextNode("" + j) ); 
		time.appendChild(beatType);
	}
}
