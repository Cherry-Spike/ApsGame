package view;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.window.JanelaTripla;
import model.window.TestWindow;

public class GameViewManager {

	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private AnimationTimer gameTimer;
	private JanelaTripla window;
	
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	
	public GameViewManager() {
		InitializeStage();
		CreateKeyListeners();
	}

	private void CreateKeyListeners() {
		

	}

	private void InitializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, WIDTH, HEIGTH);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
	}
	
	public void CreateNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		CreateWindows();
		CreateGameLoop();
		gameStage.show();
	}
	
	private void CreateWindows() {
		window = new JanelaTripla();
		gamePane.getChildren().add(window);
	}

	private void CreateGameLoop() {
		gameTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				
			}
		};
		gameTimer.start();
	}
}
