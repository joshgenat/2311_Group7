package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Staff {

	static void staff(Document doc, Element attributes, GuitarNoteObject g) {
		Element staffDetails = doc.createElement("staff-details");    
		attributes.appendChild(staffDetails); 
				
			Element staffLines = doc.createElement("staff-lines");        
			staffLines.appendChild(doc.createTextNode("" + g.staffLines) ); 
			staffDetails.appendChild(staffLines); 
					
			for (int i = 1 ; i <= g; i++) {
			Element staffTuning= doc.createElement("staff-tuning");        
			staffTuning.setAttribute("line", "" + i);
			staffDetails.appendChild(staffTuning);	
			
				tuningStep(doc, staffTuning, g);
		
				tuningOctave(doc, staffTuning, g);
			}
	}
	
	
	static void tuningStep(Document doc, Element staffTuning, GuitarNoteObject g) {
		Element tuningStep = doc.createElement("tuning-step");        
		tuningStep.appendChild(doc.createTextNode("" + g.tuningStep) ); 
		staffTuning.appendChild(tuningStep); 
	}
	
	static void tuningOctave(Document doc, Element staffTuning, GuitarNoteObject g) {
		Element tuningOctave = doc.createElement("tuning-octave");        
		tuningOctave.appendChild(doc.createTextNode("" + g.tuningOctave) ); 
		staffTuning.appendChild(tuningOctave); 
	}
}
