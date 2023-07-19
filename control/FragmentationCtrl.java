package control;

import java.io.File;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.FragmentFile;
import visualization.FragmentationScene;

/*
 * Creates a controller for the Fragmentation scene control, 
 * In which it shows a message and sets a title
 */
public class FragmentationCtrl {
	// Attributes
	private FragmentationScene scene;
	private Button cancel;
	private Button divide;
	private TextField fragments;

	// Constructor

	/**
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	public FragmentationCtrl(Stage stage, File directory, File file2){
		initialize(stage, directory, file2);
	}

	// A method to initialize the scene

	/**
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	private void initialize(Stage stage, File directory, File file2) {
		setScene(new FragmentationScene(stage));
		setFragments(getScene().getFragments());
		setCancel(getScene().getCancel());
		setDivide(getScene().getDivide());
		
		handle_divide(divide, file2);
		handle_cancel(cancel, stage, directory, file2);
	}

	/*
	 * Handlers
	 */

	/**
	 * @param cancel2
	 * @param stage
	 * @param directory
	 * @param file2
	 */
	private void handle_cancel(Button cancel2, Stage stage, File directory, File file2) {
		// Method that handles cancel
		cancel2.setOnAction(e -> {
			@SuppressWarnings("unused")
			HomeCtrl scene = new HomeCtrl(stage, directory, file2);
		});
	}
	
	/**
	 * @param divide
	 * @param file2
	 */
	private void handle_divide(Button divide, File file2) {
		// Method that handles divide
		divide.setOnAction(e -> {
			int fragmnets = Integer.parseInt(fragments.getText().trim());
			if(validInt(fragmnets)) {
				try {
					@SuppressWarnings("unused")
					FragmentsTableViewCtrl scene = new FragmentsTableViewCtrl(FragmentFile.fragmentFile(file2, fragmnets));
				} catch (IOException e1) {
					AlertBoxCtrl a = new AlertBoxCtrl("Input output exception", "Exception");
					a.show();
				}
			}else{
				AlertBoxCtrl a = new AlertBoxCtrl("Please Enter a valid number of fragments!", "Not valid int");
				a.show();
			}
		});
	}
	/*
	 * This method is created to validate the number of fragments is a positive integer
	 */
	/**
	 * @param fragments2
	 * @return
	 */
	private boolean validInt(int fragments2) {
		if(fragments2>=0) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the scene
	 */
	public FragmentationScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(FragmentationScene scene) {
		this.scene = scene;
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

	/**
	 * @return the divide
	 */
	public Button getDivide() {
		return divide;
	}

	/**
	 * @param divide the divide to set
	 */
	public void setDivide(Button divide) {
		this.divide = divide;
	}

	/**
	 * @return the fragments
	 */
	public TextField getFragments() {
		return fragments;
	}

	/**
	 * @param fragments the fragments to set
	 */
	public void setFragments(TextField fragments) {
		this.fragments = fragments;
	}

}