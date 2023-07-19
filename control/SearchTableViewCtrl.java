/**
 * 
 */
package control;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.SearchTableViewScene;

/**
 * Here I create a class for controling the table Scene that returns the search
 * results
 */
public class SearchTableViewCtrl {
	// Feilds
	private SearchTableViewScene scene;
	private Stage stage;
	private Button cancel;
	private Button store;

	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public SearchTableViewCtrl(ArrayList<File> list) {
		initialize(list);
	}

	/*
	 * Initializer
	 */
	/**
	 * @param list
	 */
	private void initialize(ArrayList<File> list) {
		setScene(new SearchTableViewScene(list));
		setCancel(getScene().getCancel());
		setStage(getScene().getStage());
		if (getScene().getStore() != null) {
			setStore(getScene().getStore());
			handle_store(getStore(), list);
		}
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

	/**
	 * @param store
	 */
	private void handle_store(Button store, ArrayList<File> list) {
		store.setOnAction(e -> {
			@SuppressWarnings("unused")
			SetSearchResultsDirectoryCtrl scene = new SetSearchResultsDirectoryCtrl(new Stage(), list);
		});
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the scene
	 */
	public SearchTableViewScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(SearchTableViewScene scene) {
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
	 * @return the store
	 */
	public Button getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Button store) {
		this.store = store;
	}
}