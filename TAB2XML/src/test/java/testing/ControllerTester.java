package testing;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class ControllerTester {
	
	private static Stage stage;
	@Start
	public void start(Stage primaryStage) throws IOException {
		
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
			primaryStage.getIcons().add(new Image("/logo.png"));
			primaryStage.setTitle("Tab2XML");
			primaryStage.setScene(new Scene(root, 900, 550));
			primaryStage.show();
	}
	
	@Test
	void convertBtn(FxRobot robot) {
		FxAssert.verifyThat("#convert", LabeledMatchers.hasText("Convert"));
	}
	
	@Test
	void convertBtnClick(FxRobot robot) {
		robot.clickOn("#convert");
		robot.sleep(1000);
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Error converting,\nmake sure your tab is\ncorrect and Try Again!\nError Number: #001"));
	}
}