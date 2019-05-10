package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private TestWindow window, w2, w3, w4, w5, randomW;
	private List<TestWindow> listWindows;
	private JanelaTripla window;
	
	private static int counter = 0;
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
		try {
			this.menuStage = menuStage;
			this.menuStage.hide();
			CreateWindows();
			CreateGameLoop();
			gameStage.show();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	private void CreateWindows() {
		listWindows = new ArrayList<TestWindow>();
		window = new TestWindow(50,70);
		w2 = new TestWindow(50,170);
		w3 = new TestWindow(50,270);
		w4 = new TestWindow(50,370);
		w5 = new TestWindow(50,470);
		listWindows.add(window);
		listWindows.add(w2);
		listWindows.add(w3);
		listWindows.add(w4);
		listWindows.add(w5);
		gamePane.getChildren().addAll(listWindows);
		window = new JanelaTripla();
		gamePane.getChildren().add(window);
	}

	private void CreateGameLoop() {
		gameTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				RandomWindows();
			}
		};
		gameTimer.start();
	}	
	
	private void setBackground() {		
		Image backgroundImage = new Image("/view/resources/GameCity.png", 1200,700,false,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		gamePane.setBackground(new Background(background));		
	}

	protected void RandomWindows() {
		
		for (int i = 0; i < listWindows.size(); i++) {
			if(listWindows.get(i).GetlightON() == false)
				counter++;
		}

		if(counter == 4){
			Random r = new Random();
			randomW = listWindows.get(r.nextInt(5));
			randomW.SetWindowLightOn();
			counter = 0;
		}
		counter = 0;
	}
}
