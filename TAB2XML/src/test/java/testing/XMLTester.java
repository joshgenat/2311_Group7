package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import org.junit.jupiter.api.Test;
import tab2xml.Time;

public class XMLTester {

	@Test
	void timeTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		int[] s = {r1, r2};
		
		String actual = Time.timeTest(s);
		String expected = time(s);
		
		
		assertEquals(expected, actual);
	}

	String time(int[] s) {
		StringBuilder sb = new StringBuilder();
		sb.append("<time>");  
		
		if (s[0] != 0)
			beats(s, sb);
				
			if (s[1] != 0)
			beatType(s, sb);
		
		sb.append("\n</time>");
		return sb.toString();
	}
	static void beats(int[] o, StringBuilder sb) {
		sb.append("\n\t<beats>" + o[0] + "</beats>");
	}

	static void beatType(int[] o, StringBuilder sb) {
		sb.append("\n\t<beatType>" + o[1] + "</beatType>");
	}
}
