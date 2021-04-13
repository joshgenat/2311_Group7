package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import tab2xml.BackUpFinder;
import tab2xml.DrumBeamNumber;
import tab2xml.DrumNoteCol;
import tab2xml.DrumNoteRow;
import tab2xml.DrumNoteType;
import tab2xml.DrumStem;


public class DrumTester { 
	
	
	@Test
	
	public void RowArrayListTest()
	{
	 
		DrumNoteRow rows = new DrumNoteRow();	
		
	char[][] testTab= 
		{
				{'C', 'C', '|', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'H', 'H', '|', '-', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', '|'},
				{'S', 'D', '|', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '|'},
				{'H', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'M', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
				{'B', 'D', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|'} 
		};
	
	int [] rowSymbol = {1,2,4,5,6,8};
	
	ArrayList<Integer> exp = new ArrayList<>();
	ArrayList<Integer> act = new ArrayList<>();
	
	
	Integer[] expectedValues = {0, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5};
	exp = new ArrayList<>(Arrays.asList(expectedValues));
	 
	 act = rows.RowReader(testTab, rowSymbol);
	 assertEquals(exp, act);
	}
	
	
	
	@Test
	 public void ColArrayListTest()
	 
	{
		
		DrumNoteCol cols = new DrumNoteCol();	
		
		char[][] test= 
			{
					{'C', 'C', '|', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'H', 'H', '|', '-', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', '|'},
					{'S', 'D', '|', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '|'},
					{'H', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'M', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'B', 'D', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|'} 
			};
		
		int [] rowSymbol = {1,2,4,5,6,8};
		
		ArrayList<Integer> exp = new ArrayList<>();
		ArrayList<Integer> act = new ArrayList<>();
		
		
		Integer[] expectedValues = {3, 5, 7, 7, 9, 11, 13, 15, 15, 17, 3, 11};
		 exp = new ArrayList<>(Arrays.asList(expectedValues));
		 
		 act = cols.ColReader(test, rowSymbol);
		 assertEquals(exp, act);
		 
		}
	
	
	@Test
	public void StepDirection()
	{
		DrumStem direction = new DrumStem();
		
		int voice = 2;
		
		String exp;
		String act = direction.FindStemValue(voice);
		
		
		exp = "down";
		// change this to "DOWN to get the correct junit test lab 
		assertEquals(exp, act);
		
	}
	
	@Test
	public void StepDirectionTwo()
	{
		DrumStem direction = new DrumStem();
		
		int voice = 1;
		
		String exp;
		String act = direction.FindStemValue(voice);
		
		
		exp = "up";
		// change this to "DOWN to get the correct junit test lab 
		assertEquals(exp, act);
		
	}
	
	
	@Test
	public void BackUpTest()
	{
		
		BackUpFinder isBackup = new BackUpFinder ();	
		
		char[][] testTab = 
			{
					{'C', 'C', '|', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'H', 'H', '|', '-', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', '|'},
					{'S', 'D', '|', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '|'},
					{'H', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'M', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'B', 'D', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|'} 
			};
		
		int [] rowSymbol = {1,2,4,5,6,8};
		
		ArrayList<Boolean> exp = new ArrayList<>();
		ArrayList<Boolean> act = new ArrayList<>();
		
		
		Boolean[] expectedValues = {false, false, false, false, false, false, false, false, false, false, true, false};
		
		exp = new ArrayList<Boolean>(Arrays.asList(expectedValues));
		 
		 act = isBackup.BackUpList(testTab, rowSymbol);
		 assertEquals(exp, act);
		 
		}
	
	
	@Test
	public void BeamStatusOne()
	{
		
		DrumBeamNumber beamStatus = new DrumBeamNumber ();	
		
		char[][] testTab = 
			{
					{'C', 'C', '|', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'H', 'H', '|', '-', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', 'x', '-', '|'},
					{'S', 'D', '|', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '|'},
					{'H', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'M', 'T', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
					{'B', 'D', '|', 'o', '-', '-', '-', '-', '-', '-', '-', 'o', '-', '-', '-', '-', '-', '-', '-', '|'} 
			};
		
		int [] rowSymbol = {1,2,4,5,6,8};
		
		ArrayList<String> exp = new ArrayList<>();
		ArrayList<String> act = new ArrayList<>();
		ArrayList <Character> NoteHeadReader = new ArrayList<>();
		ArrayList<Integer> RowValue = new ArrayList<>();
		ArrayList<Integer> ColValue = new ArrayList<>();
		ArrayList<Boolean> BackUpFinder = new ArrayList<>();
		ArrayList<Integer> barLine = new ArrayList<>();
		
		
		Integer[] row = {0, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5};
		Integer[] col = {3, 5, 7, 7, 9, 11, 13, 15, 15, 17, 3, 11};
		Boolean[] backUp = {false, false, false, false, false, false, false, false, false, false, true, false};
		Character [] head = { 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o'};
		Integer[] divider = {2,19};
	
				
				
		BackUpFinder = new ArrayList<Boolean>(Arrays.asList(backUp));
		RowValue = new ArrayList<Integer>(Arrays.asList(row));
		ColValue = new ArrayList<Integer>(Arrays.asList(col));
		NoteHeadReader = new ArrayList<Character>(Arrays.asList(head));
		barLine = new ArrayList<Integer>(Arrays.asList(divider));
		 
		String[] expectedValues = {"begin", "continue", null, null, "end", "begin", "continue", null, null, "end", null, null};
		
		exp = new ArrayList<String>(Arrays.asList(expectedValues));
		
		 act = beamStatus.BeamOneStatus(RowValue,ColValue, NoteHeadReader, barLine, rowSymbol, testTab);
		 assertEquals(exp, act);
		 
		}
}
