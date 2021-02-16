package tab2xml;

public class DrumNotes {
	String displayStep;
	int voiceNumber;
	int displayOctave;
	int duration;
	String idNumber;
	String stem;
	
	public DrumNotes(){
		
	}
	
	public String toString() {
		return this.displayStep + " " + this.voiceNumber + " " + this.displayOctave + " " + this.duration + " " + this.idNumber + " " + this.stem + " ";
	}
}
