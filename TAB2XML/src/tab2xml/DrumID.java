package tab2xml;

public class DrumID extends DrumPartsList {

	String iDNumber;
	DrumPartsList Object = new DrumPartsList();
	
	String InstrumentID(int row, int [] rowSymbols)
	{
		if (rowSymbols[row] == 1)
		{
			iDNumber = Object.CrashCymbal();
		}
		
		else if (rowSymbols[row] == 2)
		{
			iDNumber = Object.ClosedHiHat();
		}
		
		else if (rowSymbols[row] == 3)
		{
			iDNumber = Object.RideCymbal();
		}
		
		else if (rowSymbols[row] == 4)
		{
			iDNumber = Object.Snare();
		}
		
		else if (rowSymbols[row] == 5)
		{
			iDNumber = Object.HighTom();
		}
		
		else if (rowSymbols[row] == 6)
		{
			iDNumber = Object.LowTom();
		}
		
		else if (rowSymbols[row] == 7)
		{
			iDNumber = Object.LowFloorTom();
		}
		
		else if (rowSymbols[row] == 8)
		{
			iDNumber = Object.BassDrum1();
		}
		
		else if (rowSymbols[row] == 9)
		{
			iDNumber = Object.PedalHiHat();
		}
		
		
		return iDNumber;
		
	}
}
