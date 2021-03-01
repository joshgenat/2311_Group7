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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
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
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private MenuItem drumSample;
	
	@FXML
	private MenuItem guitarSample;
	
	@FXML
	private MenuItem getHelp;
	
	
	public void convert(ActionEvent event) throws IOException {
		try {
  	        String [] parse = tabText.getText().split("\n");
			ArrayList<Object> lines = new ArrayList<Object>();
			
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			Tab b = new Tab(lines);
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
			errorLabel.setTextFill(Color.BLUE);
			errorLabel.setText(b.Type + "\n" + "Conversion Complete");
		}
		catch(Exception e) {
			e.printStackTrace();
			errorLabel.setTextFill(Color.RED);
			errorLabel.setText("Error converting,\nmake sure your tab is\ncorrect and Try Again!\nError Number: #001");
		}
		
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
	
	public void clear(ActionEvent event) {
		if(tabView.getSelectionModel().isSelected(0)) {
			tabText.setText("");
			errorLabel.setText("");
		}
		else {
			xmlText.setText("");
			errorLabel.setText("");
		}
	}
	
	public void download(ActionEvent event) {
		tabView.getSelectionModel().select(1);
		if(xmlText.getText().equals("")) {
			errorLabel.setText("XML textarea empty...\nError Number: #002");
			errorLabel.setTextFill(Color.RED);	
		}
		else {
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
	
	public void sample(ActionEvent event) {
		File a = null;
		String text = "";
		if(event.getSource() == drumSample) {
			a = new File("src/main/resources/drumSample");
		}
		else if(event.getSource() == guitarSample) {
			a = new File("src/main/resources/guitarSample");
		}
		ArrayList<Object> b = readFile(a);
		
		for(int i = 0; i < b.size()-1; i++) {
			text+=b.get(i).toString() + "\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		
		
	}
	
	public void getHelp() {
		Main m = new Main();
		m.openWeb("https://github.com/joshgenat/2311_Group7/blob/master/Requirements%20Document.pdf");
	}
	
	//Helper Method
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
	
}
