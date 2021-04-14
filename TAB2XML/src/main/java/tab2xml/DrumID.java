package tab2xml;

public class DrumID extends DrumPartsList {

	// need to change how id is calculated 
	
	DrumPartsList Instrument(int row, char head, int [] rowSymbols)
	{
		DrumPartsList instrument = new DrumPartsList();
		
		if (rowSymbols[row] == 1)
		{
			instrument.CrashCymbal();
		}
		
		else if (rowSymbols[row] == 2 && head =='x')
		{
			instrument.ClosedHiHat();
		}
		
		else if (rowSymbols[row] == 2 && head =='o')
		{
			instrument.OpenHiHat();
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

	public DrumPartsList InstrumentAll(int r) {
		DrumPartsList instrument = new DrumPartsList();
		if (r == 1)
		{
			instrument.CrashCymbal();
		}
		else if (r == 2)
		{
			
			instrument.ClosedHiHat();
		}
		
		else if (r == 3)
		{
			instrument.OpenHiHat();
		}
		
		else if (r == 4)
		{
			instrument.RideCymbal();
		}
		
		else if (r == 5)
		{
			instrument.Snare();
		}
		
		else if (r == 6)
		{
			instrument.HighTom();
		}
		
		else if (r == 7)
		{
			instrument.LowTom();
		}
		
		else if (r == 8)
		{
			instrument.LowFloorTom();
		}
		
		else if (r == 9)
		{
			instrument.BassDrum1();
		}
		
		
		return instrument;
	}
}
