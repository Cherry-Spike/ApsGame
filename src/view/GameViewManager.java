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

public class GameViewManager {

	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private AnimationTimer gameTimer;
	private JanelaTripla randomW;
	private List<JanelaTripla> listWindows;
	
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
			gameStage.show();
			this.menuStage.hide();
			CreateWindows();
			CreateGameLoop();
			
		} catch (Exception e) {
			e.getMessage();
		}		
	}
	
	private void CreateWindows() {
		
		JanelaTripla w1, w2, w3, w4, w5, w6, w7, w8, w9, w10;
		
		listWindows = new ArrayList<JanelaTripla>();
		w1 = new JanelaTripla(106,297);
		w2 = new JanelaTripla(106,361);
		w3 = new JanelaTripla(106,425);
		w4 = new JanelaTripla(106,489);
		w5 = new JanelaTripla(106,553);
		w6 = new JanelaTripla(187,297);
		w7 = new JanelaTripla(187,361);
		w8 = new JanelaTripla(187,425);
		w9 = new JanelaTripla(187,489);
		w10 = new JanelaTripla(187,553);		
		listWindows.add(w1);
		listWindows.add(w2);
		listWindows.add(w3);
		listWindows.add(w4);
		listWindows.add(w5);
		listWindows.add(w6);
		listWindows.add(w7);
		listWindows.add(w8);
		listWindows.add(w9);
		listWindows.add(w10);
		gamePane.getChildren().addAll(listWindows);
		gamePane.getChildren().add(w1);
		
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
	
	private void setBackground() {		
		Image backgroundImage = new Image("/view/resources/GameCity.png", 1200,700,false,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		gamePane.setBackground(new Background(background));		
	}
}
