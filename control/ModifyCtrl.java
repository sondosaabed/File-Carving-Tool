package control;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import visualization.ModifyScene;
/*
 * Creates a controller for the modify the file window, 
 * In which it shows a message for the user to edit the file after chosing it
 */
public class ModifyCtrl {
	//Attributes
	private ModifyScene scene;
	private Label message;
	private Button okay;
	//Constructor
	/**
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	public ModifyCtrl(Stage stage, File directory, File file2) {
		initialize(stage, directory,file2);
	}

	//A method to initialize the scene
	/**
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	private void initialize(Stage stage, File directory, File file2) {
		setScene(new ModifyScene(stage));
		setMessage(getScene().getMessage());
		setOkay(getScene().getCancel());
				
		handle_okay(okay, stage, directory, file2);
	}

	/*
	 * Handlers
	 */
	
	/**
	 * @param okay
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	private void handle_okay(Button okay, Stage stage, File directory, File file2) {
		//Method that handles okay
		okay.setOnAction(e->{
			@SuppressWarnings("unused")
			HomeCtrl scene = new HomeCtrl(stage, directory, file2);
		});
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the scene
	 */
	public ModifyScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(ModifyScene scene) {
		this.scene = scene;
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Label message) {
		this.message = message;
	}

	/**
	 * @return the cancel
	 */
	public Button getOkay() {
		return okay;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setOkay(Button cancel) {
		this.okay = cancel;
	}
}