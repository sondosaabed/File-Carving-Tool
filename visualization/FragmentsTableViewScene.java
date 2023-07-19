package visualization;

import java.io.File;
import java.util.ArrayList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;

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
import model.CalculateCompareHash;
import model.FragmentInfo;
/*
 * In this class I create the Scene were the Tbale view of the fragments Information is shown
 */
public class FragmentsTableViewScene {
	// Fields 
	private Stage stage;
	private Button cancel;

	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public FragmentsTableViewScene(ArrayList<File> list) {
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
		logo.setStyle(
				"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);

		Label ms = new Label("Fragmentation Results!");
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
			 * There was a problem with fragmentation
			 */
			Label no = new Label("Was not able to fragment!");
			no.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
			no.setTextFill(Color.DARKRED);
			pane.add(no, 0, 2);
		}else {
			/*
			 *
			 *Create the table of the fragments information
			 */
			
			TableView<FragmentInfo> table = new TableView<>();

			TableColumn<FragmentInfo, Integer> numCol = new TableColumn<>("Fragment #");
			numCol.setCellValueFactory(new PropertyValueFactory<>("fragmentNumber"));

			TableColumn<FragmentInfo, Long> sizeCol = new TableColumn<>("Size in Bytes");
			sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
			
			TableColumn<FragmentInfo, String> hashValueCol = new TableColumn<>("Hash Value");
			
			hashValueCol.setCellValueFactory(cellData -> {
			    String hash = cellData.getValue().getHashValue().substring(0, 32); 
			    return new SimpleStringProperty(hash);
			});

			table.getColumns().addAll(numCol, sizeCol, hashValueCol);
			
			ObservableList<FragmentInfo> fragmentData = FXCollections.observableArrayList();

			for (int i = 0; i < list.size(); i++) {
			    File fragmentFile = list.get(i);
			    long fileSize = fragmentFile.length();
			    String hashValue = CalculateCompareHash.calculateHash(fragmentFile); 

			    FragmentInfo fragmentInfo = new FragmentInfo(i + 1, fileSize, hashValue);
			    fragmentData.add(fragmentInfo);
			}

			table.setItems(fragmentData);

			table.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Lucida Sans Unicode';");
			table.setPadding(new Insets(10));
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
			
			table.setCenterShape(true);
			table.setPrefWidth(700);
			pane.add(table, 0, 2);
		}

		// User button to cancel the stage
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		cancel.setPrefSize(100, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(cancel, 0, 0);

		Scene scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.setTitle("Fragmentation Process");
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.show();
	}

	/*
	 * Getters and Setter
	 */

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