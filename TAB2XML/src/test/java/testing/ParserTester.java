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
	
	//Tests if |------Repeatx8------| type of repeat works
	@Test
	public void repeatType1() {
		File a = new File("src/test/resources/repeatv1.txt");
		ArrayList<Object> lines = readFile(a);
		ArrayList<String> exp = new ArrayList<>();
		ArrayList<String> act = new ArrayList<>();
		exp.add("C |xx--------------|----------------|xx--------------|----------------|xx--------------|----------------|");
		exp.add("HH|----x-x-x-x-x-x-|x-x-x-x-xox-x-x-|----x-x-x-x-x-x-|x-x-x-x-xox-x-x-|----x-x-x-x-x-x-|----------x-x-x-|");
		exp.add("T |----------------|----------------|----------------|----------------|----------------|--o-------------|");
		exp.add("SD|----------------|----------------|----------------|----------------|----------------|o----o--f-------|");
		exp.add("B |oo--------------|----------------|oo--------------|----------------|oo--------------|-------o-o-oo-o-|");
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
	
	//Tests if x7 type of repeat works
	@Test
	public void repeatType2() {
		File a = new File("src/test/resources/repeatv2.txt");
		ArrayList<Object> lines = readFile(a);
		ArrayList<String> exp = new ArrayList<>();
		ArrayList<String> act1 = new ArrayList<>();
		ArrayList<String> act2 = new ArrayList<>();
		exp.add("C |xx--------------|----------------|xx--------------|----------------|");
		exp.add("HH|----x-x-x-x-x-x-|x-x-x-x-xox-x-x-|----x-x-x-x-x-x-|----------x-x-x-|");
		exp.add("T |----------------|----------------|----------------|--o-------------|");
		exp.add("SD|----------------|----------------|----------------|o----o--f-------|");
		exp.add("B |oo--------------|----------------|oo--------------|-------o-o-oo-o-|");
		Tab c = new Tab(lines);
		String text = "";
		for(int i = 0; i < c.nodes.get(0).nodes.length; i++) {
			text = "";
			for(int j = 0; j < c.nodes.get(0).nodes[i].length; j++) {
				text += c.nodes.get(0).nodes[i][j];
			}
			act1.add(text);
		}
		text = "";
		for(int i = 0; i < c.nodes.get(0).nodes.length; i++) {
			text = "";
			for(int j = 0; j < c.nodes.get(0).nodes[i].length; j++) {
				text += c.nodes.get(0).nodes[i][j];
			}
			act2.add(text);
		}
		assertEquals(exp, act1);
		assertEquals(exp, act2);
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
