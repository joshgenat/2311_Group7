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
				linesToMeasure(pass);
				nodes.addAll(linesToMeasure(pass));
				pass = new ArrayList<Object>();
				read = false;

			}
			else if(lines.get(i).toString().contains("-") && lines.get(i).toString().lastIndexOf('|') - lines.get(i).toString().indexOf('|') > 0) { 
				pass.add(lines.get(i));
				read = true; 	
			}
		}
		if(pass.size() > 0) {	
		nodes.addAll(linesToMeasure(pass));
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
				hold = n.get(i).toString().substring(n.get(i).toString().lastIndexOf("|")+1,n.get(i).toString().length());
				hold = hold.replaceAll("[^0-9]", "");
				if(hold == "" || hold.isBlank()) {
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
	
	private ArrayList<TabNodes> linesToMeasure(ArrayList<Object> lines){
		int repeat = getR(lines);
		ArrayList<TabNodes> measures = new ArrayList<>();
		ArrayList<Object> upperRepeats = new ArrayList<>();
		
		
		while(lines.get(0).toString().toLowerCase().contains("repeat")) {
			upperRepeats.add(lines.get(0));
			lines.remove(0);
		}
		int measureN = 0;
		for(int i = 0; i < lines.get(0).toString().length(); i++) {
			if(lines.get(0).toString().charAt(i) == '|') {measureN++;}
		}
		measureN--;
		//Get Tunings
		for(int i = 0; i < measureN; i++) {
			ArrayList<Object> pass = new ArrayList<>();
			for(int j = 0; j < lines.size(); j++) {
				String add = "|";
				String [] split = lines.get(j).toString().split("\\|");
				if(lines.get(j).toString().charAt(0) != '|') {
					add = split[0] + "|";
				}
				add = add + split[i+1] + "|";
				pass.add(add);
			}
			measures.add(new TabNodes(pass));
		}
		
		return measures;
	}
}
