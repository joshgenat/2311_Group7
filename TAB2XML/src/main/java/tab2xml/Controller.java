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
	private Button saveNew;
	
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
	
	@FXML
	private ComboBox clefSignBox;
	
	@FXML
	private ComboBox measureList;
	
	@FXML
	private TextField timeField;
	
	@FXML
	private TextField songNameField;
	//
	private Tab b;
	public void initialize() {
		ObservableList<String> signClefList = FXCollections.observableArrayList("Treble","Bass", "Tenor", "Percussion", "Tab");
		clefSignBox.setItems(signClefList);
		clefSignBox.getSelectionModel().select(0);
		saveNew.setVisible(false);
	}
	
	public void convert(ActionEvent Event) throws IOException {
		try {
  	        String [] parse = tabText.getText().split("\n");
			ArrayList<Object> lines = new ArrayList<Object>();
			
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			b = new Tab(lines);
			ObservableList<String> lineNum = FXCollections.observableArrayList();
			int measureN = 1;
			for(int i = 0; i < b.nodes.size(); i++) {
				lineNum.add("Measure " + measureN + " - " + (measureN + b.nodes.get(i).measureNumber - 1));
				measureN += b.nodes.get(i).measureNumber;
			}
			measureList.setItems(lineNum);
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
			errorLabel.setTextFill(Color.BLUE);
			errorLabel.setText(b.Type + "\n" + "Conversion Complete");
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			errorLabel.setTextFill(Color.RED);
			errorLabel.setText("Error converting,\nInvalid Time Input\nError Number: #003");
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
			timeField.setText("");
			songNameField.setText("");
			saveNew.setVisible(false);
		}
		else {
			xmlText.setText("");
			errorLabel.setText("");
			timeField.setText("");
			songNameField.setText("");
			saveNew.setVisible(false);
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
		
		for(int i = 0; i < b.size(); i++) {
			text+=b.get(i).toString() + "\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		
		
	}
	
	public void selectLine() {
		String text = "";
		for(int i = 0; i < b.nodes.get(measureList.getSelectionModel().getSelectedIndex()).nodes.length; i++) {
			for(int j = 0; j < b.nodes.get(measureList.getSelectionModel().getSelectedIndex()).nodes[i].length; j++) {
				text += b.nodes.get(measureList.getSelectionModel().getSelectedIndex()).nodes[i][j];
			}
			text += "\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		saveNew.setVisible(true);
	}
	
	public void saveNew() {
		String text = tabText.getText();
		String [] text1 = text.split("\n");
		char [][] node = new char[text1.length][text1[0].length()];
		for(int i = 0; i < text1.length; i++) {
			for(int j = 0; j < text1[i].length(); j++) {
				node[i][j] = text1[i].charAt(j);
			}
		}
		b.nodes.get(measureList.getSelectionModel().getSelectedIndex()).nodes = node;
		text = "";
		for(int i = 0; i < b.nodes.size(); i++) {
			for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
				for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
					text += b.nodes.get(i).nodes[j][k];
				}
				text+="\n";
			}
			text+="\n";
		}
		tabText.setText(text);
		tabView.getSelectionModel().select(0);
		saveNew.setVisible(false);
		
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
