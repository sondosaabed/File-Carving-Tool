/**
 * 
 */
package model;

import control.BrowseFileCtrl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 		Sondos Ahmad Aabed
 * 		1190652
 * 
 * 		In this project I implement the process of the file carving, using java and javafx
 * 		the user can chose the directory and the file of which the image is created
 * 
 */
public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		@SuppressWarnings("unused")
		BrowseFileCtrl scene = new BrowseFileCtrl(stage);
	}
}