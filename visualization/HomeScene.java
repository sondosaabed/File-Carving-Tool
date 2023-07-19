/**
 * 
 */
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

/**
 * 	 in this class I created the main scene to be the first scene shown 
 * 	where the user decide what they want to search or to fragment or to hash search based
 */
public class HomeScene {
	//Feilds
	private Button serach;
	private Button segment;
	private Button hash;
	private GridPane pane;

	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public HomeScene(Stage stage) {
		initialize(stage);
	}
	/*
	 * this is a method that initialize the scene style and nodes
	 */
	/**
	 * @param stage
	 */
	private void initialize(Stage stage){
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150,70, 150));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);
		
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 1, 0);
		
		Image img1 = new Image("resources/search.png");
		ImageView v1 = new ImageView(img1);
		v1.setFitWidth(190);
		v1.setFitHeight(190);
		
		Image img2 = new Image("resources/segmentation.png");
		ImageView v2 = new ImageView(img2);
		v2.setFitWidth(190);
		v2.setFitHeight(190);
		
		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);
		
		
		Image img3 = new Image("resources/hash.png");
		ImageView v3 = new ImageView(img3);
		v3.setFitWidth(190);
		v3.setFitHeight(190);
		
		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);
		
		Label ms=new Label("Take an action?!");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.BLACK);
		pane1.add(ms, 1, 0);
		
		serach = new Button();
		serach.setPrefSize(200, 200);
		serach.setGraphic(v1);
		serach.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: #35696A;");
		GridPane.setHalignment(serach, HPos.CENTER);
		pane.add(serach, 0, 2);
		
		Label search=new Label("Serach By Signiture?");
		search.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		search.setTextFill(Color.DARKRED);
		GridPane.setHalignment(search, HPos.CENTER);

		pane.add(search, 0, 1);
		
		segment = new Button();
		segment.setPrefSize(200, 200);
		segment.setGraphic(v2);
		segment.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: #35696A;");
		GridPane.setHalignment(segment, HPos.CENTER);
		pane.add(segment, 1, 2);
		
		
		Label segment=new Label("File Fragmentation?");
		segment.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		segment.setTextFill(Color.DARKRED);
		GridPane.setHalignment(segment, HPos.CENTER);
		pane.add(segment, 1, 1);
		
		
		hash = new Button();
		hash.setPrefSize(200, 200);
		hash.setGraphic(v3);
		hash.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: #35696A;");
		GridPane.setHalignment(hash, HPos.CENTER);
		pane.add(hash, 2, 2);
		
		Label hash=new Label("Hash-based Search?");
		hash.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		hash.setTextFill(Color.DARKRED);
		GridPane.setHalignment(hash, HPos.CENTER);
		pane.add(hash, 2, 1);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("File Carving Tool");
	}
	/*
	 * Getters and Setters
	 */

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
	 * @return the serach
	 */
	public Button getSerach() {
		return serach;
	}
	/**
	 * @param serach the serach to set
	 */
	public void setSerach(Button serach) {
		this.serach = serach;
	}
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