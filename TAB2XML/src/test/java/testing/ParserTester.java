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
	
	@Test
	public void isBassTypeCorrect() {
		File a = new File("src/test/resources/sampleg.txt");
		ArrayList<Object> lines = readFile(a);
		lines.remove(lines.size()-1);
		Tab b = new Tab(lines);
		assertEquals("Bass", b.Type);
		
	}
	
	//Tests if |------Repeatx8------| type of repeat works
	@Test
	public void repeatType1() {
		ArrayList<Object> lines = new ArrayList<>();
		boolean a = true;
		lines.add("1st Verse ");
		lines.add("  |------------REPEAT-1x------------|");
		lines.add("C |xx--------------|----------------|xx--------------|----------------|");
		lines.add("HH|----x-x-x-x-x-x-|x-x-x-x-xox-x-x-|----x-x-x-x-x-x-|----------x-x-x-|");
		lines.add("T |----------------|----------------|----------------|--o-------------|");
		lines.add("SD|----------------|----------------|----------------|o----o--f-------|");
		lines.add("B |oo--------------|----------------|oo--------------|-------o-o-oo-o-|");
		
		Tab b = new Tab(lines);
		if(b.nodes.get(0).repeat != 2) { a = false; }
		if(b.nodes.get(1).repeat != 2) { a = false; }
		if(b.nodes.get(2).repeat != 1) { a = false; }
		if(b.nodes.get(3).repeat != 1) { a = false; }

		assertEquals(a, true);
	}
	
	//Tests if x7 type of repeat works
	@Test
	public void repeatType2() {
		ArrayList<Object> lines = new ArrayList<>();
		boolean a = true;
		lines.add("C |xx--------------|----------------|xx--------------|----------------|");
		lines.add("HH|----x-x-x-x-x-x-|x-x-x-x-xox-x-x-|----x-x-x-x-x-x-|----------x-x-x-|");
		lines.add("T |----------------|----------------|----------------|--o-------------| x2");
		lines.add("SD|----------------|----------------|----------------|o----o--f-------|");
		lines.add("B |oo--------------|----------------|oo--------------|-------o-o-oo-o-|");
		
		Tab b = new Tab(lines);
		if(b.nodes.get(0).repeat != 2) { a = false; }
		if(b.nodes.get(1).repeat != 2) { a = false; }
		if(b.nodes.get(2).repeat != 2) { a = false; }
		if(b.nodes.get(3).repeat != 2) { a = false; }
		assertEquals(a, true);
	}
	
	//Tests if the star repeats work
	@Test
	public void repeatType3() {
		ArrayList<Object> lines = new ArrayList<>();
		boolean a = true;
		lines.add("|-----------0-----||----------0--------4|");
		lines.add("|---------0---0---||----------0--------||");
		lines.add("|-------1-------1-||*---------1-------*||");
		lines.add("|-----2-----------||*---------2-------*||");
		lines.add("|---2-------------||------2---2--------||");
		lines.add("|-0---------------||--0-------0--------||");
			
		Tab b = new Tab(lines);
		if(b.nodes.get(0).repeat != 1) { a = false; }
		if(b.nodes.get(1).repeat != 4) { a = false; }
		assertEquals(a, true);
	}
	
	
	//Tests all 3 Repeats same time
	@Test
	public void repeatTypeAll() {
		ArrayList<Object> lines = new ArrayList<>();
		boolean a = true;
		lines.add("|-----Repeat-x9-----------------------|");
		lines.add("|-----Repeat-x3--|");
		lines.add("|-----------0-----||----------0--------4|");
		lines.add("|---------0---0---||----------0--------||");
		lines.add("|-------1-------1-||*---------1-------*|| x3");
		lines.add("|-----2-----------||*---------2-------*||");
		lines.add("|---2-------------||------2---2--------||");
		lines.add("|-0---------------||--0-------0--------||");
			
		Tab b = new Tab(lines);
		if(b.nodes.get(0).repeat != 120) { a = false; } // (9+1) * (3+1) * 3 * 1 = 120
		if(b.nodes.get(1).repeat != 120) { a = false; } // (9+1) * 3 * 4 = 120
		assertEquals(a, true);
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
