package tab2xml;

import java.util.ArrayList;

public class TabNodes {

	public char [][] nodes;
	String timeSignature = "4/4";
	int repeat = 1;
	int divisions;
	int maxsize;
	
	/**
	 * Constructor for the individual nodes (lines of Tabs)
	 * @param lines the arraylist of strings that needs to be converted 
	 */
	public TabNodes(ArrayList<Object> lines) {
		//Get The size of 2D string array and initialize
		for(int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i).toString());
		}
		System.out.println();
		maxsize = lines.get(1).toString().length();
		
		nodes = new char[lines.size()][maxsize];
		String a = "" + timeSignature.charAt(0);
		divisions = (maxsize - 2)/(Integer.parseInt(a));
		
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				nodes[i][j] = lines.get(i).toString().charAt(j);
			}
		}
		
	}

	public void setDiv() {
		String a = "" + timeSignature.charAt(0);
		divisions = (maxsize - 2)/(Integer.parseInt(a));
	}

}

