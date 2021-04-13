package testing;
import tab2xml.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import org.junit.jupiter.api.Test;

import exceptions.InproperInputException;

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
	
	char[][] testSpecial = {
			{'|', '-', '1', 'h', '2', '-', '-', '|'},
			{'|', '-', '1', '1', 'h', '1', '2', '|'},
			{'|', '-', '1', 'p', '2', '-', '-', '|'},
			{'|', '-', '1', '1', 'p', '1', '2', '|'},
			{'|', 'g', '1', '-', '-', '-', '-', '|'},
			{'|', 'g', '1', '1', '-', '-', '-', '|'}
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
			{"16th", "16th", "16th", "16th", "16th", "eighth", "16th", "16th", "whole", "16th", },
			{"16th", "16th", "16th", "16th", "eighth", "16th", "eighth", "16th", "whole", "16th", },
			{"16th", "16th", "16th", "eighth", "16th", "16th", "16th", "eighth", "whole", "16th", },
			{"16th", "16th", "eighth", "16th", "16th", "16th", "16th", "16th", "whole", "16th", },
			{"16th", "eighth", "16th", "16th", "16th", "16th", "16th", "16th", "whole", "16th", },
			{"eighth", "16th", "16th", "16th", "16th", "16th", "16th", "16th", "whole", "16th", },
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
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, true, false}
		};
		
	

	
	
	int[] i = {rInd(10), rInd(6)};
	
	@Test
	void noteTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].note, expectedNote[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void typeTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].type, expectedType[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void octaveTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].octave, expectedOctave[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void fretTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].fret, expectedFret[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void stringTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].string, expectedString[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void durationTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].duration, expectedDuration[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void chordTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].isChord, expectedIsChord[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void stepTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].step, expectedStep[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void alterTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].alter, expectedAlter[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void measureTest() {
		try {
			GuitarChord[] result = guitar.converter(test, 1, 'a');
			assertEquals(result[i[0]].notes[i[1]].nextMeasure, expectedMeasure[i[1]][i[0]]);
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
		
	}
	
	@Test
	void hammerTest() {
		try {
			GuitarChord[] result = guitar.converter(testSpecial, 1, 'a');
			assertEquals(result[0].notes[0].isHammer, true);
			assertEquals(result[0].notes[0].note, "F");
			assertEquals(result[0].notes[0].hammerTo.note, "F#");
			
			assertEquals(result[0].notes[1].isHammer, true);
			assertEquals(result[0].notes[1].note, "A#");
			assertEquals(result[0].notes[1].hammerTo.note, "B");
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
	}
	
	@Test
	void pullTest() {
		try {
			GuitarChord[] result = guitar.converter(testSpecial, 1, 'a');
			assertEquals(result[0].notes[2].isPull, true);
			assertEquals(result[0].notes[2].note, "G#");
			assertEquals(result[0].notes[2].pullTo.note, "A");
			
			assertEquals(result[0].notes[3].isPull, true);
			assertEquals(result[0].notes[3].note, "C#");
			assertEquals(result[0].notes[3].pullTo.note, "D");
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
	}
	
	@Test
	void graceTest() {
		try {
			GuitarChord[] result = guitar.converter(testSpecial, 1, 'a');
			assertEquals(result[0].notes[4].isGrace, true);
			assertEquals(result[0].notes[4].note, "A#");
			
			assertEquals(result[0].notes[5].isGrace, true);
			assertEquals(result[0].notes[5].note, "D#");
		}
		catch(InproperInputException e) {
			assertEquals(false, true);
		}
	}
	
	private int rInd(int max) {
		return (int)(random.nextDouble()*max);
	}

}
