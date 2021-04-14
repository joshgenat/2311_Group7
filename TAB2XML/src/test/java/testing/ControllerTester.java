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
	
	@Test
	void convertInvalidTime(FxRobot robot) {
		robot.clickOn("#timeField");
		robot.write("5/5");
		robot.clickOn("#convert");
		robot.sleep(1000);
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Error converting,\nInvalid Time Input\nError Number: #003"));
	}
	
	@Test
	void drumSample(FxRobot robot) {
		robot.clickOn("#helpBar");
		robot.clickOn("#sampleBar");
		robot.sleep(1000);
		robot.clickOn("#drumSample");
		robot.sleep(1000);
		robot.clickOn("#convert");
		robot.sleep(1000);
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Drum" + "\n" + "Conversion Complete"));
	}
	
	@Test
	void guitarSample(FxRobot robot) {
		robot.clickOn("#helpBar");
		robot.clickOn("#sampleBar");
		robot.sleep(1000);
		robot.moveTo("#drumSample");
		robot.clickOn("#guitarSample");
		robot.sleep(1000);
		robot.clickOn("#convert");
		robot.sleep(1000);
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Guitar" + "\n" + "Conversion Complete"));
	}
	
	@Test
	void editMeasureError(FxRobot robot) {
		robot.clickOn("#helpBar");
		robot.clickOn("#sampleBar");
		robot.clickOn("#drumSample");
		robot.clickOn("#convert");
		robot.clickOn("#measureListS");
		robot.write("1s");
		robot.clickOn("#measureListE");
		robot.write("2");
		robot.clickOn("#measureListEdit");
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Invalid Measure\n Inputs"));
	}
	
	@Test
	void editMeasure(FxRobot robot) {
		String editL = "Currently Editing: ";
		editL += 1 + "-" + 2 + "\n";
		 editL += "Repeats for range: " + 1 + "\n";
		 editL += "Time for range: " + "4/4" + "\n";
		robot.clickOn("#helpBar");
		robot.clickOn("#sampleBar");
		robot.clickOn("#drumSample");
		robot.clickOn("#convert");
		robot.clickOn("#measureListS");
		robot.write("1");
		robot.clickOn("#measureListE");
		robot.write("2");
		robot.clickOn("#measureListEdit");
		FxAssert.verifyThat("#editLabel", LabeledMatchers.hasText(editL));
	}
	
	@Test
	void saveMeasure(FxRobot robot) {
		robot.clickOn("#helpBar");
		robot.clickOn("#sampleBar");
		robot.clickOn("#drumSample");
		robot.clickOn("#convert");
		robot.clickOn("#measureListS");
		robot.write("1");
		robot.clickOn("#measureListE");
		robot.write("2");
		robot.clickOn("#measureListEdit");
		robot.clickOn("#repeatField");
		robot.write("2");
		robot.sleep(100);
		robot.clickOn("#measureListSave");
		robot.sleep(1000);
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Drum" + "\n" + "Conversion Complete"));
	}
	
	
}