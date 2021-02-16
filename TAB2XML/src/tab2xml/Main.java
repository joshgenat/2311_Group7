package tab2xml;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		

		DrumNoteRow a = new DrumNoteRow();
		DrumNoteCol b = new DrumNoteCol();
		DrumRowSorter note = new DrumRowSorter();
		char [][] d = {
				{'C', 'C', '|', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '-', '-', '-', '-', '-', '-', '-', 'x', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'H', 'H', '|', '-', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
		        {'S', 'D', '|', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '|', 'o', 'o', 'o', 'o', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
		        {'H', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '-', '-', '-', 'o', 'o', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'}, 
		        {'M', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|', '-', '-', '-', '-', '-', '-', 'o', 'o', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
		        {'B', 'D', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|'}
		        };
		int [] rowSymbols = note.rowSymbolsSorter(d);	 
		int[] noteRowValues = a.RowReader(d,rowSymbols);
		int[] noteColValues = b.ColReader(d,rowSymbols);
		
//		GUI test = new GUI();
		
	}
}
		
