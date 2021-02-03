package tab2xml;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class toXML {
	
	public static void main(String[] args) {
		char[][] test = {
				{'a', 'b'}, {'c', 'd'}
				};
		
		toXML(test);
		
	}
	
	private static void toXML(char[][] test) {

		try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		
		Element rootElement = doc.createElement("part-list");
		doc.appendChild(rootElement);
			
			Element scorePart = doc.createElement("score-part"); 
			rootElement.appendChild(scorePart); 
			scorePart.setAttribute("id", "P1");

				Element partName = doc.createElement("part-name");   
				partName.appendChild(doc.createTextNode("Guitar") ); 
				scorePart.appendChild(partName);               
    
				
		Element measureNumber = doc.createElement("measure"); 
		rootElement.appendChild(measureNumber);    
		measureNumber.setAttribute("number", "1");
			
			Element attributes = doc.createElement("attributes");        
			attributes.appendChild(doc.createTextNode("5") ); 
			measureNumber.appendChild(attributes);   
			
		
	
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

