package tab2xml;

//import static org.junit.jupiter.api.Assertions.*;

public class ConverterTester {

	public static void main(String[] args) {
		GuitarConverter guitar = new GuitarConverter();
		
		char[][] test1 = {
				{'e', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'B', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '-', '4', '-', '|'},
				{'G', '|', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '3', '-', '|'},
				{'D', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'A', '|', '-', '-', '-', '-', '-', '1', '0', '-', '-', '2', '0', '-', '-', '-', '-', '-', '-', '-', '-', '2', '1', '|'},
				{'E', '|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'}
		};
		char[][] test2 = {
				{'|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '-', '4', '-', '|'},
				{'|', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '3', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '1', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '2', '1', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '1', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '2', '|'}
				
		};
		char[][] test3 = {
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '0', '-', '-', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '0', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '-', '-', '1', '-', '-', '-', '-', '-', '-', '-', '1', '-', '|', '-', '1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '-', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '0', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'}
				
		};
		
		GuitarChord[] notes = guitar.converter(test3);
		//notes = removeNull(notes);
		
		System.out.println("\n test \n");
		
		for(int i = 0; i < test3.length; i++) {
			for(int j = 0; j < test3[0].length; j++) {
					System.out.print(test3[i][j]);
				}
			System.out.println();
		}
		
		System.out.print(notes[2].notes[5]);
		//System.out.print(notes[4].get(4));
		System.out.println("\n result \n");
		
		for(int i = 0; i < notes.length; i++) {
			for(int j = 0; j < notes.length; j++) {
				if(notes[j] == null)
					break;
				System.out.print(notes[j].notes[i] + "[" + notes[j].notes[i].isChord + "]\t");
			}
			System.out.println();
		}
		
		char fret = '9';
		GuitarNotes testNote = guitar.indexToNote(0, 5, (int)fret - 48);
		System.out.println(testNote);
			
		//System.out.println(test[0][1]);

	}

}
