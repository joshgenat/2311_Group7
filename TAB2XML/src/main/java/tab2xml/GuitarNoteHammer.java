package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GuitarNoteHammer {
	
	static void note2(Document doc, Element measureNumber, GuitarNoteObject g, int j) {
		Element note = doc.createElement("note");     
		measureNumber.appendChild(note); 
		
			if (g.notes.get(j).hammerTo.isChord == true) 
			chord(doc, note);
			
			pitch(doc, note, g, j);	
				
			duration(doc, note, g, j); 
			
			voice(doc, note, g, j); 
			
			type(doc, note, g, j);
			
			notations(doc, note, g, j);
	}
	
	

	static void chord(Document doc, Element note) {
		Element chord = doc.createElement("chord");
		note.appendChild(chord); 
	}
	
	static void pitch(Document doc, Element note, GuitarNoteObject g, int j) {
		Element pitch = doc.createElement("pitch");    
		note.appendChild(pitch);
		
		step(doc, pitch, g, j);
		
		octave(doc, pitch, g, j);
	}
	
		static void step(Document doc, Element pitch, GuitarNoteObject g, int j) {
			Element step = doc.createElement("step");        
			step.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.step) ); 
			pitch.appendChild(step);
		}
	
		static void octave(Document doc, Element pitch, GuitarNoteObject g, int j) {
			Element octave = doc.createElement("octave");        
			octave.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.octave) ); 
			pitch.appendChild(octave);
		}
	
	static void duration(Document doc, Element note, GuitarNoteObject g, int j) {
		Element duration = doc.createElement("duration");   
		duration.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.duration) ); 
		note.appendChild(duration); 
	}
	
	static void voice(Document doc, Element note, GuitarNoteObject g, int j) {
		Element voice = doc.createElement("voice");   
		voice.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.voice) ); 
		note.appendChild(voice);
	}
	
	static void type(Document doc, Element note, GuitarNoteObject g, int j) {
		Element type = doc.createElement("type");   
		type.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.type) ); 
		note.appendChild(type);
	}
	
	static void notations(Document doc, Element note, GuitarNoteObject g, int j) {
		Element notations = doc.createElement("notations");  
		note.appendChild(notations);
		
		
		if (g.notes.get(j).hammerTo.isHammer == true) 
		slurNumber(doc, notations, g, j);
		
		technical(doc, notations, g, j);
		
	}
	
		private static void slurNumber(Document doc, Element notations, GuitarNoteObject g, int j) {
			Element slurNumber = doc.createElement("slur");  
			slurNumber.setAttribute("number", "1");
			slurNumber.setAttribute("type", "stop");
			notations.appendChild(slurNumber);
		}
	
		static void technical(Document doc, Element notations, GuitarNoteObject g, int j) {
			Element technical = doc.createElement("technical");   
			notations.appendChild(technical);
			
			string(doc, technical, g, j);
			fret(doc, technical, g, j);
			
			if (g.notes.get(j).hammerTo.isHammer == true) 
			hammer(doc, technical, g, j);
		}
	
			static void string(Document doc, Element technical, GuitarNoteObject g, int j) {
				Element string = doc.createElement("string");        
				string.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.string) ); 
				technical.appendChild(string);
			}
	
			static void fret(Document doc, Element technical, GuitarNoteObject g, int j) {
				Element fret = doc.createElement("fret");        
				fret.appendChild(doc.createTextNode("" + g.notes.get(j).hammerTo.fret) ); 
				technical.appendChild(fret);
			}
			
			static void hammer(Document doc, Element technical, GuitarNoteObject g, int j) {
				Element hammer = doc.createElement("hammer-on"); 
				hammer.setAttribute("number", "1");
				hammer.setAttribute("type", "stop");
				technical.appendChild(hammer);
			}
}
