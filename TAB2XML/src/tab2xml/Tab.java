package tab2xml;

import java.util.ArrayList;


public class Tab {

	ArrayList<TabNodes> nodes; // ArrayList of the lines of the tab
	String Type; // Type of Instrument Tab it is 
	ArrayList<Object> pass; // used to make individual nodes
	
	public Tab(ArrayList<Object> lines) {
		boolean read = false;
		boolean type = true;
		pass = new ArrayList<Object>();
		nodes = new ArrayList<TabNodes>();
		
		for(int i = 0; i < lines.size(); i++) {
			
			//Checks if Lines are actually tab nodes or just lyrics 
			if(read && lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) {
				pass.add(lines.get(i));
			}
			else if(read || pass.size() > 6) {
				if(type) {
					Type = this.getType(pass);
					type = false;
					}
				if(pass.size() > 6) {
					nodes.add(new TabNodes(pass));
					pass = new ArrayList<Object>();
				}
				else {
				nodes.add(new TabNodes(pass));
				pass = new ArrayList<Object>();
				read = false;
				}

			}
			else if(lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) { 
				pass.add(lines.get(i));
				read = true; 	
			}
		}
		nodes.add(new TabNodes(pass));
		if(type) {
			Type = this.getType(pass);
			type = false;
			}
	}
	private String getType(ArrayList<Object> lines) {
		String type = "Guitar";
		boolean x = false;
		boolean o = false;
		for(int i = 0; i < lines.size(); i++) {
			if(lines.toString().contains("x")) {x = true;}
			if(lines.toString().contains("o")) {o = true;}
		}
		if(x && o) {type = "Drum";}
		return type;
	}
}
