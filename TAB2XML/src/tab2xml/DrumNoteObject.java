package tab2xml;

public class DrumNoteObject {
	
	
	/**
	 *  drumtab will be the 2d char array obtained from praser 
	 *  row and col are the coordinates of the current note in question 
	 *  voice is the voice of the 
	 * 
	 */
	
	
	char [][] drumTab;
	int voice;

	
	
	// the following values are only needed once for the MusicXML Code
	String clef = "percussion";
	int divisions = 4;
	int fifths = 0;
	int beats = 4;
	int beatsType = 4;
	
	
	
	/**
	 * These are all objects created so we can use the methods made in the other classes 
	 */
	DrumRowSorter note = new DrumRowSorter();
	DrumNoteRow rowValue = new DrumNoteRow();
	DrumNoteCol colValue = new DrumNoteCol();
	DrumDisplaySteps step = new DrumDisplaySteps();
	DrumDisplayOctave octave = new DrumDisplayOctave();
	DrumDuration noteduration = new DrumDuration();
	DrumID idFinder = new DrumID();
	DrumVoice voiceValue = new DrumVoice();
	DrumStem stemValue = new DrumStem();

	
	/**
	 * the following three arrays only need to be ran one time 
	 * rowSymbols will keep track of which Instrument is played for which row 
	 * noteRowValues and noteColValues are parallel arrays which store the coordinates of the notes being played
	 *  arrays are programmed in a way where, voice one notes go first, then followed by voice 2 notes
	 *  When noteRowValue[counter] and noteColValues[counter] = 100, this means switching from voice one to voice two, temporally voice will be equal to 0
	 *  this will signal the back up funtion of the MusicXML code 
	 */
	int [] rowSymbols = note.rowSymbolsSorter(drumTab);	 
	int[] noteRowValues = rowValue.RowReader(drumTab,rowSymbols);
	int[] noteColValues = colValue.ColReader(drumTab,rowSymbols);
	
	
	int counter = 0;
	int row = noteRowValues[counter];
	int col = noteColValues[counter];
	int nextCol = noteColValues[counter +1];
	int nextNextCol = noteColValues[counter +2];
	
	
	
	/**
	 * the following pieces of information are the ones which need to be put into an array for the MusicXML Code
	 */
	String displayStep = step.StepOrganizer(row, col);;
	int voiceNumber = voiceValue.FindVoiceValue(row, rowSymbols);
	int displayOctave = octave.DrumOctaves(drumTab,voiceNumber);
	int duration = noteduration.NoteDurationLength(col,nextCol,nextNextCol);
	String idNumber = idFinder.InstrumentID(row, rowSymbols);
	String stem = stemValue.FindStemValue(voiceNumber);
		
	
	
	
	
	
			
}
