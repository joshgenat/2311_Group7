package tab2xml;

public class DrumNotes {
	String displayStep;
	int voiceNumber;
	int displayOctave;
	int duration;
	String stem;
	String type;
	
	public DrumNotes(){
		
	}
	
	public String toString() {
		return this.displayStep + " " + this.voiceNumber + " " + this.displayOctave + " " + this.duration +  " " + this.stem + " ";
	}
}
