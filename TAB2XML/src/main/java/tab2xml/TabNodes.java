package tab2xml;

import java.util.ArrayList;

public class TabNodes {

	public char [][] nodes;
	String timeSignature = "4/4";
	int repeat = 1;
	
	/**
	 * Constructor for the individual nodes (lines of Tabs)
	 * @param lines the arraylist of strings that needs to be converted 
	 */
	public TabNodes(ArrayList<Object> lines) {
		//Get The size of 2D string array and initialize
		int maxsize = lines.get(0).toString().length();
		
		nodes = new char[lines.size()][maxsize];
		
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				nodes[i][j] = lines.get(i).toString().charAt(j);
			}
		}
		
	}

}

