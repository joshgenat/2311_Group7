package tab2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class DrumXML {

	public static void main(String[] args) {
		new DrumXML(DrumNoteObject o);
	}
	
	DrumXML(DrumNoteObject o) {
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
	    
				if (o.instruments.get(i).partID != null && o.instruments.get(i).partName != null) {
					for(int i = 0; i < o.instruments.size(); i++) {
						ScoreInstrument.scoreInstrument(doc, rootElement, o, i);      
					}
				}
				
				Element partId = doc.createElement("part"); 
				partId.setAttribute("id", "P1");
				rootElement.appendChild(partId); 
				
					Element measureNumber = doc.createElement("measure"); 
					measureNumber.setAttribute("number", "1");
					partId.appendChild(measureNumber); 
					
						Element attributes = doc.createElement("attributes");   
						measureNumber.appendChild(attributes);
						
						if (o.divisions != null) 
						Divisions.divisions(doc, attributes, o);
						
						if (o.fifths != null)
						Key.key(doc, attributes, o);
						
						if (o.time != null)
						Time.time(doc, attributes, o);
						
						if (o.clef != null)
						Clef.clef(doc, attributes, o);
						
						for(int j = 0; j < o.notes.size() ; j++) {
							DrumNote.note(doc, attributes, o, j);
						}
						
			// write content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
						
			// Print to console
//			StreamResult result = new StreamResult(System.out);
			
			StringWriter outWriter = new StringWriter();
			StreamResult result = new StreamResult( outWriter );
						
			transformer.transform(source, result);		
			StringBuffer sb = outWriter.getBuffer(); 
			String finalstring = sb.toString();
			
			System.out.println(finalstring);
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
