package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Barline {

	// For Drums
	static void barline(Document doc, Element measureNumber, Integer integer) {
		Element barline = doc.createElement("barline");
		barline.setAttribute("location", "left");
		measureNumber.appendChild(barline); 
		
			barStyle(doc, barline, integer);
			repeat(doc, barline, integer);
	}
	
		static void barStyle(Document doc, Element barline, Integer integer) {
			Element barstyle = doc.createElement("bar-style");        
			barstyle.appendChild(doc.createTextNode("heavy-light") ); 
			barline.appendChild(barstyle); 
		}
		
		static void repeat(Document doc, Element barline, Integer integer) {
			Element repeat = doc.createElement("repeat");
			repeat.setAttribute("direction", "forward");
			barline.appendChild(repeat); 
		}
	
	// for Guitar
	static void barline(Document doc, Element measureNumber, GuitarNoteObject g) {
		Element barline = doc.createElement("barline");
		barline.setAttribute("location", "left");
		measureNumber.appendChild(barline); 
		
			barStyle(doc, barline, g);
			repeat(doc, barline, g);
	}
	
		static void barStyle(Document doc, Element barline, GuitarNoteObject g) {
			Element barstyle = doc.createElement("bar-style");        
			barstyle.appendChild(doc.createTextNode("heavy-light") ); 
			barline.appendChild(barstyle); 
		}
		
		static void repeat(Document doc, Element barline, GuitarNoteObject g) {
			Element repeat = doc.createElement("repeat");
			repeat.setAttribute("direction", "forward");
			barline.appendChild(repeat); 
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
