package tab2xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionsTest {

	@Test
	void test() {
		Divisions div = new Divisions();
		String expected = "<divisions>1</divisions>\r\n" + 
				"\t<key>\r\n" + 
				"\t\t<fifths>2</fifths>\r\n" + 
				"\t</key>";
		
		String actual = div.divisions(1, 2, 3);
		assertEquals(expected, actual);
	}

}
