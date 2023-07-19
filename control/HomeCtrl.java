/**
 * 
 */
package control;
import java.io.File;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.HomeScene;

/**
 * I have created this class to control the main scene
 */
public class HomeCtrl {
	//Feilds
	private Button segment;
	private Button search;
	private Button hash;
	private HomeScene scene;
	/*
	 * Constructot
	 */
	/**
	 * @param stage
	 * @param file2 
	 * @param data
	 */
	public HomeCtrl(Stage stage, File directory, File file2) {
		initialize(stage, directory, file2);
	}
	/*
	 * Initializer
	 */
	/**
	 * @param stage
	 * @param file2 
	 * @param data
	 */
	private void initialize(Stage stage, File directory, File file2) {
		setScene(new HomeScene(stage));
		setSearch(getScene().getSerach());
		setSegment(getScene().getSegment());
		setHash(getScene().getHash());
		
		handle_fragmentation(getSegment(), stage, directory, file2);
		handle_serach(getSearch(),stage, directory, file2);
		handle_hash(getHash(),stage, directory, file2);
	}
	/*
	 * Handlers
	 */
	/**
	 * @param search
	 * @param stage
	 */
	/*
	 * This method redirect to the scene to start the hash based search
	 */
	private void handle_hash(Button hash, Stage stage, File directory, File file2) {
		hash.setOnAction(r->{
			@SuppressWarnings("unused")
			/*
			 * Here I want to passs the original file and the image directory
			 */
			HashCtrl scene = new HashCtrl(stage, directory, file2);
		});
	}
	
	/*
	 * This method redirects the user to the search page
	 */
	/**
	 * @param search
	 * @param stage
	 */
	private void handle_serach(Button search, Stage stage, File directory, File file) {
		search.setOnAction(r->{
			@SuppressWarnings("unused")
			SearchCtrl scene = new SearchCtrl(stage, directory, file);
		});
	}
	/*
	 * This method redirects the user to the fragmentation screen where they decide fragmentation
	 */
	/**
	 * @param statics2
	 * @param stage
	 * @param filePath 
	 * @param data
	 */
	private void handle_fragmentation(Button fragmentation, Stage stage,File directory,  File file) {
		fragmentation.setOnAction(e->{
			@SuppressWarnings("unused")
			FragmentationCtrl scene = new FragmentationCtrl(stage, directory, file);
		});
	}

	/*
	 * Getters and Setters
	 */

	/**
	 * @return the segment
	 */
	public Button getSegment() {
		return segment;
	}
	/**
	 * @param segment the segment to set
	 */
	public void setSegment(Button segment) {
		this.segment = segment;
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
	/**
	 * @return the scene
	 */
	public HomeScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(HomeScene scene) {
		this.scene = scene;
	}
	/**
	 * @return the hash
	 */
	public Button getHash() {
		return hash;
	}
	/**
	 * @param hash the hash to set
	 */
	public void setHash(Button hash) {
		this.hash = hash;
	}
}
