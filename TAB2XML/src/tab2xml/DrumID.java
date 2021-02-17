package tab2xml;

public class DrumID extends DrumPartsList {

	
	
	DrumPartsList Instrument(int row, int [] rowSymbols)
	{
		DrumPartsList instrument = new DrumPartsList();
		if (rowSymbols[row] == 1)
		{
			instrument.CrashCymbal();
		}
		
		else if (rowSymbols[row] == 2)
		{
			instrument.ClosedHiHat();
		}
		
		else if (rowSymbols[row] == 3)
		{
			instrument.RideCymbal();
		}
		
		else if (rowSymbols[row] == 4)
		{
			instrument.Snare();
		}
		
		else if (rowSymbols[row] == 5)
		{
			instrument.HighTom();
		}
		
		else if (rowSymbols[row] == 6)
		{
			instrument.LowTom();
		}
		
		else if (rowSymbols[row] == 7)
		{
			instrument.LowFloorTom();
		}
		
		else if (rowSymbols[row] == 8)
		{
			instrument.BassDrum1();
		}
		
		else if (rowSymbols[row] == 9)
		{
			instrument.PedalHiHat();
		}
		
		
		return instrument;
		
	}
}
