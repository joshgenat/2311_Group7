package tab2xml;

public class DrumNoteObject {
	
	
	char [][] drumTab;
	int row;
	int col;
	int voice;
	int nextCol;
	int nextNextCol;
	String type;
	String clef = "percussion";
	int divisions = 4;
	int fifths = 0;
	int beats = 4;
	int beatsType = 4;
	
	
	
	DrumRowSorter note = new DrumRowSorter();
	DrumDisplaySteps step = new DrumDisplaySteps();
	DrumDisplayOctave octave = new DrumDisplayOctave();
	DrumDuration noteduration = new DrumDuration();
	DrumID idFinder = new DrumID();
	DrumVoice voiceValue = new DrumVoice();
	DrumStem stemValue = new DrumStem();
	
	int [] rowSymbols = note.rowSymbolsSorter(drumTab);
	 
	//note reader need to find a way 
	
	String displayStep = step.StepOrganizer(row, col);;
	int displayOctave = octave.DrumOctaves(drumTab,voice);
	int duration = noteduration.NoteDurationLength(col,nextCol,nextNextCol);
	String idNumber = idFinder.InstrumentID(row, rowSymbols);
	int voiceNumber = voiceValue.FindVoiceValue(row, rowSymbols);	
	String stem = stemValue.FindStemValue(voice);
	
	
	
	
	
	
	
	
			
}
