package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



import tab2xml.Tab;


class ParserTester {

	//Test if Parser Removes The Excess Things (Lyrics etc)
	@Test
	public void ParserRemoveTrashTest() {
		
		File a = new File("src/test/resources/sample.txt");
		ArrayList<Object> lines = readFile(a);
		ArrayList<String> exp = new ArrayList<>();
		ArrayList<String> act = new ArrayList<>();
		//Expected Measure 1
		exp.add("C |x--------x--------|");
		exp.add("R |------x-----x--x--|");
		exp.add("SD|---------o--------|");
		exp.add("FT|------------------|");
		exp.add("B |o----------------o|");
		//Expected Measure 2
		exp.add("C |---------x--x-----|");
		exp.add("R |x--x-xx-----------|");
		exp.add("SD|---------o--o-----|");
		exp.add("FT|--------------o-o-|");
		exp.add("B |o----------o------|");
		
		
		Tab c = new Tab(lines);
		
		for(int i = 0; i < c.nodes.size(); i++) {
			for(int j = 0; j < c.nodes.get(i).nodes.length; j++) {
				String test = "";
				for(int k = 0; k < c.nodes.get(i).nodes[j].length; k++) {
					test += c.nodes.get(i).nodes[j][k];
				}
				act.add(test);
			}
		}
		
		assertEquals(exp, act);
	}
	
	@Test
	public void isDrumTypeCorrect() {
		File a = new File("src/test/resources/sample.txt");
		ArrayList<Object> lines = readFile(a);
		Tab b = new Tab(lines);
		assertEquals("Drum", b.Type);
	}
	
	@Test
	public void isGuitarTypeCorrect() {
		File a = new File("src/test/resources/sampleg.txt");
		ArrayList<Object> lines = readFile(a);
		Tab b = new Tab(lines);
		assertEquals("Guitar", b.Type);
		
	}
	
//	//Tests if |------Repeatx8------| type of repeat works
//	@Test
//	public void repeatType1() {
//		
//	}
//	
//	//Tests if x7 type of repeat works
//	@Test
//	public void repeatType2() {
//		
//	}
//	
//	//Tests if the star repeats work
//	@Test
//	public void repeatType3() {
//		
//	}

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
