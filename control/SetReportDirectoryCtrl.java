package control;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.FragmentMatchInfo;
import model.ReportGenerate;
import visualization.SetDirectoryScene;

/*
 * This class creates a controller for the browse file scene of the reprot directory
 */
public class SetReportDirectoryCtrl {
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
	 * @param originalFileFragments
	 * @param matchOrNo
	 */
	public SetReportDirectoryCtrl(Stage stage, ArrayList<File> originalFileFragments, ObservableList<FragmentMatchInfo> matchOrNo) {
		initialize(stage, originalFileFragments, matchOrNo);
	}

	// initialize object
	/**
	 * @param stage
	 * @param originalFileFragments
	 * @param matchOrNo
	 */
	private void initialize(Stage stage, ArrayList<File> originalFileFragments, ObservableList<FragmentMatchInfo> matchOrNo) {
		scene = new SetDirectoryScene(stage, "	 chose the directory to generate the report in!...");
		setPane(scene.getPane());
		setLabel(scene.getLabel());
		cancel = scene.getCancel();
		this.fileChooser = new DirectoryChooser();
		browse = scene.getBrowse();
		handle_browse(browse, stage, originalFileFragments, matchOrNo);
		handle_cancel(cancel,stage);
	}

	/*
	 * Handlers
	 */

	/**
	 * @param cancel2
	 */
	private void handle_cancel(Button cancel2,Stage stage) {
		// Handle the button cancel
		cancel2.setOnAction(e -> {
			stage.close();
		});
	}

	/**
	 * @param browse2
	 * @param stage
	 * @param originalFileFragments 
	 * @param matchOrNo 
	 */
	private void handle_browse(Button browse2, Stage stage, ArrayList<File> originalFileFragments, ObservableList<FragmentMatchInfo> matchOrNo) {
		// Handle browsing button
		browse2.setOnAction(e -> {
			this.file = fileChooser.showDialog(new Stage());
			if (file == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a Directory yet!", "No Directory");
				a.show();
			} else {
				ReportGenerate.generateReport(file, originalFileFragments, matchOrNo);
				DownloadReportResultCtrl scene = new DownloadReportResultCtrl("Report was generated successfully!","report download");
				scene.getScene().getWindow().show();
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