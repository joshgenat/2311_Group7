package tab2xml;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class GuitarXML {
	
	public static void main(String[] args) {
		char[][] test = {
				{'a', 'b'}, {'c', 'd'}
				};
		GuitarXML();
	}
	
	private static void GuitarXML() {

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
					partName.appendChild(doc.createTextNode("Guitar") ); 
					scorePart.appendChild(partName);               
    
			
			Element partId = doc.createElement("part"); 
			partId.setAttribute("id", "P1");
			rootElement.appendChild(partId); 
			
				Element measureNumber = doc.createElement("measure"); 
				measureNumber.setAttribute("number", "1");
				partId.appendChild(measureNumber);    
			
				
					Element attributes = doc.createElement("attributes");   
					measureNumber.appendChild(attributes);   
					
					Divisions.divisions(doc, attributes, 1);
					Time.time(doc, attributes);
					Clef.clef(doc, attributes);
					Staff.staff(doc, attributes, 4);

			
	
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

