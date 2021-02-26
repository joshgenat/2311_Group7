package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GuitarNote {
	
	static void note(Document doc, Element measureNumber, GuitarNoteObject g, int j) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
			pitch(doc, note, g, j);	
				
			duration(doc, note, g, j); 
			
			voice(doc, note, g, j); 
			
			type(doc, note, g, j);
			
			notations(doc, note, g, j);
	}
	
	static void pitch(Document doc, Element note, GuitarNoteObject g, int j) {
		Element pitch = doc.createElement("pitch");    
		note.appendChild(pitch);
		
		step(doc, pitch, g, j);
		
		octave(doc, pitch, g, j);
	}
	
		static void step(Document doc, Element pitch, GuitarNoteObject g, int j) {
			Element step = doc.createElement("step");        
			step.appendChild(doc.createTextNode("" + g.notes.get(j).step) ); 
			pitch.appendChild(step);
		}
	
		static void octave(Document doc, Element pitch, GuitarNoteObject g, int j) {
			Element octave = doc.createElement("octave");        
			octave.appendChild(doc.createTextNode("" + g.notes.get(j).octave) ); 
			pitch.appendChild(octave);
		}
	
	static void duration(Document doc, Element note, GuitarNoteObject g, int j) {
		Element duration = doc.createElement("duration");   
		duration.appendChild(doc.createTextNode("" + g.notes.get(j).duration) ); 
		note.appendChild(duration); 
	}
	
	static void voice(Document doc, Element note, GuitarNoteObject g, int j) {
		Element voice = doc.createElement("voice");   
		voice.appendChild(doc.createTextNode("" + g.notes.get(j).voice) ); 
		note.appendChild(voice);
	}
	
	static void type(Document doc, Element note, GuitarNoteObject g, int j) {
		Element type = doc.createElement("type");   
		type.appendChild(doc.createTextNode("" + g.notes.get(j).type) ); 
		note.appendChild(type);
	}
	
	static void notations(Document doc, Element note, GuitarNoteObject g, int j) {
		Element notations = doc.createElement("notations");  
		note.appendChild(notations);
		
		technical(doc, notations, g, j);
	}
	
		static void technical(Document doc, Element notations, GuitarNoteObject g, int j) {
			Element technical = doc.createElement("technical");   
			notations.appendChild(technical);
			
			string(doc, technical, g, j);
			fret(doc, technical, g, j);
		}
	
			static void string(Document doc, Element technical, GuitarNoteObject g, int j) {
				Element string = doc.createElement("string");        
				string.appendChild(doc.createTextNode("" + g.notes.get(j).string) ); 
				technical.appendChild(string);
			}
	
			static void fret(Document doc, Element technical, GuitarNoteObject g, int j) {
				Element fret = doc.createElement("fret");        
				fret.appendChild(doc.createTextNode("" + g.notes.get(j).fret) ); 
				technical.appendChild(fret);
			}
}
