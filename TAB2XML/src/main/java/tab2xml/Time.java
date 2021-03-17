package tab2xml;

import java.util.Random;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Time {
	
	// For Drums
	public static void time(Document doc, Element attributes, DrumNoteObject o) {
		Element time = doc.createElement("time");    
		attributes.appendChild(time); 
		
		if (o != null)
		beats(doc, time, o);
			
		if (o != null)
		beatType(doc, time,o);
	}
	
		static void beats(Document doc, Element time, DrumNoteObject o) {
			Element beats = doc.createElement("beats");        
			beats.appendChild(doc.createTextNode("" + o.beats) ); 
			time.appendChild(beats); 
		}
	
		static void beatType(Document doc, Element time, DrumNoteObject o) {
			Element beatType= doc.createElement("beat-type");        
			beatType.appendChild(doc.createTextNode("" + o.beatsType) ); 
			time.appendChild(beatType);
		}
		
		
		
		// For Guitars
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
		
		// Drum Time Tester
				public static String timeTest(int[] o) {
					StringBuilder sb = new StringBuilder();
					sb.append("<time>");  
					
					if (o[0] != 0)
					beats(o, sb);
						
					if (o[1] != 0)
					beatType(o, sb);
					
					sb.append("\n</time>");
					System.out.println(sb.toString());
					return sb.toString();
				}
				
					static void beats(int[] o, StringBuilder sb) {
						sb.append("\n\t<beats>" + o[0] + "</beats>");
					}
				
					static void beatType(int[] o, StringBuilder sb) {
						sb.append("\n\t<beatType>" + o[1] + "</beatType>");
					}
					
					public static void main(String[] args) {
						Random rand = new Random();
						int r1 = rand.nextInt(10);
						int r2 = rand.nextInt(10);
						int[] s = {r1, r2};
						
						Time.timeTest(s);
					}
}
