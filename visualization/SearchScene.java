package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * In this class I created the search scene in which the user enters the Signiture of the file they want
 */
public class SearchScene {
	//Attributes
	private Button cancel;
	private Button search;
	private GridPane pane;
	private TextField signiture;
	
	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public SearchScene(Stage stage) {
		initialize(stage);
	}
	/*
	 * Initialize objects
	 */
	/**
	 * @param stage
	 */
	private void initialize(Stage stage) {
		
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("resources/search.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: #385F82;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		Label message=new Label("Select the files signiture to find:");
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);
		
		
		// Gets the fragments number (user-defined)
		signiture = new TextField();
		signiture.setPrefHeight(40);
		signiture.setPrefWidth(100);
		signiture.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		GridPane.setHalignment(signiture, HPos.CENTER);
		pane.add(signiture, 0, 2);
	
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(20);
		pane2.setVgap(20);
		pane2.setBackground(background);
		pane.add(pane2, 0, 3);
		
		//User button to exit
		search = new Button("Search");
		search.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		search.setPrefSize(80, 20);
		search.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(search,HPos.CENTER);
		search.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(search,0,0); 
		
		//User button to go back to the prev scene
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(cancel,1,0); 

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Serach by Signiture");
		stage.getIcons().add(new Image("resources/logo.png"));
	}
	/*
	 * Getters and Setters
	 */

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
	 * @return the pane
	 */
	public GridPane getPane() {
		return pane;
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

	/**
	 * @param pane the pane to set
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
}