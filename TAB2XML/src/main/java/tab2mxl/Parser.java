package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Parser {
	private ArrayList<Object> lines = new ArrayList<Object>();
	private File inputFile;
	
	
	/**
	 * Constructor that creates the parser
	 * 
	 */
	public Parser(){
		lines = new ArrayList<Object>();
		this.selectFile();
		this.readFile();
	}
	
	/**
	 * Method to read file and put into arraylist lines
	 */
	private void readFile() {
		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				lines.add(sc.nextLine());
	        }      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}		
	} 
	
	/*
	 * Method that prompts user to select a file
	 */
	private void selectFile() {
		JButton open = new JButton();
		File abs = new File(".");
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(abs);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			inputFile = fc.getSelectedFile();
		}	
	}
	
	/*
	 * helper method to test the printline (will have to convert to char array)
	 */
	public void printline() {
		for(int i = 0;i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
	}
}
