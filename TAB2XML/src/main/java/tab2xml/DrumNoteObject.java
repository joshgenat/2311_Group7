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
	int voice;
	ArrayList<DrumNotes> notes = new ArrayList<DrumNotes>();
	ArrayList<DrumPartsList> instruments = new ArrayList<>();
	String clef;
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
	DrumDividers dividers = new DrumDividers();
		
	
	public DrumNoteObject(Tab tab) {
		// the following values are only needed once for the MusicXML Code
		this.tab = tab;
		String clef = "percussion";
		int divisions = 4;
		int fifths = 0;
		int beats = 4;
		int beatsType = 4;
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
		 *  this will signal the back up funtion of the MusicXML code
		 */
		
		int [] rowSymbols = note.rowSymbolsSorter(tab.nodes.get(i).nodes);	 
		int[] noteRowValues = rowValue.RowReader(tab.nodes.get(i).nodes,rowSymbols);
		int[] noteColValues = colValue.ColReader(tab.nodes.get(i).nodes,rowSymbols);
	
		
		for(int j = 0; j < noteRowValues.length; j++) {
		int row = noteRowValues[j];
		int col = noteColValues[j];
		int nextCol = 0;
		int nextNextCol = 0;
		if(j+1 < noteRowValues.length) {nextCol = noteColValues[j+1];} 
		if(j+2 < noteRowValues.length) {nextNextCol = noteColValues[j+2];} 
		
		
		
		/**
		 * the following pieces of information are the ones which need to be put into an array for the MusicXML Code
		 */
		DrumNotes note1 = new DrumNotes();
		note1.displayStep = step.StepOrganizer(row, col);;
		note1.voiceNumber = voiceValue.FindVoiceValue(row, rowSymbols);
		note1.displayOctave = octave.DrumOctaves(tab.nodes.get(i).nodes,note1.voiceNumber);
		note1.duration = 0;
		note1.duration = noteduration.NoteDurationLength(col, nextCol, nextNextCol, dividers.TabDividers(tab.nodes.get(i).nodes));
		note1.stem = stemValue.FindStemValue(note1.voiceNumber);
		note1.type = noteType.DrumNoteLength(note1.duration);
		
		
		notes.add(note1);
		
		}
		}
		
	}
	
	
	
			
}
