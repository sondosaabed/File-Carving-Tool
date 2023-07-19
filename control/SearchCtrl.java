package control;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.SearchBySigniture;
import visualization.SearchScene;

/*
 * Creates a controller for the search Scene 
 * In which it shows a message and sets a title
 */
public class SearchCtrl {
	// Attributes
	private SearchScene scene;
	private Button cancel;
	private Button search;
	private TextField signiture;

	// Constructor
	/**
	 * @param stage
	 * @param directory
	 * @param file
	 */
	public SearchCtrl(Stage stage,  File directory, File file) {
		initialize(stage, directory, file);
	}

	// A method to initialize the scene
	/**
	 * @param stage
	 * @param directory
	 * @param file
	 */
	private void initialize(Stage stage, File directory, File file) {
		setScene(new SearchScene(stage));
		setSigniture(getScene().getSigniture());
		setCancel(getScene().getCancel());
		setSearch(getScene().getSearch());
		
		handle_cancel(cancel, stage, directory, file);
		handle_search(search, directory);
	}

	/*
	 * Handlers
	 */

	/**
	 * @param search2
	 * @param directory
	 */
	private void handle_search(Button search2, File directory) {
		// handle the search 
		search2.setOnAction(e->{
			if( getSigniture().getText().trim().isEmpty()) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't entered a signture!", "No Signiture Entered");
				a.show();
			}else {
				SearchTableViewCtrl scene = new SearchTableViewCtrl(SearchBySigniture.searchBySignature(directory, getSigniture().getText().trim()));
				scene.getStage().show();
			}
		});
	}
	/*
	 * Handle cancel
	 */
	/**
	 * @param cancel2
	 * @param stage
	 * @param directory
	 * @param file
	 */
	private void handle_cancel(Button cancel2, Stage stage, File directory, File file) {
		// Method that handles cancel
		cancel2.setOnAction(e -> {
			@SuppressWarnings("unused")
			HomeCtrl scene = new HomeCtrl(stage, directory, file);
		});
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the scene
	 */
	public SearchScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(SearchScene scene) {
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
	 * @return the signiture
	 */
	public TextField getSigniture() {
		return signiture;
	}

	/**
	 * @param signiture the signiture to set
	 */
	public void setSigniture(TextField signiture) {
		this.signiture = signiture;
	}

	/**
	 * @return the search
	 */
	public Button getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Button search) {
		this.search = search;
	}
}