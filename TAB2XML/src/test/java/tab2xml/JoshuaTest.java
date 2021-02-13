package tab2xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JoshuaTest {
	
	@Test
	void testDivisions() {
		Divisions div = new Divisions();
		String expected = "<divisions>1</divisions>\r\n" + 
				"\t<key>\r\n" + 
				"\t\t<fifths>2</fifths>\r\n" + 
				"\t</key>";
		
		String actual = div.divisions(1, 2, 3);
		assertEquals(expected, actual, "The method should input the numbers");
	}
	
	@Test
	void testStaff() {
		Staff s = new Staff();
		String expected = "<staff-details>" +
                "<staff-lines>6</staff-lines>" + 
                "<staff-tuning line=1>" +
                    "<tuning-step>E</tuning-step>" + 
                    "<tuning-octave>2</tuning-octave>" +
              "</staff-tuning>" +
           "</staff-details>";
		int[] test = {1, 2, 3};
		
		String actual = s.staff(test, 10);
		assertEquals(expected, actual, "The method should input the numbers");
	}
	
	void test() {
		
	}

}
