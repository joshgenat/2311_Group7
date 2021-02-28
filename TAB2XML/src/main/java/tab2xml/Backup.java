package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Backup {

	static void backup(Document doc, Element measureNumber, DrumNoteObject o, int j) {
		Element backup = doc.createElement("backup");  
		measureNumber.appendChild(backup); 
		
			Element duration = doc.createElement("duration");   
			duration.appendChild(doc.createTextNode("" + o.notes.get(j).duration)); 
			backup.appendChild(duration);	
	}
}
