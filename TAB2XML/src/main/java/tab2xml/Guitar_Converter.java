package tab2xml;

public class Guitar_Converter {
	
	public static void main(String args[]) {
		char[][] test = {
				{'0','3','-','-','6','-',}, 
				{'0','-','4','-','-','-',},
				{'1','-','4','-','7','-',},
		};
		String[][] notes = GuitarConverter(test);
		
		for(int i = 0; i < notes.length; i++) {
			for(int j = 0; j < notes[i].length; j++) {
					System.out.print(notes[i][j] + ", ");
				}
			System.out.println();
		}
			
		//System.out.println(test[0][1]);
	}
	
	public static String[][] GuitarConverter(char[][] in) { 
		String[][] out;
		String tmp; 
		int i, j, j2;
		out = new String[in.length][in[0].length];
		for(i = 0; i < out.length; i++) {
			tmp = "";
			for(j = 0; j < out[i].length; j++) {
				tmp = "";
				for(j2 = 0; j2 < out[i].length; j2++) {
					if(j2 == j)
						tmp = tmp + in[i][j];
					else
						tmp = tmp + '-';
				}
				out[i][j] = StringToNote(tmp);
			}
			
			
		}
		
		
		return out;
	}
	
	public static String StringToNote(String in) {
		
		switch(in) {
			case "0-----":
				return "E";
			case "-0----":
				return "B";
			case "--0---":
				return "g";
			case "---0--":
				return "D";
			case "----0-":
				return "A";
			case "-----0":
				return "E";
			case "1-----":
				return "F";
			case "-1----":
				return "C";
			case "--1---":
				return "G#";
			case "---1--":
				return "D#";
			case "----1-":
				return "A#";
			case "-----1":
				return "F";
			case "2-----":
				return "F#";
			case "-2----":
				return "C#";
			case "--2---":
				return "A";
			case "---2--":
				return "E";
			case "----2-":
				return "B";
			case "-----2":
				return "F#";
			case "3-----":
				return "G";
			case "-3----":
				return "D";
			case "--3---":
				return "A#";
			case "---3--":
				return "F";
			case "----3-":
				return "C";
			case "-----3":
				return "G";
			case "4-----":
				return "G#";
			case "-4----":
				return "D#";
			case "--4---":
				return "B";
			case "---4--":
				return "F#";
			case "----4-":
				return "C#";
			case "-----4":
				return "G#";
			case "5-----":
				return "A";
			case "-5----":
				return "E";
			case "--5---":
				return "C";
			case "---5--":
				return "G";
			case "----5-":
				return "D";
			case "-----5":
				return "A";
			case "6-----":
				return "A#";
			case "-6----":
				return "F";
			case "--6---":
				return "C#";
			case "---6--":
				return "G#";
			case "----6-":
				return "D#";
			case "-----6":
				return "A#";
			default:
				return "-";
		}
		
	}
}
