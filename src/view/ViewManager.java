package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManager {
	
	private static final int WIDTH = 800;
	private static final int HEIGTH = 600;
	private Pane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public ViewManager() throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("SB_Tela.fxml"));
		mainScene = new Scene(mainPane,WIDTH,HEIGTH);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public void SetNewScene(VBox layout) {
		Scene newScene = new Scene(layout,WIDTH,HEIGTH);
		mainStage.setScene(newScene);
	}
	
}
