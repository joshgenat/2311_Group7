package tab2xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	private Button measureListSave;
	
	@FXML
	private Button measureListEdit;
	
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
	private Label measureListMax;
	
	@FXML
	private MenuItem drumSample;
	
	@FXML
	private MenuItem guitarSample;
	
	@FXML
	private MenuItem getHelp;
	
	@FXML
	private ComboBox clefSignBox;
	
	@FXML
	private ComboBox measureList;
	
	@FXML
	private TextField timeField;
	
	@FXML
	private TextField songNameField;
	
	@FXML
	private TextField measureListS;
	
	@FXML
	private TextField measureListE;
	//
	private Tab b;
	
	public void initialize() {
		ObservableList<String> signClefList = FXCollections.observableArrayList("Treble","Bass", "Tenor", "Percussion", "Tab");
		clefSignBox.setItems(signClefList);
		clefSignBox.getSelectionModel().select(0);
		measureListSave.setVisible(false);
		measureListMax.setVisible(false);
	}
	
//	public void initializeTab() {
//		String [] parse = tabText.getText().split("\n");
//		ArrayList<Object> lines = new ArrayList<Object>();
//		
//		for(int i = 0; i < parse.length; i++) {
//			lines.add(parse[i]);
//		}
//		
//		b = new Tab(lines);
//		System.out.println("test");
//	}
	
	public void convert(ActionEvent Event) throws IOException {
		try {
			String [] parse = tabText.getText().split("\n");
			ArrayList<Object> lines = new ArrayList<Object>();
			
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			b = new Tab(lines);
			
			if(b.Type.equals("Drum")) {
				DrumNoteObject c = new DrumNoteObject(b);
				c.setBeats(timeField.getText());
	 			DrumXML d = new DrumXML(c);
	 			xmlText.setText(d.text);
	 			clefSignBox.getSelectionModel().select(3);
				}
				else {
					String sign = "Treble";
					if(clefSignBox.getSelectionModel().getSelectedIndex()==3) {
						clefSignBox.getSelectionModel().select(0);
					}
					else {sign = clefSignBox.getSelectionModel().getSelectedItem().toString();}
					GuitarNoteObject c = new GuitarNoteObject(b,sign);
			        c.setBeats(timeField.getText());
					GuitarXML d = new GuitarXML(c);
					xmlText.setText(d.text);
				}
			tabView.getSelectionModel().select(1);
			
			errorLabel.setTextFill(Color.WHITE);
			errorLabel.setText(b.Type + "\n" + "Conversion Complete");
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			errorLabel.setTextFill(Color.PINK);
			errorLabel.setText("Error converting,\nInvalid Time Input\nError Number: #003");
		}
		catch(Exception e) {
			e.printStackTrace();
			errorLabel.setTextFill(Color.PINK);
			errorLabel.setText("Error converting,\nmake sure your tab is\ncorrect and Try Again!\nError Number: #001");
		}
		measureListMax.setText("Range\n 1-" + b.nodes.size());
		measureListMax.setVisible(true);
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
			xmlText.setText("");
			errorLabel.setText("");
			timeField.setText("");
			songNameField.setText("");
			
		}
//		else {
//			
//			errorLabel.setText("");
//			timeField.setText("");
//			songNameField.setText("");
//			saveNew.setVisible(false);
//		}
	}
	
	public void download(ActionEvent event) {
		tabView.getSelectionModel().select(1);
		if(xmlText.getText().equals("")) {
			errorLabel.setText("XML textarea empty...\nError Number: #002");
			errorLabel.setTextFill(Color.PINK);
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
		
		for(int i = 0; i < b.size(); i++) {
			text+=b.get(i).toString() + "\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		
		
	}
	
	public void editMeasure() {
		try {
			int start = Integer.parseInt(measureListS.getText());
			int end = Integer.parseInt(measureListE.getText());
			measureListS.setEditable(false);
			measureListE.setEditable(false);
			String edit = "";
			for(int i = start-1; i < end; i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						edit += b.nodes.get(i).nodes[j][k];
					}
					edit += "\n";
				}
				edit += "\n";
			}
			tabText.setText(edit);
			tabView.getSelectionModel().select(0);
			measureListEdit.setVisible(false);
			measureListSave.setVisible(true);
			convert.setVisible(false);
			download.setVisible(false);
		}
		catch(Exception e) {
			errorLabel.setText("Invalid Measure\n Inputs");
			errorLabel.setTextFill(Color.PINK);
		}
	}
	
	public void saveMeasure() {
		String text = tabText.getText();
		String [] split = text.split("\n");
		int index = 0;
		int start = Integer.parseInt(measureListS.getText());
		int end = Integer.parseInt(measureListE.getText());
		
		for(int i = start-1; i < end; i++) {
			ArrayList<String> pass = new ArrayList<>();
			while(true) {
				if(index >= split.length) {
					break;
				}
				if(split[index].isEmpty()) {
					index++;
					break;
				}
				pass.add(split[index]);
				index++;
			}
			char [][] newNode = new char[pass.size()][pass.get(0).length()];
			for(int j = 0; j < pass.size(); j++) {
				for(int k = 0; k < pass.get(j).length(); k++) {
					newNode[j][k] = pass.get(j).charAt(k);
				}
			}
			b.nodes.get(i).nodes = newNode;
		}	
		measureListS.setEditable(true);
		measureListE.setEditable(true);
		measureListEdit.setVisible(true);
		measureListSave.setVisible(false);
		convert.setVisible(true);
		download.setVisible(true);
		convertNew();
		String nText = "";
		for(int i = 0; i < b.nodes.size(); i++) {
			for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
				for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
					nText += b.nodes.get(i).nodes[j][k];
				}
				nText += "\n";
			}
			nText += "\n";
		}
		tabText.setText(nText);
	}
	
	public void convertNew() {
		if(b.Type.equals("Drum")) {
			DrumNoteObject c = new DrumNoteObject(b);
			c.setBeats(timeField.getText());
 			DrumXML d = new DrumXML(c);
 			xmlText.setText(d.text);
 			clefSignBox.getSelectionModel().select(3);
			}
			else {
				String sign = "Treble";
				if(clefSignBox.getSelectionModel().getSelectedIndex()==3) {
					clefSignBox.getSelectionModel().select(0);
				}
				else {sign = clefSignBox.getSelectionModel().getSelectedItem().toString();}
				GuitarNoteObject c = new GuitarNoteObject(b,sign);
		        c.setBeats(timeField.getText());
				GuitarXML d = new GuitarXML(c);
				xmlText.setText(d.text);
			}
		tabView.getSelectionModel().select(1);
		
	}
	
	public void getHelp() {
		Main m = new Main();
		m.openWeb("https://github.com/joshgenat/2311_Group7/blob/master/User%20Manual.pdf");
	}
	
	public void openC() {
		Main m = new Main();
		m.openWeb("https://opensheetmusicdisplay.github.io/demo/");
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
