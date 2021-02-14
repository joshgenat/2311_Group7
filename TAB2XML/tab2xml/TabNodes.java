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
		int maxsize = 0;
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).toString().length() > maxsize) {
				maxsize = lines.get(i).toString().length();
			}
			lines.set(i, lines.get(i).toString().replaceAll("10", "!-"));
			lines.set(i, lines.get(i).toString().replaceAll("11", "@-"));
			lines.set(i, lines.get(i).toString().replaceAll("12", "#-"));
		}
		
		nodes = new char[lines.size()][maxsize];
		
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				if(j >= lines.get(i).toString().length()) {
					nodes[i][j] = ' ';
				}
				else {
				nodes[i][j] = lines.get(i).toString().charAt(j);
				}
			}
		}
		
	}
	
	
	

}
