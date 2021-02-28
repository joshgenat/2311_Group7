package tab2xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	
	public Controller() {
		
	}
	
	@FXML
	private Button convert;
	
	@FXML 
	private Button clear;
	
	@FXML
	private Button selectFile;
	
	@FXML
	private Button download;
	
	@FXML 
	private TextArea tabText;
	
	@FXML
	private TextArea xmlText;
	
	@FXML
	private ListView fileView;
	
	@FXML
	private TabPane tabView;
	
	
	public void convert(ActionEvent event) throws IOException {
  	   String [] parse = tabText.getText().split("\n");
			ArrayList<Object> lines = new ArrayList<Object>();
			
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			Tab b = new Tab(lines);
			for(int i = 0; i < b.nodes.size(); i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						System.out.print(k);
					}
					System.out.println();
				}
				System.out.println();
			}
			if(b.Type.equals("Drum")) {
				DrumNoteObject c = new DrumNoteObject(b);
	 			DrumXML d = new DrumXML(c);
	 			xmlText.setText(d.text);
				}
				else {
					GuitarNoteObject c = new GuitarNoteObject(b);
					GuitarXML d = new GuitarXML(c);
					xmlText.setText(d.text);
				}
			tabView.getSelectionModel().select(1);
		
	}
	
	public void selectFile(ActionEvent event) {
		String text = "";
		FileChooser fc = new FileChooser();	
		fc.getExtensionFilters().addAll(new ExtensionFilter("TXT Files", "*.txt"));
		File selectedFile = fc.showOpenDialog(null);
		ArrayList<Object> a = readFile(selectedFile);
		
		for(int i = 0; i < a.size()-1; i++) {
			text+=a.get(i).toString() + "\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		
	}
	private ArrayList<Object> readFile(File file){
		ArrayList<Object> lines = new ArrayList<>();
		Scanner sc = null; 
		try {
			sc = new Scanner(file);	
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
		return lines;
	}
	
	public void clear(ActionEvent event) {
		if(tabView.getSelectionModel().isSelected(0)) {
			tabText.setText("");
		}
		else {
			xmlText.setText("");
		}
	}
	
	public void download(ActionEvent event) {
		tabView.getSelectionModel().select(1);
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("musicXML (*.musicXML)", "*.musicXML"));
		File file = fc.showSaveDialog(null);
		if(file != null) {
	        try {
	            FileWriter fileWriter;
	            fileWriter = new FileWriter(file);
	            fileWriter.write(xmlText.getText());
	            fileWriter.close();
	        } catch (IOException ex) {
	        }
		}
		
	}
	
}
