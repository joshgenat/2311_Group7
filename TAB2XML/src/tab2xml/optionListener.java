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
			DrumNoteObject c = new DrumNoteObject(b);
			
			for(int i = 0; i < c.notes.size(); i++) {
				System.out.println(c.notes.get(i).toString());
			}
		}
       if(e.getActionCommand() == "Select File") {
			Parser parse = new Parser();
			String text = "";
			Tab b = new Tab(parse.getLines());
			
			text += b.Type + "\n";
			for(int i = 0; i < b.nodes.size();i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						text += b.nodes.get(i).nodes[j][k];
					}
					text += "\n";
				}
				text += "\n";
			}
			a.setText(text);
		}
    }

}