package tab2xml;

import java.util.ArrayList;

public class TabNodes {

	public char [][] nodes;
	
	/**
	 * Constructor for the individual nodes (lines of Tabs)
	 * @param lines the arraylist of strings that needs to be converted 
	 */
	public TabNodes(ArrayList<Object> lines) {
		//Get The size of 2D string array and initialize
		repeat(lines);
		int maxsize = lines.get(0).toString().length();
		nodes = new char[lines.size()][maxsize];
		
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				nodes[i][j] = lines.get(i).toString().charAt(j);
			}
		}
		
	}
	
	private void repeat(ArrayList<Object> lines) {
		int repeatNum = 0;
		String hold = "";
		String end;
		String r="";
		int startIndex, endIndex;
		int repeat;
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).toString().toLowerCase().contains("repeat")) {
				repeatNum++;
			}
		}
		
		for(int i = repeatNum-1; i >= 0; i--) {
			hold = lines.get(i).toString().replaceAll("[^0-9]", "");
			repeat = Integer.parseInt(hold);
			startIndex = lines.get(i).toString().indexOf("|");
			endIndex = lines.get(i).toString().lastIndexOf("|")+1;
			lines.remove(i);
			for(int j = 0; j < lines.size(); j++) {
				r="";
				hold = lines.get(j).toString().substring(startIndex+1,endIndex);
				end = lines.get(j).toString().substring(endIndex, lines.get(j).toString().length());
				for(int k = 0; k < repeat; k++) {
					r += hold;
				}
				lines.set(j, lines.get(j).toString().substring(0, endIndex) + r + end);
			}
			
		}
	}
	

}

