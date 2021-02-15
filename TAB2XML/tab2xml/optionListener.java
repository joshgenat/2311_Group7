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
			ArrayList<Object> lines = new ArrayList<Object>();
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			Tab b = new Tab(lines);
			
			System.out.println(b.Type);
			for(int i = 0; i < b.nodes.size();i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						System.out.print(b.nodes.get(i).nodes[j][k]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
       if(e.getActionCommand() == "Select File") {
			Parser parse = new Parser();
			Tab b = new Tab(parse.getLines());
			System.out.println(b.Type);
			for(int i = 0; i < b.nodes.size();i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						System.out.print(b.nodes.get(i).nodes[j][k]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
    }

}