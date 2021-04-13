package tab2xml;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class GuitarXML {
	
	String text;
	public GuitarXML(GuitarNoteObject g) {

		try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// The root elements
		Document doc = docBuilder.newDocument();
		
		Element rootElement = doc.createElement("score-partwise");
		rootElement.setAttribute("version", "3.1");
		doc.appendChild(rootElement);
			
		
		// The actual values
		
			Element work = doc.createElement("work"); 
			rootElement.appendChild(work); 
		
				Element workTitle = doc.createElement("work-title"); 
				workTitle.appendChild(doc.createTextNode(g.title));
				work.appendChild(workTitle); 
			
			Element partList = doc.createElement("part-list"); 
			rootElement.appendChild(partList); 
			
				Element scorePart = doc.createElement("score-part"); 
				scorePart.setAttribute("id", "P1");
				partList.appendChild(scorePart); 

					Element partName = doc.createElement("part-name");   
//					partName.appendChild(doc.createTextNode("" + g.instrument)); 
					scorePart.appendChild(partName);               
    
			
			Element partId = doc.createElement("part"); 
			partId.setAttribute("id", "P1");
			rootElement.appendChild(partId); 
				
				// Run first measure
				
				Element measureNumber = doc.createElement("measure"); 
				measureNumber.setAttribute("number", "1");
				partId.appendChild(measureNumber);   
				
					Element attributes = doc.createElement("attributes");   
					measureNumber.appendChild(attributes);   
					
						Divisions.divisions(doc, attributes, g.div.get(0));
						Key.key(doc, attributes, g);
						Time.time(doc, attributes, g.b.get(0), g.bt.get(0));
						Clef.clef(doc, attributes, g);
						Staff.staff(doc, attributes, g);
						
						int count = 2;
						Element m = measureNumber;
						Element a = attributes;
						if (g.repeats.get(count-2) != 1) {
							Barline.barline(doc, measureNumber);
							Direction.direction(doc, measureNumber, g.repeats.get(count-2));
						}
						
					for(int j = 0; j < g.notes.size() ; j++) {
						
						if (g.notes.get(j).nextMeasure != true) {
							GuitarNote.note(doc, m, g, j);
						
						if (g.notes.get(j).hammerTo != null)
							GuitarNoteHammer.note2(doc, m, g, j);
						
						else if (g.notes.get(j).pullTo != null)
							GuitarNotePull.note3(doc, m, g, j);
					}
					
					else { 
						Element measureNumber2 = doc.createElement("measure"); 
						measureNumber2.setAttribute("number", "" + count);
						if(count-1 < g.repeats.size())
						partId.appendChild(measureNumber2);
						
						
						GuitarNote.note(doc, m, g, j);
						
						Barline2.barline(doc, m, g.repeats.get(count-2));
						
						if (g.notes.get(j).hammerTo != null)
							GuitarNoteHammer.note2(doc, m, g, j);
						
						else if (g.notes.get(j).pullTo != null)
							GuitarNotePull.note3(doc, m, g, j);
						
						m = measureNumber2;
						if (g.repeats.get(count-2) != 1) {
							Barline.barline(doc, m);
							Direction.direction(doc, m, g.repeats.get(count-2));
						}
						count++;	
						if(count-2 < g.b.size())
						if (g.b.get(count - 2) != g.b.get(count - 3) || 
								g.bt.get(count - 2) != g.bt.get(count - 3)) {
								Element attributes2 = doc.createElement("attributes");   
								m.appendChild(attributes2);
								a = attributes2;
								Divisions.divisions(doc, a, g.div.get(count-2));
								Key.key(doc, a, g);
								Time.time(doc, a, g.b.get(count-2), g.bt.get(count-2));
								Clef.clef(doc, a, g);
								Staff.staff(doc, a, g);
							}
						}
					}
					
					if(g.repeats.get(g.repeats.size()-1) != 1) {
						Barline2.barline(doc, m, g.repeats.get(count-3));
					}
					else {
						Barline2.barline(doc, m, 0);
					}
				
				 
	
		// write content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		
		// Print to console
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

