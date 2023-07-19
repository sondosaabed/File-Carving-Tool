/**
 * 
 */
package control;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.FragmentsTableViewScene;

/**
 * Here I create a class for controling the table Scene
 */
public class FragmentsTableViewCtrl {
	// Feilds
	private FragmentsTableViewScene scene;
	private Stage stage;
	private Button cancel;

	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public FragmentsTableViewCtrl(ArrayList<File> list) {
		initialize(list);
	}

	/*
	 * Initializer
	 */
	/**
	 * @param list
	 */
	private void initialize(ArrayList<File> list) {
		setScene(new FragmentsTableViewScene(list));
		setCancel(getScene().getCancel());
		setStage(getScene().getStage());
		handle_cancel(getCancel());
	}

	/*
	 * Handle when the user clicks Cancel close the stage
	 */
	/**
	 * @param cancel2
	 */
	private void handle_cancel(Button cancel2) {
		cancel2.setOnAction(e -> {
			getStage().close();
		});
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the scene
	 */
	public FragmentsTableViewScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(FragmentsTableViewScene scene) {
		this.scene = scene;
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}