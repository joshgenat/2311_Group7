package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import org.junit.jupiter.api.Test;

import tab2xml.*;

public class XMLTester {
	
	/**
	 * Tests:
	 * Divisions
	 * Key
	 * Time
	 * Clef
	 * Backup
	 * Barline
	 */
	
	@Test
	void divisionsTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int[] t = {r1};
		
		String actual = Divisions.divisionsTest(t);
		String expected = divisions(t);
		
		assertEquals(expected, actual); 
	}
	
	String divisions(int[] s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<divisions>");  
		sb.append("\n" + s[0]); 
		sb.append("\n</divisions>");
		
		return sb.toString();
	}
	
	
	
	@Test
	void keyTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		int[] t = {r1, r2};
		
		String actual = Key.keyTest(t);
		String expected = key(t);
		
		assertEquals(expected, actual);
	}
	
	String key(int[] s) {
		StringBuilder sb = new StringBuilder();
		sb.append("<key>");  
		
			fifths(s, sb);
		
		sb.append("\n</key>");
		
		return sb.toString();
	}
	static void fifths(int[] o, StringBuilder sb) {
		sb.append("\n\t<fifths>" + o[0] + "</fifths>");
	}
	
	
	
	
	@Test
	void timeTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		int[] t = {r1, r2};
		
		String actual = Time.timeTest(t);
		String expected = time(t);
		
		
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
	static void beats(int[] s, StringBuilder sb) {
		sb.append("\n\t<beats>" + s[0] + "</beats>");
	}

	static void beatType(int[] s, StringBuilder sb) {
		sb.append("\n\t<beatType>" + s[1] + "</beatType>");
	}
	
	
	@Test
	void clefTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		int[] t = {r1, r2};
		
		String actual = Clef.clefTest(t);
		String expected = clef(t);
		
		
		assertEquals(expected, actual);
	}
	 String clef(int[] s) {
		StringBuilder sb = new StringBuilder();
		sb.append("<clef>");  
					
		if (s[0] != 0)
			sign(s, sb);
							
		if (s[1] != 0)
			line(s, sb);
					
		sb.append("\n</clef>");
		return sb.toString();
	}
	static void sign(int[] o, StringBuilder sb) {
		sb.append("\n\t<sign>" + o[0] + "</sign>");
	}

	static void line(int[] o, StringBuilder sb) {
		sb.append("\n\t<line>" + o[1] + "</line>");
	}
	
	
	@Test
	void backupTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int[] t = {r1};
		
		String actual = Backup.backupTest(t);
		String expected = backup(t);
		
		assertEquals(expected, actual);
	}
	
	String backup(int[] s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<backup>");  
		sb.append("\n" + s[0]); 
		sb.append("\n</backup>");
		
		return sb.toString();
	}
	
	@Test
	void barlineTest() {
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		int[] t = {r1, r2};
		
		String actual = Backup.backupTest(t);
		String expected = backup(t);
		
		assertEquals(expected, actual);
	}
	
	String barline(int[] s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<backup>");  
		sb.append("\n<bar-style>" + s[0] + "\n</bar-style>"); 
		sb.append("\n<repeat>" + s[1] + "\n</repeat>"); 
		sb.append("\n</backup>");
		
		return sb.toString();
	}
}
