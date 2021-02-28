package tab2xml;

public class ConverterTester {

	public static void main(String[] args) {
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
			{-1, -1, -1, -1, -1, 4, -1, -1, 4, -1},
			{-1, -1, -1, -1, 4, -1, 3, -1, 3, -1},
			{-1, -1, -1, 3, -1, -1, -1, 3, 3, -1},
			{-1, -1, 3, -1, -1, -1, -1, -1, 3, -1},
			{-1, 2, -1, -1, -1, -1, -1, -1, 2, -1},
			{2, -1, -1, -1, -1, -1, -1, -1, 2, -1}
		};
		
		boolean[][] expectedIsChord = {
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
			{false, false, false, false, false, false, false, false, true, false, },
		};
		
		GuitarChord[] notes = guitar.converter(test);
		
		//System.out.println("\n test \n");
		
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[0].length; j++) {
					System.out.print(test[i][j]);
				}
			System.out.println();
		}

		System.out.println("\n result \n");

		
		
		for(int i = 0; i < notes[0].notes.length; i++) { 
			System.out.print("{");
			for(int j = 0; j < notes.length; j++) { 
				if(notes[j] == null) break;
				//System.out.print("\'" + notes[j].notes[i].step + "\', ");
				System.out.print(notes[j].notes[i].nextMeasure + ", ");
				//System.out.print(notes[j].notes[i] + "[" + notes[j].notes[i].nextMeasure + "]\t");
			}	
			System.out.print("},\n"); 
		} 
		 

	}

}
