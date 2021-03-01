package tab2xml;

import java.util.ArrayList;

public class DrumNoteObject {
	
	
	/**
	 *  drumtab will be the 2d char array obtained from praser 
	 *  row and col are the coordinates of the current note in question 
	 *  voice is the voice of the 
	 * 
	 */
	
	
	Tab tab;
	ArrayList<DrumNotes> notes = new ArrayList<DrumNotes>();
	ArrayList<DrumPartsList> instruments = new ArrayList<>();
	ArrayList<Boolean> backUpFinder = new ArrayList<>();
	String sign;
	int line;
	int divisions;
	int fifths;
	int beats;
	int beatsType;
	
	
	
	/**
	 * These are all objects created so we can use the methods made in the other classes 
	 */
	DrumRowSorter note = new DrumRowSorter();
	DrumNoteRow rowValue = new DrumNoteRow();
	DrumNoteCol colValue = new DrumNoteCol();
	DrumDisplaySteps step = new DrumDisplaySteps();
	DrumDisplayOctave octave = new DrumDisplayOctave();
	DrumDuration noteduration = new DrumDuration();
	DrumID instrumentFinder = new DrumID();
	DrumVoice voiceValue = new DrumVoice();
	DrumStem stemValue = new DrumStem();
	DrumNoteType noteType = new DrumNoteType();
	DrumDividers barLineCols = new DrumDividers();
	BackUpFinder backUpLocator = new BackUpFinder();	
	
	public DrumNoteObject(Tab tab) {
		// the following values are only needed once for the MusicXML Code
		this.tab = tab;
		
		sign = "percussion";
		line = 2;
		divisions = 4;
		fifths = 0;
		beats = 4;
		beatsType = 4;
		
		//Adds PartList At Top
		for(int r = 0; r <= 9; r++) {
			instruments.add(instrumentFinder.InstrumentAll(r));
		}
		
		for(int i = 0; i < tab.nodes.size(); i++) {
			
		/**
		 * the following three arrays only need to be ran one time 
		 * rowSymbols will keep track of which Instrument is played for which row 
		 * noteRowValues and noteColValues are parallel arrays which store the coordinates of the notes being played
		 *  arrays are programmed in a way where, voice one notes go first, then followed by voice 2 notes
		 *  When noteRowValue[counter] and noteColValues[counter] = 100, this means switching from voice one to voice two, temporally voice will be equal to 0
		 *  this will signal the back up funtion of the MusicXML codes
		 */
		
		int [] rowSymbols = note.rowSymbolsSorter(tab.nodes.get(i).nodes);	 
		
		
		ArrayList<Integer> rowCoordinate = rowValue.RowReader(tab.nodes.get(i).nodes,rowSymbols);
		ArrayList<Integer> colCoordinate = colValue.ColReader(tab.nodes.get(i).nodes,rowSymbols);
		ArrayList<Boolean>backUpFinders = backUpLocator.BackUpList(tab.nodes.get(i).nodes,rowSymbols);
		backUpFinder.addAll(backUpFinders);
		
		for(int j = 0; j < rowCoordinate.size(); j++) {
		int row = rowCoordinate.get(j);
		int col = colCoordinate.get(j);
		int nextCol = 0;
		int nextNextCol = 0;
		if(j+1 < rowCoordinate.size()) {nextCol = colCoordinate.get(j+1);} 
		if(j+2 < rowCoordinate.size()) {nextNextCol = colCoordinate.get(j+2);} 
		
		
		
		/**
		 * the following pieces of information are the ones which need to be put into an array for the MusicXML Code
		 */
		DrumNotes note1 = new DrumNotes();
		note1.displayStep = step.StepOrganizer(row, col);
		note1.voiceNumber = voiceValue.FindVoiceValue(row, rowSymbols);
		note1.instrumentID = instrumentFinder.Instrument(row, rowSymbols).partID;
		note1.displayOctave = octave.DrumOctaves(tab.nodes.get(i).nodes,note1.voiceNumber);
		note1.duration = noteduration.NoteDurationLength(col, nextCol, nextNextCol, barLineCols.DrumBarLines(tab.nodes.get(i).nodes));
		note1.stem = stemValue.FindStemValue(note1.voiceNumber);
		note1.type = noteType.DrumNoteLength(note1.duration);
		
		
		notes.add(note1);
		
		}
		}
		
	}
	
	
	
			
}
