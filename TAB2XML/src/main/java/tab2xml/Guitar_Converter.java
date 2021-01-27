package tab2xml;

public class Guitar_Converter {
	
	
	public static char GuitarConverter(char[][] in) { 
		String out = "";
		
		
		
		return StringToNote(out);
	}
	
	public static String StringToNote(String in) {
		
		switch(in) {
			case "-----0":
				return "E";
			case "-----1":
				return "F";
			default:
				return "-";
		}
		
	}
}
