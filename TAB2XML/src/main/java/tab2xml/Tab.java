package tab2xml;

import java.util.ArrayList;


public class Tab {

	public ArrayList<TabNodes> nodes; // ArrayList of the lines of the tab
	public String Type; // Type of Instrument Tab it is 
	public ArrayList<Object> pass; // used to make individual nodes
	
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
			else if(read) {
				if(type) {
					Type = this.getType(pass);
					type = false;
					}
				int repeat = getR(pass);
				for(int r = 0; r < repeat; r++)
				nodes.add(new TabNodes(pass));
				pass = new ArrayList<Object>();
				read = false;

			}
			else if(lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) { 
				pass.add(lines.get(i));
				read = true; 	
			}
		}
		if(pass.size() > 0) {
		int repeat = getR(pass);
		for(int r = 0; r < repeat; r++)
		nodes.add(new TabNodes(pass));
		if(type) {
			Type = this.getType(pass);
			type = false;
			}
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
	
	private int getR(ArrayList<Object> n) {
		int r = 1;
		String hold="";
		for(int i = 0; i < n.size(); i++) {
			hold = "";
			if(n.get(i).toString().lastIndexOf("|") != n.get(i).toString().length()-1) {
				hold = n.get(i).toString().substring(n.get(i).toString().length()-1-n.get(i).toString().lastIndexOf("|") ,n.get(i).toString().length());
				hold = hold.replaceAll("[^0-9]", "");
				if(hold == "") {
					r = 1;
					n.set(i, n.get(i).toString().substring(0,n.get(i).toString().lastIndexOf("|")+1));
				}
				else {
					r = Integer.parseInt(hold);
					n.set(i, n.get(i).toString().substring(0,n.get(i).toString().lastIndexOf("|")+1));
				}
			}
		}
		return r;
	}
}
