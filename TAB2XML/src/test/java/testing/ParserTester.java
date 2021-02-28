package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import tab2xml.Tab;


class ParserTester {

	@Test
	public void ParserRemoveTrashTest() {
		File a = new File("\sample.txt");
		ArrayList<Object> lines = readFile(a);
		ArrayList<String> exp = new ArrayList<>();
		ArrayList<String> act = new ArrayList<>();
		exp.add("C |x--------x--------|---------x--x-----|x--------x--------|---------x--x-----|");
		exp.add("R |------x-----x--x--|x--x-xx-----------|---x-xx-----x-xx--|x--x-xx-----------|");
		exp.add("SD|---------o--------|---------o--o-----|---------o--------|---------o--o-----|");
		exp.add("FT|------------------|--------------o-o-|------------------|--------------oo--|");
		exp.add("B |o----------------o|o----------o------|o-----------------|o----------oo-----|");
		Tab c = new Tab(lines);
		String text = "";
		for(int i = 0; i < c.nodes.get(0).nodes.length; i++) {
			text = "";
			for(int j = 0; j < c.nodes.get(0).nodes[i].length; j++) {
				text += c.nodes.get(0).nodes[i][j];
			}
			act.add(text);
		}
		assertEquals(exp, act);
	}

	private ArrayList<Object> readFile(File file){
		ArrayList<Object> lines = new ArrayList<>();
		Scanner sc = null; 
		try {
			sc = new Scanner(file);	
			while(sc.hasNextLine()){
				lines.add(sc.nextLine());
	        }      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		return lines;
	}
}
