package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Time {
	public static void time(Document doc, Element attributes, int b, int bt) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
		beats(doc, time, b);	
		beatType(doc, time,bt);
	}
	
		static void beats(Document doc, Element time, int b) {
			Element beats = doc.createElement("beats");        
			beats.appendChild(doc.createTextNode("" + b) ); 
			time.appendChild(beats); 
		}
	
		static void beatType(Document doc, Element time, int bt) {
			Element beatType= doc.createElement("beat-type");        
			beatType.appendChild(doc.createTextNode("" + bt) ); 
			time.appendChild(beatType);
		}
		
	public static void time(Document doc, Element attributes, GuitarNoteObject g) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
			
		if (g != null)
		beats(doc, time, g);
				
		if (g != null)
		beatType(doc, time, g);
	}
		
		static void beats(Document doc, Element time, GuitarNoteObject g) {
			Element beats = doc.createElement("beats");        
			beats.appendChild(doc.createTextNode("" + g.beats) ); 
			time.appendChild(beats); 
		}
		
		static void beatType(Document doc, Element time, GuitarNoteObject g) {
			Element beatType= doc.createElement("beat-type");        
			beatType.appendChild(doc.createTextNode("" + g.beatsType) ); 
			time.appendChild(beatType);
		} 
		
			public static String timeTest(int[] s) {
				StringBuilder sb = new StringBuilder();
				sb.append("<time>");  
				
				if (s[0] != 0)
					beats(s, sb);
						
					if (s[1] != 0)
					beatType(s, sb);
				
				sb.append("\n</time>");
				return sb.toString();
			}
			static void beats(int[] o, StringBuilder sb) {
				sb.append("\n\t<beats>" + o[0] + "</beats>");
			}

			static void beatType(int[] o, StringBuilder sb) {
				sb.append("\n\t<beatType>" + o[1] + "</beatType>");
			}
		}

