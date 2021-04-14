package tab2xml;
import exceptions.*;

import exceptions.InproperInputException;

public class ConverterTester {

	public static void main(String[] args) throws Exception {
		GuitarConverter guitar = new GuitarConverter();
		

		String[] testExample = {
				"|-----------2-----|-0---------------|",
				"|-------------1---|-0---------------|",
				"|---------------1-|-1---------------|",
				"|-----12h11-------|-1---------------|",
				"|---2-------------|-2---------------|",
				"|-1---------------|-0---------------|"
		};
		
		String[] test4 = {
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|"
		};
		
		String[] test5 = {
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|"
		};
		
		String[] test6 = {
				"|0-1-2-10-1--1-|",
				"|0-1-2-10-2----|",
				"|0-1-2-10-4--1-|",
				"|0-1-2-10-8----|",
				"|0-1-2-10-16-1-|",
				"|0-1-2-10-21---|"
		};
		
		String[] test7 = {
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|",
				"|0-1-2-3-4-5-6-----|"
		};
		
		String[] testS = {
				"e|-------------7-----------|-------------------|-------------7-----------|",
				"B|-------------8-----------|-------7--------5--|-------------8-----------|",
				"G|-----------9-------------|-------7--------5--|-----------9-------------|",
				"D|---------9---------------|----7--------5-----|---------9---------------|",
				"A|-------7-----------------|-5--------3--------|-------7-----------------|",
				"E|-0-----------------------|-------------------|-0-----------------------|"
		};
		
		String[] testH = {
				"|---------------0-|----------------|-------3----------|-------2------------|",
				"|---------1-----1-|---------1----1-|-------3----------|-------3--------3---|",
				"|---------0-------|---------0----0-|----------------0-|-------------2------|",
				"|------2----------|------2---------|----0--------0----|----0---------------|",
				"|-2h3--------3----|-2h3--------3---|-2--------2-------|-0--------0---------|",
				"|-----------------|----------------|------------------|--------------------|"
		};
		
		String[] testP = {
				"|---------------0-|----------------|-------3----------|-------2------------|",
				"|---------11h12-1-|---------1----1-|-------3----------|-------3--------3---|",
				"|-----------------|---------0----0-|----------------0-|-------------2------|",
				"|-----g20---------|------2---------|----0--------0----|----0---------------|",
				"|g20p3-------3----|-2p3--------3---|-2--------2-------|-0--------0---------|",
				"|-----------------|----------------|------------------|--------------------|"
		};
		
		
		
		char[][] test3 = stringToCharArray(test6);
		
		GuitarChord[] notes = null;
		try {
			notes = guitar.converter(test3, 1, 'a');
		}
		catch(InproperInputException e) {
			System.out.println(e.message);
		}
		
		
		//System.out.println("\n test \n");
		
		for(int i = 0; i < test3.length; i++) {
			for(int j = 0; j < test3[0].length; j++) {
					System.out.print("\'" + test3[i][j] + "\',");
				}
			System.out.println();
		}

		System.out.println("\n result \n");

		//System.out.println(guitar.isNum('f'));
		
		for(int i = 0; i < notes[0].notes.length; i++) { 
			System.out.print("{");
			for(int j = 0; j < notes.length; j++) { 
				if(notes[j] == null) break;
				//System.out.print("\'" + notes[j].notes[i].step + "\', ");
				//System.out.print(notes[j].notes[i].nextMeasure + ", ");
				if(false)
					System.out.print(notes[j].notes[i].octave + ", ");
				else
					System.out.print(notes[j].notes[i] + "\", \"");
			}	
			System.out.print("},\n"); 
		} 
	}
	
	public static char[][] stringToCharArray(String[] in){
		char[][] out = new char[in.length][in[0].length()];
		
		for(int i = 0; i < in.length; i++) {
			for(int j = 0; j < in[i].length(); j++) {
				out[i][j] = in[i].charAt(j);
			}
		}
		
		return out;
	}

}
