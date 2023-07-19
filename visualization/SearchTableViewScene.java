package visualization;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
 * In this class I create the scene in which each of the search files that have the same signiture attributes will be shown
 */
public class SearchTableViewScene {
	// Fields 
	private Stage stage;
	private Button cancel;
	private Button store;
	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public SearchTableViewScene(ArrayList<File> list) {
		initialize(list);
	}
	/*
	 * Initializer
	 */
	/**
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	private void initialize(ArrayList<File> list) {
		stage = new Stage();
		GridPane pane = new GridPane();
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150, 70, 150));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);

		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 0, 0);

		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);

		Label ms = new Label("Search Results!");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);
		
		
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(15);
		pane2.setVgap(15);
		pane2.setBackground(background);
		pane.add(pane2, 0, 3);

		if(list.size()==0) {
			/*
			 * No files were found
			 */
			Label no = new Label("No files were found with this signiture!");
			no.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
			no.setTextFill(Color.DARKRED);
			pane.add(no, 0, 2);
		}else {
			/*
			 * Create a table of the dound tables
			 */
			
			TableView<File> table = new TableView<>();

			TableColumn<File, String> fileNameCol = new TableColumn<>("File Name");
			fileNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

			TableColumn<File, String> filePathCol = new TableColumn<>("File Path");
			filePathCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAbsolutePath()));

			TableColumn<File, String> lastModifiedCol = new TableColumn<>("Last Modified");
			lastModifiedCol.setCellValueFactory(cellData -> {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String lastModified = dateFormat.format(new Date(cellData.getValue().lastModified()));
			    return new SimpleStringProperty(lastModified);
			});
			
			table.getColumns().addAll(fileNameCol, filePathCol, lastModifiedCol);
			ObservableList<File> data = FXCollections.observableArrayList(list);
			table.setItems(data);

			table.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Lucida Sans Unicode';");
			table.setPadding(new Insets(10));
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
			
			table.setCenterShape(true);
			table.setPrefWidth(1000);
			pane.add(table, 0, 2);
			
			// User button to store the stage
			store = new Button("Sotre Files");
			store.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
			store.setPrefSize(160, 20);
			store.setTextFill(Color.valueOf("#385F82"));
			GridPane.setHalignment(store, HPos.CENTER);
			store.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
			pane2.add(store, 0, 0);
		}

		// User button to cancel the stage
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		cancel.setPrefSize(100, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(cancel, 1, 0);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Search answer");
		stage.getIcons().add(new Image("resources/logo.png"));
	}

	/*
	 * Getters and Setter
	 */
	
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
}