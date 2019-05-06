package view;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
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
		setBackground();
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
	
	private void setBackground() {		
		Image backgroundImage = new Image("/view/resources/GameCity.png", 1200,700,false,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		gamePane.setBackground(new Background(background));		
	}
}
