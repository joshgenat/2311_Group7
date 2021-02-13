package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Note {
	
	static void note(Document doc, Element measureNumber) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
			Element pitch = doc.createElement("pitch");    
			note.appendChild(pitch); 
			
				Element step = doc.createElement("step");        
				step.appendChild(doc.createTextNode("5") ); 
				pitch.appendChild(step);
				
				Element octave = doc.createElement("octave");        
				octave.appendChild(doc.createTextNode("5") ); 
				pitch.appendChild(octave);
				
			Element duration = doc.createElement("duration");   
			duration.appendChild(doc.createTextNode("1") ); 
			note.appendChild(duration); 
			
			Element voice = doc.createElement("voice");   
			voice.appendChild(doc.createTextNode("1") ); 
			note.appendChild(voice); 
			
			Element type = doc.createElement("type");   
			type.appendChild(doc.createTextNode("eighth") ); 
			note.appendChild(type); 
			
			Element notations = doc.createElement("notations");  
			note.appendChild(notations); 
			
				Element technical = doc.createElement("technical");   
				notations.appendChild(technical);
				
					Element string = doc.createElement("string");        
					string.appendChild(doc.createTextNode("5") ); 
					technical.appendChild(string);
					
					Element fret = doc.createElement("fret");        
					fret.appendChild(doc.createTextNode("0") ); 
					technical.appendChild(fret);
	}
}
