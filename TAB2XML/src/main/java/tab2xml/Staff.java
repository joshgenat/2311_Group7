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
					
			for (int i = 0 ; i < g.tStep.size(); i++) {
			Element staffTuning= doc.createElement("staff-tuning");        
			staffTuning.setAttribute("line", "" + i);
			staffDetails.appendChild(staffTuning);	
			
				tuningStep(doc, staffTuning, g, i);
		
				tuningOctave(doc, staffTuning, g, i);
			}
	}
	
	
	static void tuningStep(Document doc, Element staffTuning, GuitarNoteObject g, int j) {
		Element tuningStep = doc.createElement("tuning-step");        
		tuningStep.appendChild(doc.createTextNode("" + g.tStep.get(j)) ); 
		staffTuning.appendChild(tuningStep); 
	}
	
	static void tuningOctave(Document doc, Element staffTuning, GuitarNoteObject g, int j) {
		Element tuningOctave = doc.createElement("tuning-octave");        
		tuningOctave.appendChild(doc.createTextNode("" + g.tOctave.get(j))); 
		staffTuning.appendChild(tuningOctave); 
	}
}
