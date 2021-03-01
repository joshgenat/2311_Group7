package tab2xml;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
			primaryStage.getIcons().add(new Image("/logo.png"));
			primaryStage.setTitle("Tab2XML");
			primaryStage.setScene(new Scene(root, 900, 550));
			primaryStage.show();
		 
	}
	
	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stage.getScene().setRoot(pane);
	}
	
	public void openWeb(String text) {
		getHostServices().showDocument(text);
	}
	public static void main(String[] args) {
		launch(args);
	}
}