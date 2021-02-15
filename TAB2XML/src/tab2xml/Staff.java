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
					
			for (int i = 1 ; i <= lines; i++) {
			Element staffTuning= doc.createElement("staff-tuning");        
			staffTuning.setAttribute("line", "" + i);
			staffDetails.appendChild(staffTuning);	
			
				tuningStep(doc, staffTuning, "A");
		
				tuningOctave(doc, staffTuning, i);
			}
	}
	
	
	static void tuningStep(Document doc, Element staffTuning, String string) {
		Element tuningStep = doc.createElement("tuning-step");        
		tuningStep.appendChild(doc.createTextNode("" + string) ); 
		staffTuning.appendChild(tuningStep); 
	}
	
	static void tuningOctave(Document doc, Element staffTuning, int j) {
		Element tuningOctave = doc.createElement("tuning-octave");        
		tuningOctave.appendChild(doc.createTextNode("" + j) ); 
		staffTuning.appendChild(tuningOctave); 
	}
}
