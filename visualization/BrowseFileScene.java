package visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;

/*
 * In this class I have created the first scene which asks the user to chose a file
 * 
 */
public class BrowseFileScene {
	//fields
    private GridPane pane;
    private Label label;//Greeting User
    private Button browse;//User Button to browse file
	private Button cancel;
  		
    //Constructor accepts a stage
	/**
	 * @param stage
	 */
	public BrowseFileScene(Stage stage) {
      initialize(stage);
    }
	
    //initialization of objects
    /**
     * @param stage
     */
    public void initialize(Stage stage) {
    	//Creating the grid pane
    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 150,100,150));
		pane.setHgap(60);
		pane.setVgap(20);
		
		Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
		pane.setBackground(bGround); 
		
		//The logo image
		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(150);
		v.setFitHeight(150);
		
		// a disabled button that shows the Logo
		Button logo = new Button();
		logo.setPrefSize(150, 150);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo, 0, 0);
		
		//Greeting Label
		label = new Label("   Hello User! Chose your target file...");
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 1,0);

		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(20);
		pane2.setVgap(20);
		pane2.setBackground(bGround);
		pane.add(pane2, 1, 1);
		
		//Button to browse for files
		browse = new Button("Browse"); 
		browse.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#DDEDE5;");
		browse.setTextFill(Color.valueOf("#385F82"));
		browse.setPrefSize(100, 30);
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane2.add(browse , 0,0);
		
		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#DDEDE5;");
		cancel.setTextFill(Color.valueOf("#385F82"));
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane2.add(cancel,1,0); 
		
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Browse for the file");
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.centerOnScreen();
		stage.show();
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