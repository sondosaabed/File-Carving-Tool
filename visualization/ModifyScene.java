package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
*	This scene shows the user an alert to let them know if they want to modify the target file after creating the image
* */
public class ModifyScene {
	//Attributes
	private Label message;
	private Button cancel;
	private GridPane pane;
	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public ModifyScene(Stage stage) {
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
		pane.setPadding(new Insets(70));
		pane.setHgap(7);
		pane.setVgap(10);
		pane.setBackground(background);

		Image img = new Image("resources/edit.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(170);
		v.setFitHeight(170);

		Button logo = new Button();
		logo.setPrefSize(170, 170);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label("An image is created successfully! \n "
				+ "You can either modify your target file or keep it as it is"
				+ "\n Click ok when you are done!");
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.BLACK);
		GridPane.setHalignment(message,HPos.CENTER);

		pane.add(message, 0, 1);
		
		//User button to exit
		cancel = new Button("Okay");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane.add(cancel,0,2); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.centerOnScreen();
		stage.setTitle("File modification");		
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Label message) {
		this.message = message;
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
}