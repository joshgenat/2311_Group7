package tab2xml;

import java.util.ArrayList;

public class TabNodes {

	public char [][] nodes;
	String timeSignature = "4/4";
	int repeat = 1;
	int divisions;
	int maxsize;
	int s;
	
	/**
	 * Constructor for the individual nodes (lines of Tabs)
	 * @param lines the arraylist of strings that needs to be converted 
	 */
	public TabNodes(ArrayList<Object> lines) {
		//Get The size of 2D string array and initialize
		System.out.println();
		maxsize = lines.get(1).toString().length();
		s = lines.get(1).toString().substring(lines.get(1).toString().indexOf("|")).length()-2;
		
		nodes = new char[lines.size()][maxsize];
		String a = "" + timeSignature.charAt(0);
		divisions = (s)/(Integer.parseInt(a));
		if(Integer.parseInt(a) == 6)
		{
			divisions = (s)/3;
		}
		
		
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				nodes[i][j] = lines.get(i).toString().charAt(j);
			}
		}
		
	}

	public void setDiv() {
		String a = "" + timeSignature.charAt(0);
		divisions = (s)/(Integer.parseInt(a));
		if(Integer.parseInt(a) == 6)
		{
			divisions = (s)/3;
		}	
	}

}

