package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Direction {

		static void direction(Document doc, Element measureNumber, Integer integer) {
			Element direction = doc.createElement("direction-type");
			measureNumber.appendChild(direction); 
			
				directionType(doc, direction, integer); 
		}
		
			static void directionType(Document doc, Element barline, Integer integer) {
				Element directionType = doc.createElement("direction-type");        
				barline.appendChild(directionType); 
				
				words(doc, directionType, integer);
			}
			
				static void words(Document doc, Element directionType, Integer integer) {
					Element words = doc.createElement("words");
//					words.setAttribute("direction", "forward");
					words.appendChild(doc.createTextNode("Repeat " + integer + " Times") ); 
					directionType.appendChild(words); 
				}
		
		
}
