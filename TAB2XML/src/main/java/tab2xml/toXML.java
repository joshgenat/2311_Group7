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
		Element rootElement = doc.createElement("measure");
		doc.appendChild(rootElement);

		// Iterating rows
		for( int i=0; i <test.length ; i++){
			// Main Root element 
			Element student = doc.createElement("technical");   
			rootElement.appendChild(student);               
    
			Element name = doc.createElement("string");        // tag name
			name.appendChild(doc.createTextNode("" + i) ); // value inside tag
			student.appendChild(name);                       // append name to student

			Element name2 = doc.createElement("fret");        // tag name
			name2.appendChild(doc.createTextNode("" + i) ); // value inside tag
			student.appendChild(name2);                       // append name to student
			
			/** Should Print out:
			
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<measure>
				<technical>
					<string>0</string>
					<fret>0</fret>
				</technical>
			
				<technical>
					<string>1</string>
					<fret>1</fret>
				</technical>
			</measure> 
			*/
		}
	
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

