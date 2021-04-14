package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Backup {

	static void backup(Document doc, Element measureNumber, DrumNoteObject o, int j) {
		Element backup = doc.createElement("backup");  
		measureNumber.appendChild(backup); 
		
			Element duration = doc.createElement("duration");   
			duration.appendChild(doc.createTextNode("" + 16)); 
			backup.appendChild(duration);	
	}
	
	// Backup Tester
		public static String backupTest(int[] s) {
			StringBuilder sb = new StringBuilder();
			
			sb.append("<backup>");  
			sb.append("\n" + s[0]); 
			sb.append("\n</backup>");
			
			return sb.toString();
		}
}
