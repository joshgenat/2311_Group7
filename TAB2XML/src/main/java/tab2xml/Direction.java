package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Direction {

	// Drums
		static void direction(Document doc, Element measureNumber, DrumNoteObject o) {
			Element direction = doc.createElement("direction-type");
			measureNumber.appendChild(direction); 
			
				directionType(doc, direction, o); 
		}
		
			static void directionType(Document doc, Element barline, DrumNoteObject o) {
				Element directionType = doc.createElement("direction-type");        
				barline.appendChild(directionType); 
				
				words(doc, directionType, o);
			}
			
				static void words(Document doc, Element directionType, DrumNoteObject o) {
					Element words = doc.createElement("words");
//					words.setAttribute("direction", "forward");
					words.appendChild(doc.createTextNode("Repeat 4 Times") ); 
					directionType.appendChild(words); 
				}
	
	// Guitar
	static void direction(Document doc, Element measureNumber, GuitarNoteObject g) {
		Element direction = doc.createElement("direction-type");
		measureNumber.appendChild(direction); 
		
			directionType(doc, direction, g); 
	}
	
		static void directionType(Document doc, Element barline, GuitarNoteObject g) {
			Element directionType = doc.createElement("direction-type");        
			barline.appendChild(directionType); 
			
			words(doc, directionType, g);
		}
		
			static void words(Document doc, Element directionType, GuitarNoteObject g) {
				Element words = doc.createElement("words");
//				words.setAttribute("direction", "forward");
				words.appendChild(doc.createTextNode("Repeat 4 Times") ); 
				directionType.appendChild(words); 
			}
		
		
		// Barline Tester
		public static String barlineTest(int[] s) {
			StringBuilder sb = new StringBuilder();
			sb.append("<barline>");  
						
			if (s[0] != 0)
				barStyle(s, sb);
								
			if (s[1] != 0)
				repeat(s, sb);
						
			sb.append("\n</barline>");
			return sb.toString();
		}
		static void barStyle(int[] o, StringBuilder sb) {
			sb.append("\n\t<barStyle>" + o[0] + "</barStyle>");
		}

		static void repeat(int[] o, StringBuilder sb) {
			sb.append("\n\t<repeat>" + o[1] + "</repeat>");
		}
}
