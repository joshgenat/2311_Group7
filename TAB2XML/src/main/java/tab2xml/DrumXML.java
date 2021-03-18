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

	String text;
	
	DrumXML(DrumNoteObject o) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// The root elements
			Document doc = docBuilder.newDocument();
			DOMImplementation domImpl = doc.getImplementation();
			DocumentType doctype = domImpl.createDocumentType("score-partwise", "-//Recordare//DTD MusicXML 3.1 Partwise//EN", "http://www.musicxml.org/dtds/partwise.dtd");
			doc.appendChild(doctype);
			
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
	    
				
					for(int i = 0; i < o.instruments.size(); i++) {
						if (o.instruments.get(i).partID != null && o.instruments.get(i).partName != null) {
						ScoreInstrument.scoreInstrument(doc, scorePart, o, i);      
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
						
						
							Divisions.divisions(doc, attributes, o);
							Key.key(doc, attributes, o);				
							Time.time(doc, attributes, o);
							Clef.clef(doc, attributes, o);
						
							Element m = measureNumber;
							int count = 2;
							
						for(int j = 0; j < o.notes.size() ; j++) {
							if(o.backUpFinder.get(j) == true) {
								Backup.backup(doc, m, o, j);
							}
							DrumNote.note(doc, m, o, j);
//							if (o.notes.get(j).nextMeasure != true) {
//								DrumNote.note(doc, m, o, j);
//							}
//							else { 
//								Element measureNumber2 = doc.createElement("measure"); 
//								measureNumber2.setAttribute("number", "" + count);
//								partId.appendChild(measureNumber2);
//								DrumNote.note(doc, m, o, j);
//								m = measureNumber2;
//								count++;	
//								}
							}
						
						
						
						
			// write content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			
			StringWriter outWriter = new StringWriter();
			StreamResult result = new StreamResult( outWriter );
						
			transformer.transform(source, result);		
			StringBuffer sb = outWriter.getBuffer(); 
			String finalstring = sb.toString();
			
			text = finalstring;
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
