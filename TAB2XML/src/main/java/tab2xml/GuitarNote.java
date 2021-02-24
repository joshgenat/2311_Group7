package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GuitarNote {
	
//	static void note(Document doc, Element measureNumber, GuitarNoteObject g) {
//		Element note = doc.createElement("note");     
//		measureNumber.appendChild(note); 
//		
//			pitch(doc, note, g);	
//				
//			duration(doc, note, g); 
//			
//			voice(doc, note, g); 
//			
//			type(doc, note, g);
//			
//			notations(doc, note, g);
//	}
//	
//	static void pitch(Document doc, Element note, GuitarNoteObject g) {
//		Element pitch = doc.createElement("pitch");    
//		note.appendChild(pitch);
//		
//		step(doc, pitch, g);
//		
//		octave(doc, pitch, g);
//	}
//	
//		static void step(Document doc, Element pitch, GuitarNoteObject g) {
//			Element step = doc.createElement("step");        
//			step.appendChild(doc.createTextNode("" + g.step) ); 
//			pitch.appendChild(step);
//		}
//	
//		static void octave(Document doc, Element pitch, GuitarNoteObject g) {
//			Element octave = doc.createElement("octave");        
//			octave.appendChild(doc.createTextNode("" + g.octave) ); 
//			pitch.appendChild(octave);
//		}
//	
//	static void duration(Document doc, Element note, GuitarNoteObject g) {
//		Element duration = doc.createElement("duration");   
//		duration.appendChild(doc.createTextNode("" + g.duration) ); 
//		note.appendChild(duration); 
//	}
//	
//	static void voice(Document doc, Element note, GuitarNoteObject g) {
//		Element voice = doc.createElement("voice");   
//		voice.appendChild(doc.createTextNode("" + g.voice) ); 
//		note.appendChild(voice);
//	}
//	
//	static void type(Document doc, Element note, GuitarNoteObject g) {
//		Element type = doc.createElement("type");   
//		type.appendChild(doc.createTextNode("" + g.type) ); 
//		note.appendChild(type);
//	}
//	
//	static void notations(Document doc, Element note, GuitarNoteObject g) {
//		Element notations = doc.createElement("notations");  
//		note.appendChild(notations);
//		
//		technical(doc, notations, g);
//	}
//	
//		static void technical(Document doc, Element notations, GuitarNoteObject g) {
//			Element technical = doc.createElement("technical");   
//			notations.appendChild(technical);
//			
//			string(doc, technical, g);
//			fret(doc, technical, g);
//		}
//	
//			static void string(Document doc, Element technical, GuitarNoteObject g) {
//				Element string = doc.createElement("string");        
//				string.appendChild(doc.createTextNode("" + g.string) ); 
//				technical.appendChild(string);
//			}
//	
//			static void fret(Document doc, Element technical, GuitarNoteObject g) {
//				Element fret = doc.createElement("fret");        
//				fret.appendChild(doc.createTextNode("" + g.fret) ); 
//				technical.appendChild(fret);
//			}
}
