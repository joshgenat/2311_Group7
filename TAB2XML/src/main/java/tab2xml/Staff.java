package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Staff {

	static void staff(Document doc, Element attributes, int i) {
		Element staffDetails = doc.createElement("staff-details");    
		attributes.appendChild(staffDetails); 
				
			Element staffLines = doc.createElement("staff-lines");        
			staffLines.appendChild(doc.createTextNode("6") ); 
			staffDetails.appendChild(staffLines); 
					
			Element staffTuning= doc.createElement("staff-tuning");        
			staffTuning.setAttribute("line", "1");
			staffDetails.appendChild(staffTuning);	
			
				Element tuningStep = doc.createElement("tuning-step");        
				tuningStep.appendChild(doc.createTextNode("E") ); 
				staffTuning.appendChild(tuningStep); 
		
				Element tuningOctave = doc.createElement("tuning-octave");        
				tuningOctave.appendChild(doc.createTextNode("2") ); 
				staffTuning.appendChild(tuningOctave); 
	}
	
	static String staff(int[] arr, int i) {
		
		
		return "<staff-details>" +
                 "<staff-lines>6</staff-lines>" + 
                   "<staff-tuning line=1>" +
                       "<tuning-step>E</tuning-step>" + 
                       "<tuning-octave>2</tuning-octave>" +
                 "</staff-tuning>" +
              "</staff-details>";
		
	}
}
