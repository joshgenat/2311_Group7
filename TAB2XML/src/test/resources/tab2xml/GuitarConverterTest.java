package tab2xml;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.Test;

class GuitarConverterTest {

	@Test
	void test() {
		GuitarConverter test = new GuitarConverter();
		char[][] in1 = {
				{'1', '-', '-', '-', '5', '-'},
				{'-', '2', '-', '4', '-', '6'},
				{'-', '-', '3', '-', '-', '-'}
		};
		
		String[][] expect1 = {
				{"F4", "-", "-", "-", "D3", "-"},
				{"-", "C#4", "-", "F#3", "-", "Bb2"},
				{"-", "-", "Bb3", "-", "-", "-"}

		};
		
		String[][] out1 = test.Converter(in1);
		
		
		
		String in2 = "1-----";
		String expect2 = "F4";
		String out2 = test.StringToNote(in2);
		
		String in3 = "-----4";
		String expect3 = "Ab2";
		String out3 = test.StringToNote(in3);
		
		String in4 = "------";
		String expect4 = "-";
		String out4 = test.StringToNote(in4);
		
		int[] index = RandomIndex(expect1.length, expect1[0].length);
		assertEquals(expect1[index[0]][index[1]], out1[index[0]][index[1]]);
		
		assertEquals(expect2, out2);
		assertEquals(expect3, out3);
		assertEquals(expect4, out4);
		
	}
	
	public int[] RandomIndex(int maxi, int maxj) {
		Random random = new Random();
		int i = (int)(random.nextDouble()*maxi);
		int j = (int)(random.nextDouble()*maxi);
		
		return new int[] {i, j};
		
	}

}
