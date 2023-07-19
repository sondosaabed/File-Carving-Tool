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
 * In this class I created a fragmentation Scene where the user enters how many fragments they want
 */
public class FragmentationScene {
	// Attributes
	private Button cancel;
	private Button divide;
	private TextField fragments;

	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public FragmentationScene(Stage stage) {
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

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("resources/segmentation.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle(
				"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: #385F82;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);

		Label message = new Label("How many fragments do you want?");
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);

		/*
		 *  Gets the fragments number (user-defined)
		 */
		fragments = new TextField();
		fragments.setPrefHeight(40);
		fragments.setPrefWidth(100);
		fragments.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(fragments, 0, 2);

		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(20);
		pane2.setVgap(20);
		pane2.setBackground(background);
		pane.add(pane2, 0, 3);
		
		// User button to start the fragmentation
		setDivide(new Button("Divide"));
		divide.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		divide.setPrefSize(80, 20);
		divide.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(divide, HPos.CENTER);
		divide.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(divide, 0, 0);

		// User button to go back to the prev scene
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(cancel, 1, 0);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Fragment File");
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
}