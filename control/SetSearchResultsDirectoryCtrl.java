package control;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.StoreFileintoDirectory;
import visualization.SetDirectoryScene;

/*
 * This class creates a controller for the browse file scene of saving the results of search
 */
public class SetSearchResultsDirectoryCtrl {
	// Fields
	private DirectoryChooser fileChooser;
	private File file;
	private SetDirectoryScene scene;
	private GridPane pane;
	private Label label;
	private Button browse;
	private Button cancel;

	// Constructor
	/**
	 * @param stage
	 * @param files
	 */
	public SetSearchResultsDirectoryCtrl(Stage stage,ArrayList<File> files) {
		initialize(stage,files);
	}

	// Initialize objects

	/**
	 * @param stage
	 * @param files
	 */
	private void initialize(Stage stage,ArrayList<File> files) {
		scene = new SetDirectoryScene(stage,"	 Chose the directory to save the search results in!...");
		setPane(scene.getPane());
		setLabel(scene.getLabel());
		cancel = scene.getCancel();
		this.fileChooser = new DirectoryChooser();
		browse = scene.getBrowse();
		handle_browse(browse, stage, files);
		handle_cancel(cancel, stage);
	}

	/*
	 * Handlers
	 */

	/**
	 * @param cancel2
	 * @param stage 
	 */
	private void handle_cancel(Button cancel2, Stage stage) {
		// Handle the button cancel
		cancel2.setOnAction(e -> {
			stage.close();
		});
	}

	/**
	 * @param browse2
	 * @param stage
	 * @param files 
	 */
	private void handle_browse(Button browse2, Stage stage, ArrayList<File> files) {
		// Handle browsing button
		browse2.setOnAction(e -> {
			this.file = fileChooser.showDialog(new Stage());
			if (file == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a Directory yet!", "No Directory");
				a.show();
			} else {
				if(StoreFileintoDirectory.saveFiles(files, file)==true) {
					AlertBoxCtrl a = new AlertBoxCtrl("Your files were saved!", "Save files");
					a.show();
				}else{
					AlertBoxCtrl a = new AlertBoxCtrl("An error occured with storing files!", "Error Save files");
					a.show();
				}
				
			}
		});
	}
	
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the fileChooser
	 */
	public DirectoryChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * @param fileChooser the fileChooser to set
	 */
	public void setFileChooser(DirectoryChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}


	/**
	 * @return the pane
	 */
	public GridPane getPane() {
		return pane;
	}

	/**
	 * @param pane the pane to set
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}

	/**
	 * @return the browse
	 */
	public Button getBrowse() {
		return browse;
	}

	/**
	 * @param browse the browse to set
	 */
	public void setBrowse(Button browse) {
		this.browse = browse;
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