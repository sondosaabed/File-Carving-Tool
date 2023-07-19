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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import model.FragmentMatchInfo;
/*
 * This is the scene that shows the table view scene in which the Fragmnet Match info is shown
 */
public class HashMatchTableViewScene {
	// Fields 
	private Stage stage;
	private Button cancel;
	private Button reconstruct;
	private Button report;
	private ObservableList<FragmentMatchInfo> fragmentMatchData;

	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public HashMatchTableViewScene(ArrayList<File> originalFileFragments,ArrayList<File> searchResultFileFragments) {
		initialize(originalFileFragments, searchResultFileFragments);
	}
	/*
	 * Initializer
	 */
	/**
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	private void initialize(ArrayList<File> originalFileFragments,ArrayList<File> searchResultFileFragments) {
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

		Label ms = new Label("Hash-Based Search Results!");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);
		
		
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(15);
		pane2.setVgap(15);
		pane2.setBackground(background);
		pane.add(pane2, 0, 3);

		if(originalFileFragments.size()==0) {
			/*
			 * No files were found
			 */
			Label no = new Label("Was not able to fragment!");
			no.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
			no.setTextFill(Color.DARKRED);
			pane.add(no, 0, 2);
		}else {
			
			/*
			 * Create a table of the dound tables
			 */
			
	        TableView<FragmentMatchInfo> tableView = new TableView<>();
	        TableColumn<FragmentMatchInfo, Integer> fragmentNumberCol = new TableColumn<>("Fragment #");
	        fragmentNumberCol.setCellValueFactory(new PropertyValueFactory<>("fragmentNumber"));

	        TableColumn<FragmentMatchInfo, String> originalFileHashCol = new TableColumn<>("Original File Hash");
	        originalFileHashCol.setCellValueFactory(new PropertyValueFactory<>("originalFileHash"));

	        TableColumn<FragmentMatchInfo, String> searchResultFileHashCol = new TableColumn<>("Search Result File Hash");
	        searchResultFileHashCol.setCellValueFactory(new PropertyValueFactory<>("searchResultFileHash"));

	        TableColumn<FragmentMatchInfo, Boolean> matchCol = new TableColumn<>("Match");
	        matchCol.setCellValueFactory(new PropertyValueFactory<>("match"));

	        
	        tableView.getColumns().addAll(fragmentNumberCol, originalFileHashCol, searchResultFileHashCol, matchCol);

	        // Create the fragment match data list
	        fragmentMatchData = FXCollections.observableArrayList();

	        // Iterate through the original file fragments
	        for (int i = 0; i < originalFileFragments.size(); i++) {
	            File originalFragmentFile = originalFileFragments.get(i);
	            String originalFileHash = CalculateCompareHash.calculateHash(originalFragmentFile);

	            // Iterate through the search result file fragments
	            for (int j = 0; j < searchResultFileFragments.size(); j++) {
	                File searchResultFragmentFile = searchResultFileFragments.get(j);
	                String searchResultFileHash = CalculateCompareHash.calculateHash(searchResultFragmentFile);

	                // Compare the hash values of the fragments
	                boolean match = originalFileHash.equals(searchResultFileHash);

	                // Create the fragment match info and add it to the data list
	               FragmentMatchInfo fragmentMatchInfo = new FragmentMatchInfo(i + 1, originalFileHash.substring(0, 18), searchResultFileHash.substring(0, 18), match);
	               fragmentMatchData.add(fragmentMatchInfo);
	            }
	        }
	        
	        matchCol.setCellFactory(column -> {
	            return new TableCell<FragmentMatchInfo, Boolean>() {
	                @Override
	                protected void updateItem(Boolean match, boolean empty) {
	                    super.updateItem(match, empty);

	                    if (match == null || empty) {
	                        setText(null);
	                        setStyle("");
	                    } else {
	                        if (match) {
	                            setText("Match");
	                            setTextFill(Color.GREEN);
	                        } else {
	                            setText("Not Matched");
	                            setTextFill(Color.RED);
	                        }
	                    }
	                }
	            };
	        });

			tableView.setItems(fragmentMatchData);

			tableView.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Lucida Sans Unicode';");
			tableView.setPadding(new Insets(10));
			tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
			
			tableView.setCenterShape(true);
			tableView.setPrefWidth(700);
			pane.add(tableView, 0, 2);
			
			// User button to store the stage
			reconstruct = new Button("File Reconstruction");
			reconstruct.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
			reconstruct.setPrefSize(200, 20);
			reconstruct.setTextFill(Color.valueOf("#385F82"));
			GridPane.setHalignment(reconstruct, HPos.CENTER);
			reconstruct.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
			pane2.add(reconstruct, 0, 0);
			
			// User button to store the stage
			report = new Button("Download Report");
			report.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
			report.setPrefSize(200, 20);
			report.setTextFill(Color.valueOf("#385F82"));
			GridPane.setHalignment(report, HPos.CENTER);
			report.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
			pane2.add(report, 1, 0);
		}

		// User button to cancel the stage
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		cancel.setPrefSize(100, 20);
		cancel.setTextFill(Color.valueOf("#385F82"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane2.add(cancel, 2, 0);

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
	 * @return the reconstruct
	 */
	public Button getReconstruct() {
		return reconstruct;
	}
	/**
	 * @param reconstruct the reconstruct to set
	 */
	public void setReconstruct(Button reconstruct) {
		this.reconstruct = reconstruct;
	}
	/**
	 * @return the report
	 */
	public Button getReport() {
		return report;
	}
	/**
	 * @param report the report to set
	 */
	public void setReport(Button report) {
		this.report = report;
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
	 * @return the fragmentMatchData
	 */
	public ObservableList<FragmentMatchInfo> getFragmentMatchData() {
		return fragmentMatchData;
	}
	/**
	 * @param fragmentMatchData the fragmentMatchData to set
	 */
	public void setFragmentMatchData(ObservableList<FragmentMatchInfo> fragmentMatchData) {
		this.fragmentMatchData = fragmentMatchData;
	}
}