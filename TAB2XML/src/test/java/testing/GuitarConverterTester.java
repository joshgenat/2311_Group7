package testing;
import tab2xml.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import org.junit.jupiter.api.Test;

class GuitarConverterTester {
	
	Random random = new Random();
	
	GuitarConverter guitar = new GuitarConverter();
	
	char[][] test = {
			{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '0', '-', '-', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
			{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '0', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
			{'|', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '1', '-', '|', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
			{'|', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
			{'|', '-', '-', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
			{'|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'}
	};
	
	String[][] expectedNote = {
			{"-", "-", "-", "-", "-", "E", "-", "-", "E", "-"},
			{"-", "-", "-", "-", "C", "-", "B", "-", "B", "-"},
			{"-", "-", "-", "G#", "-", "-", "-", "G#", "G#", "-"},
			{"-", "-", "E", "-", "-", "-", "-", "-", "E", "-"},
			{"-", "B", "-", "-", "-", "-", "-", "-", "B", "-"},
			{"E", "-", "-", "-", "-", "-", "-", "-", "E", "-"}
		};
		
		String[][] expectedType = {
			{"sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "eighth", "sixteenth", "sixteenth", "whole", "sixteenth", },
			{"sixteenth", "sixteenth", "sixteenth", "sixteenth", "eighth", "sixteenth", "eighth", "sixteenth", "whole", "sixteenth", },
			{"sixteenth", "sixteenth", "sixteenth", "eighth", "sixteenth", "sixteenth", "sixteenth", "eighth", "whole", "sixteenth", },
			{"sixteenth", "sixteenth", "eighth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "whole", "sixteenth", },
			{"sixteenth", "eighth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "whole", "sixteenth", },
			{"eighth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "sixteenth", "whole", "sixteenth", },
		};
		
		int[][] expectedOctave = {
			{-1, -1, -1, -1, -1, 4, -1, -1, 4, -1},
			{-1, -1, -1, -1, 4, -1, 3, -1, 3, -1},
			{-1, -1, -1, 3, -1, -1, -1, 3, 3, -1},
			{-1, -1, 3, -1, -1, -1, -1, -1, 3, -1},
			{-1, 2, -1, -1, -1, -1, -1, -1, 2, -1},
			{2, -1, -1, -1, -1, -1, -1, -1, 2, -1},
		};
		
		int[][] expectedFret = {
			{-1, -1, -1, -1, -1, 0, -1, -1, 0, -1},
			{-1, -1, -1, -1, 1, -1, 0, -1, 0, -1},
			{-1, -1, -1, 1, -1, -1, -1, 1, 1, -1},
			{-1, -1, 2, -1, -1, -1, -1, -1, 2, -1},
			{-1, 2, -1, -1, -1, -1, -1, -1, 2, -1},
			{0, -1, -1, -1, -1, -1, -1, -1, 0, -1},
		};
		
		int[][] expectedString = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
		};
		
		int[][] expectedDuration = {
			{0, 0, 0, 0, 0, 1, 0, 0, 8, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 8, 0},
			{0, 0, 0, 1, 0, 0, 0, 1, 8, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 8, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 8, 0},
			{1, 0, 0, 0, 0, 0, 0, 0, 8, 0}
		};
		
		boolean[][] expectedIsChord = {
			{false, false, false, false, false, false, false, false, false, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
		};
		
		char[][] expectedStep = {
			{'-', '-', '-', '-', '-', 'E', '-', '-', 'E', '-'},
			{'-', '-', '-', '-', 'C', '-', 'B', '-', 'B', '-'},
			{'-', '-', '-', 'G', '-', '-', '-', 'G', 'G', '-'},
			{'-', '-', 'E', '-', '-', '-', '-', '-', 'E', '-'},
			{'-', 'B', '-', '-', '-', '-', '-', '-', 'B', '-'},
			{'E', '-', '-', '-', '-', '-', '-', '-', 'E', '-'}
		};
		
		int[][] expectedAlter = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		boolean[][] expectedMeasure = {
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, true, false, false}
		};
	
	GuitarChord[] result = guitar.converter(test);
	
	int[] i = {rInd(10), rInd(6)};
	
	@Test
	void noteTest() {
		assertEquals(result[i[0]].notes[i[1]].note, expectedNote[i[1]][i[0]]);
	}
	
	@Test
	void typeTest() {
		assertEquals(result[i[0]].notes[i[1]].type, expectedType[i[1]][i[0]]);
	}
	
	@Test
	void octaveTest() {
		assertEquals(result[i[0]].notes[i[1]].octave, expectedOctave[i[1]][i[0]]);
	}
	
	@Test
	void fretTest() {
		assertEquals(result[i[0]].notes[i[1]].fret, expectedFret[i[1]][i[0]]);
	}
	
	@Test
	void stringTest() {
		assertEquals(result[i[0]].notes[i[1]].string, expectedString[i[1]][i[0]]);
	}
	
	@Test
	void durationTest() {
		assertEquals(result[i[0]].notes[i[1]].duration, expectedDuration[i[1]][i[0]]);
	}
	
	@Test
	void chordTest() {
		assertEquals(result[i[0]].notes[i[1]].isChord, expectedIsChord[i[1]][i[0]]);
	}
	
	@Test
	void stepTest() {
		assertEquals(result[i[0]].notes[i[1]].step, expectedStep[i[1]][i[0]]);
	}
	
	@Test
	void alterTest() {
		assertEquals(result[i[0]].notes[i[1]].alter, expectedAlter[i[1]][i[0]]);
	}
	
	@Test
	void measureTest() {
		assertEquals(result[i[0]].notes[i[1]].nextMeasure, expectedMeasure[i[1]][i[0]]);
	}
	
	private int rInd(int max) {
		return (int)(random.nextDouble()*max);
	}

}
