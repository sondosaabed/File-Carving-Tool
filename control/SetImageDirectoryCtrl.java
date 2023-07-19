package control;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.ImageCreater;
import visualization.SetDirectoryScene;

/*
 * This class creates a controller for the browse file scene to set the image directory
 */
public class SetImageDirectoryCtrl {
	// Fields
	private DirectoryChooser directoryChooser;
	private File file;
	private SetDirectoryScene scene;
	private GridPane pane;
	private Label label;
	private Button browse;
	private Button cancel;
	private File savingPath;


	// Constructor
	/**
	 * @param stage
	 * @param file2
	 */
	public SetImageDirectoryCtrl(Stage stage, File file2) {
		initialize(stage,file2);
	}

	// Initialize objects
	/**
	 * @param stage
	 * @param file
	 */
	private void initialize(Stage stage, File file2) {
		scene = new SetDirectoryScene(stage, "	 Now chose the directory to save the image in!...");
		setPane(scene.getPane());
		setLabel(scene.getLabel());
		cancel = scene.getCancel();
		this.file=file2;
		this.directoryChooser = new DirectoryChooser();
		browse = scene.getBrowse();
		handle_browse(browse, stage, file2);
		handle_cancel(cancel);
	}

	/*
	 * Handlers
	 */

	/**
	 * @param cancel2
	 */
	private void handle_cancel(Button cancel2) {
		// Handle the button cancel
		cancel2.setOnAction(e -> {
			Platform.exit();
		});
	}

	/**
	 * @param browse2
	 * @param stage
	 */
	private void handle_browse(Button browse2, Stage stage,File file2) {
		// Handle browsing button
		browse2.setOnAction(e -> {
			this.savingPath = directoryChooser.showDialog(new Stage());
			if (savingPath == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a Directory yet!", "No Directory");
				a.show();
			} else {
				//savingPath= the directory that the user have chosen using the directory choser
				if(createDirectoryImage(file2.getParentFile(),savingPath)== true) {
					@SuppressWarnings("unused")
					ModifyCtrl a = new ModifyCtrl( stage, savingPath, file2);
				}else {
					AlertBoxCtrl a = new AlertBoxCtrl("There was an error of creating the image!", "No Image created");
					a.show();
				}
			}
		});
	}
	/*
	 * In this method I created it to make an image of the directory that teh usr have chosen
	 */
	private boolean createDirectoryImage(File file2 , File savingPath) {
		return ImageCreater.createForensicImage(file2, savingPath);
	}
	
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the fileChooser
	 */
	public DirectoryChooser getFileChooser() {
		return directoryChooser;
	}

	/**
	 * @param fileChooser the fileChooser to set
	 */
	public void setFileChooser(DirectoryChooser directoryChooser) {
		this.directoryChooser = directoryChooser;
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