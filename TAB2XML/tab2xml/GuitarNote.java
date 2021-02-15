package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GuitarNote {
	
	static void note(Document doc, Element measureNumber, int i) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
			pitch(doc, note, i);	
				
			duration(doc, note, i); 
			
			voice(doc, note, i); 
			
			type(doc, note, "eighth");
			
			notations(doc, note, i);
	}
	
	static void pitch(Document doc, Element note, int i) {
		Element pitch = doc.createElement("pitch");    
		note.appendChild(pitch);
		
		step(doc, pitch, i);
		
		octave(doc, pitch, i);
	}
	
		static void step(Document doc, Element pitch, int i) {
			Element step = doc.createElement("step");        
			step.appendChild(doc.createTextNode("" + i) ); 
			pitch.appendChild(step);
		}
	
		static void octave(Document doc, Element pitch, int i) {
			Element octave = doc.createElement("octave");        
			octave.appendChild(doc.createTextNode("" + i) ); 
			pitch.appendChild(octave);
		}
	
	static void duration(Document doc, Element note, int i) {
		Element duration = doc.createElement("duration");   
		duration.appendChild(doc.createTextNode("" + i) ); 
		note.appendChild(duration); 
	}
	
	static void voice(Document doc, Element note, int i) {
		Element voice = doc.createElement("voice");   
		voice.appendChild(doc.createTextNode("1") ); 
		note.appendChild(voice);
	}
	
	static void type(Document doc, Element note, String j) {
		Element type = doc.createElement("type");   
		type.appendChild(doc.createTextNode("" + j) ); 
		note.appendChild(type);
	}
	
	static void notations(Document doc, Element note, int i) {
		Element notations = doc.createElement("notations");  
		note.appendChild(notations);
		
		technical(doc, notations, i);
	}
	
		static void technical(Document doc, Element notations, int i) {
			Element technical = doc.createElement("technical");   
			notations.appendChild(technical);
			
			string(doc, technical, i);
			fret(doc, technical, i);
		}
	
			static void string(Document doc, Element technical, int i) {
				Element string = doc.createElement("string");        
				string.appendChild(doc.createTextNode("" + i) ); 
				technical.appendChild(string);
			}
	
			static void fret(Document doc, Element technical, int i) {
				Element fret = doc.createElement("fret");        
				fret.appendChild(doc.createTextNode("" + i) ); 
				technical.appendChild(fret);
			}
}
