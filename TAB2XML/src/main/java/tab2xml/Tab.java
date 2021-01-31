package tab2xml;

import java.util.ArrayList;

public class Tab {

	ArrayList<TabNodes> nodes; // ArrayList of the lines of the tab
	String Type; // Type of Instrument Tab it is 
	ArrayList<Object> pass; // used to make individual nodes
	
	public Tab(ArrayList<Object> lines) {
		boolean read = false;
		boolean typed = false;
		pass = new ArrayList<Object>();
		nodes = new ArrayList<TabNodes>();
		for(int i = 0; i < lines.size(); i++) {
			
			//Checks if Lines are actually tab nodes or just lyrics 
			if(read && lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) {
				pass.add(lines.get(i));
			}
			else if(read) {
				if(typed == false) {
					Type = "Guitar";
					for(int j = 0; j < pass.size(); j++) {
						if (pass.get(j).toString().contains("x") || pass.get(j).toString().contains("o")) {
							Type = "Drum";
							break;
						}
					}
					typed = true;
				}
				nodes.add(new TabNodes(pass));
				pass = new ArrayList<Object>();
				read = false;
			}
			else if(lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) { 
				pass.add(lines.get(i));
				read = true; 	
			}
		}
		
		
		
	}

}