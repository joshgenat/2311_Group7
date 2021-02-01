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
			Element student = doc.createElement("technical");    // create a new student
			rootElement.appendChild(student);                // append it to measure

//			Attr attr = doc.createAttribute("id");			// create attribute
//			attr.setValue("1");
//			student.setAttributeNode(attr);
    
			Element name = doc.createElement("string");        // tag name
			name.appendChild(doc.createTextNode("3")); // value inside tag
			student.appendChild(name);                       // append name to student

			Element name2 = doc.createElement("fret");        // tag name
			name2.appendChild(doc.createTextNode("4") ); // value inside tag
			student.appendChild(name2);                       // append name to student
		}
	
		// write content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(System.out);
		
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

