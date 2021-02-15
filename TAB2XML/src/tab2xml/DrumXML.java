package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class DrumXML {

	public static void main(String[] args) {
		new DrumXML();
	}
	
	DrumXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// The root elements
			Document doc = docBuilder.newDocument();
			
			Element rootElement = doc.createElement("score-partwise");
			rootElement.setAttribute("version", "3.1");
			doc.appendChild(rootElement);
				
			
			// The actual values
				Element partList = doc.createElement("part-list"); 
				rootElement.appendChild(partList); 
				
					Element scorePart = doc.createElement("score-part"); 
					scorePart.setAttribute("id", "P1");
					partList.appendChild(scorePart); 

						Element partName = doc.createElement("part-name");   
						partName.appendChild(doc.createTextNode("Drumset") ); 
						scorePart.appendChild(partName);               
	    
				
				ScoreInstrument.scoreInstrument(doc, rootElement, "P1-I36");      
						
				Element partId = doc.createElement("part"); 
				partId.setAttribute("id", "P1");
				rootElement.appendChild(partId); 
				
					Element measureNumber = doc.createElement("measure"); 
					measureNumber.setAttribute("number", "1");
					partId.appendChild(measureNumber); 
					
						Element attributes = doc.createElement("attributes");   
						measureNumber.appendChild(attributes);
						
						Divisions.divisions(doc, attributes, 4);
						Key.key(doc, attributes, 0);
						Time.time(doc, attributes, 4, 4);
						Clef.clef(doc, attributes, 1, "percussion");
						DrumNote.note(doc, attributes, 4);
						
						
			// write content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
						
			// Print to console
			StreamResult result = new StreamResult(System.out);
			// StreamResult result = new StreamResult(new File());
						
			transformer.transform(source, result);
						
	}
		catch (TransformerException e) {
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
