package tab2xml;

public class DrumStem {
	
	String stem;
	public DrumStem() {
		
	}
	
	public String FindStemValue(int voice)
	{
		if (voice == 1)
		{
			stem = "up";
		}
		else if (voice == 2)
		{
			stem = "down";
		}
		return stem;
	}

}
