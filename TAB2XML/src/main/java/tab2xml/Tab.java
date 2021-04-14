package tab2xml;

import java.util.ArrayList;

import exceptions.UnsupportedTimeException;


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
		else if(lines.size() < 6) { type = "Bass"; }
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
	
	private ArrayList<Integer> getR3(ArrayList<Object> lines){
		String[] a = lines.get(0).toString().split("\\|");
		ArrayList<Integer> r = new ArrayList<>();
		
		//Get Repeats
		for(int i = 1; i < a.length; i++) {
			if(a[i].isBlank()) {
				i++;
				String b = "" + a[i].charAt(a[i].length()-1);
				r.add(Integer.parseInt(b));
			}
			else {
				r.add(1);
			}
		}
		//Reconstruct lines
		//Reconstruct line 0 
		a = lines.get(0).toString().split("\\|");
		String newL = a[0] + "|";
		for(int j = 1; j < a.length; j++) {
			if(a[j].isBlank()) {
				j++;
				newL += a[j].substring(1, a[j].length()-2) + "|";
			}
			else {
				newL += a[j] + "|";
			}
		}
		lines.set(0, newL);
		//Set Rest
		for(int i = 1; i < lines.size(); i++) {
			a = lines.get(i).toString().split("\\|");
			newL = a[0] + "|";
			for(int j = 1; j < a.length; j++) {
				if(a[j].isBlank()) {
					j++;
					newL += a[j].substring(1, a[j].length()-1) + "|";
					j++;
				}
				else {
					newL += a[j] + "|";
				}
			}
			lines.set(i, newL);
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
		ArrayList<Integer> Repeat3 = getR3(lines);
		int measureN = 0;
		for(int i = 0; i < lines.get(0).toString().length(); i++) {
			if(lines.get(0).toString().charAt(i) == '|') {measureN++;}
		}
		measureN--;
		
		for(int i = 0; i < measureN; i++) {
		}
		//Get Tunings + measures
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
		
		//Get Overall Repeats
		for(int i = 0; i < measureN; i++) {
			measures.get(i).repeat = repeat * Repeat3.get(i);
		}
		//Get Upper repeats
		for(int i = 0; i < upperRepeats.size(); i++ ) {
			String hold = upperRepeats.get(i).toString().replaceAll("[^0-9]", "");
			int repeatN = Integer.parseInt(hold);
			int startIndex = upperRepeats.get(i).toString().indexOf("|");
			int endIndex = upperRepeats.get(i).toString().lastIndexOf("|")+1;
			int length = 0;
			for(int k = 0; k < measures.get(0).nodes[0].length; k++ ) {
				if(measures.get(0).nodes[0][k] == '|') {break;}
				length++;
			}
			for(int j = 0; j < measureN; j++) {
				boolean finder = false;
				String line = "";
				for(int k = 0; k < measures.get(j).nodes[0].length; k++ ) {
					if(measures.get(j).nodes[0][k] == '|') {finder = true;}
					if(finder) { line += measures.get(j).nodes[0][k];}
				}
				if(length > endIndex) { break; }
				if(length <= endIndex && length >= startIndex) {
					measures.get(j).repeat *= (repeatN+1);
				}
				length += line.length();
			}
		}
		return measures;
	}
	
	
	
	public void setTime(String time) throws Exception {
		String[] split = time.split("/");
		try {
			if(split.length==2) {
				Integer.parseInt(split[0]);
				Integer.parseInt(split[1]);
			}
			if((!time.isBlank()) && (Integer.parseInt(split[0]) != 3 && Integer.parseInt(split[0]) != 4 && Integer.parseInt(split[0]) != 6)) {
				throw new UnsupportedTimeException();
			}
			if((!time.isBlank()) && (Integer.parseInt(split[1]) != 4 && Integer.parseInt(split[1]) != 8)) {
				throw new UnsupportedTimeException();
			}
			for(int i = 0; i <nodes.size(); i++) {
				if(time.isBlank()) { nodes.get(i).timeSignature = "4/4"; }
				else {nodes.get(i).timeSignature = time;}
				nodes.get(i).setDiv();
			}
			
		}
		catch(UnsupportedTimeException e) {
			throw new UnsupportedTimeException();
		}
		catch(Exception e) {
			throw new Exception();
		}
	}
}
