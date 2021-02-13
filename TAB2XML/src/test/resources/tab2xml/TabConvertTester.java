package tab2xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.junit.*;

class TabConvertTester {

	@Test
	void TestTabNodeConversion() {
		
		ArrayList<Object> lines = new ArrayList<Object>();
		lines.add("e|10-10-----0--------|");
		lines.add("B|-------0-----0-----|");
		lines.add("G|----0-----------0--|");
		lines.add("D|-------------------|");
		lines.add("A|-------------------|");
		lines.add("E|-0-----------------|");
			
		TabNodes tab = new TabNodes(lines);
		char [][] actual = tab.nodes;
		
		char [][] exp = {
				{'e','|','!','-','-','!','-','-','-','-','-','-','0','-','-','-','-','-','-','-','-','|'}, 
				{'B','|','-','-','-','-','-','-','-','0','-','-','-','-','-','0','-','-','-','-','-','|'}, 
		        {'G','|','-','-','-','-','0','-','-','-','-','-','-','-','-','-','-','-','0','-','-','|'}, 
	            {'D','|','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','|'}, 
	            {'A','|','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','|'}, 
	            {'E','|','-','0','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','|'}
	            };
		
		assertArrayEquals(exp, actual);
		
		
	}
	
	@Test
	public void GuitarDetectionTest() {
		ArrayList<Object> lines = new ArrayList<Object>();
		lines.add("e|10-10-----0--------|");
		lines.add("B|-------0-----0-----|");
		lines.add("G|----0-----------0--|");
		lines.add("D|-------------------|");
		lines.add("A|-------------------|");
		lines.add("E|-0-----------------|");
		lines.add("repeat");
		
		Tab tab = new Tab(lines);
		String actual = tab.Type;
		String exp = "Guitar";
		assertEquals(exp, actual);
	}
	
	@Test
	public void DrumDetectionTest() {
		ArrayList<Object> lines = new ArrayList<Object>();
		lines.add("C |x--------x--------|");
		lines.add("R |------x-----x--x--|");
		lines.add("SD|---------o--------|");
		lines.add("FT|------------------|");
		lines.add("B |o----------------o|");
		lines.add("  (1tl2tl3tl4tl5tl6tl|");
		
		
		Tab tab = new Tab(lines);
		String actual = tab.Type;
		String exp = "Drum";
		assertEquals(exp, actual);
	}
	
	@Test
	public void BlankFileTest() {
		ArrayList<Object> lines = new ArrayList<Object>();
		Tab tab = new Tab(lines);
		int actual = tab.nodes.size();
		int exp = 0;
		assertEquals(exp, actual);
	}

}
