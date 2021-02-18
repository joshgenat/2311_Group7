package tab2xml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import tab2xml.Parser;
import tab2xml.Tab;


public class optionListener implements ActionListener {
	GUI a;
	public optionListener(GUI input) {
		this.a = input;
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand() == "Convert") {
     	   String [] parse = a.getText().split("\n");
     	   String text = "";
 			ArrayList<Object> lines = new ArrayList<Object>();
 			for(int i = 0; i < parse.length; i++) {
 				lines.add(parse[i]);
 			}
 			
 			Tab b = new Tab(lines);
 			if(b.Type.equals("Drum")) {
 				DrumNoteObject c = new DrumNoteObject(b);
 	 			DrumXML d = new DrumXML(c);
 				a.setText(d.text);
 				}
 				else {
 					a.setText("Currently not Supported");
 				}
 			
 		}
       if(e.getActionCommand() == "Select File") {
			Parser parse = new Parser();
			Tab b = new Tab(parse.getLines());
			
			if(b.Type.equals("Drum")) {
			DrumNoteObject c = new DrumNoteObject(b);
 			DrumXML d = new DrumXML(c);
			a.setText(d.text);
			}
			else {
				a.setText("Currently not Supported");
			}
		}
    }

}