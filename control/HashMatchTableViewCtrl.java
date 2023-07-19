/**
 * 
 */
package control;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.FragmentMatchInfo;
import visualization.HashMatchTableViewScene;

/**
 * Here I create a class for controlling the table Scene of the Match and the hash scene
 */
public class HashMatchTableViewCtrl {
	/*
	 *  Feilds
	 */
	private HashMatchTableViewScene scene;
	private Stage stage;
	private Button cancel;
	private Button reconstruct;
	private Button report;

	/*
	 * Constructor
	 */
	/**
	 * @param originalFileFragments
	 * @param searchResultFileFragments
	 */
	public HashMatchTableViewCtrl(ArrayList<File> originalFileFragments,ArrayList<File> searchResultFileFragments) {
		initialize(originalFileFragments, searchResultFileFragments);
	}

	/*
	 * Initializer
	 */
	/**
	 * @param originalFileFragments
	 * @param searchResultFileFragments
	 */
	private void initialize(ArrayList<File> originalFileFragments,ArrayList<File> searchResultFileFragments) {
		setScene(new HashMatchTableViewScene(originalFileFragments, searchResultFileFragments));
		setCancel(getScene().getCancel());
		setStage(getScene().getStage());
		setReconstruct(getScene().getReconstruct() );
		setReport(getScene().getReport());
		handle_cancel(getCancel());
		handle_report(getReport(),originalFileFragments,getScene().getFragmentMatchData());
		handle_reconsyruct(getReconstruct(), originalFileFragments, getScene().getFragmentMatchData());
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
	 * Handle report
	 */
	/**
	 * @param report
	 * @param originalFileFragments
	 * @param fragmentMatchData
	 */
	private void handle_report(Button report, ArrayList<File> originalFileFragments, ObservableList<FragmentMatchInfo> fragmentMatchData) {
		report.setOnAction(e -> {
			@SuppressWarnings("unused")
			SetReportDirectoryCtrl scene = new SetReportDirectoryCtrl(new Stage(),originalFileFragments , fragmentMatchData);
		});
	}
	
	/**
	 * @param reconstruct
	 * @param originalFileFragments
	 * @param fragmentMatchData
	 */
	private void handle_reconsyruct(Button reconstruct,ArrayList<File> originalFileFragments, ObservableList<FragmentMatchInfo> fragmentMatchData) {
		reconstruct.setOnAction(e -> {
			@SuppressWarnings("unused")
			SetReonstructedDirectoryCtrl scene = new SetReonstructedDirectoryCtrl(new Stage(), originalFileFragments , fragmentMatchData);
		});
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the scene
	 */
	public HashMatchTableViewScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(HashMatchTableViewScene scene) {
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

	/**
	 * @return the reconstruct
	 */
	public Button getReconstruct() {
		return reconstruct;
	}

	/**
	 * @param reconstruct the reconstruct to set
	 */
	public void setReconstruct(Button reconstruct) {
		this.reconstruct = reconstruct;
	}

	/**
	 * @return the report
	 */
	public Button getReport() {
		return report;
	}

	/**
	 * @param report the report to set
	 */
	public void setReport(Button report) {
		this.report = report;
	}
}