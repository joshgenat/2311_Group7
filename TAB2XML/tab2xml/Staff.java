package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Staff {

	static void staff(Document doc, Element attributes, int lines) {
		Element staffDetails = doc.createElement("staff-details");    
		attributes.appendChild(staffDetails); 
				
			Element staffLines = doc.createElement("staff-lines");        
			staffLines.appendChild(doc.createTextNode("" + lines) ); 
			staffDetails.appendChild(staffLines); 
					
			for (int i = 1 ; i < lines; i++) {
			Element staffTuning= doc.createElement("staff-tuning");        
			staffTuning.setAttribute("line", "" + i);
			staffDetails.appendChild(staffTuning);	
			
				Element tuningStep = doc.createElement("tuning-step");        
				tuningStep.appendChild(doc.createTextNode("E") ); 
				staffTuning.appendChild(tuningStep); 
		
				Element tuningOctave = doc.createElement("tuning-octave");        
				tuningOctave.appendChild(doc.createTextNode("" + i) ); 
				staffTuning.appendChild(tuningOctave); 
			}
	}
}
