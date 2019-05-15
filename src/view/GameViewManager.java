package view;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.score.Score;
import model.window.CityLastLightWindow;
import model.window.Timer;
import model.window.WindowList;

public class GameViewManager {

	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private List<CityLastLightWindow> WindowList;
	private Pane pane1;
	private Pane pane2;
	private Pane city;
	private Label txtScore;
	private static final int WIDTH = 1190;
	private static final int HEIGTH = 690;
	private static final String SkyBackground = "view/resources/SkyBG.png";
	private static final String CityBackground = "view/resources/GameCity.png";
	
	
	public GameViewManager() {
		InitializeStage();
	}

	private void InitializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, WIDTH, HEIGTH);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setTitle("City Last Light!");
		gameStage.setResizable(false);
	}
	
	public void CreateNewGame(Stage menuStage) {
			this.menuStage = menuStage;
			this.menuStage.hide();
			gameStage.show();
			SetSkyBackground();
			SetCityBackground();
			CreateWindows();
			txtScore = new Label();
			gamePane.getChildren().add(txtScore);
			CreateGameLoop();			
	}
	private void SetScorePanel() {
		txtScore.setText("Score Test : " + Score.GetTotalScore());
		txtScore.setLayoutX(450);
		txtScore.setLayoutY(50);
		txtScore.setFont(new Font(40));
	}

	private void CreateWindows() {
	
		WindowList = new ArrayList<CityLastLightWindow>();
		WindowList list = new WindowList();
		WindowList = list.GetWindowList();

		gamePane.getChildren().addAll(WindowList);
	}

	private void CreateGameLoop() {
		AnimationTimer gameTimer = new AnimationTimer() {		
			@Override
			public void handle(long now) {
				MoveSkyBackground();
				SetScorePanel();
				WindowTimer();
			}
		};
		gameTimer.start();
	}
			
	public void WindowTimer() {
	
		Timer temp = new Timer(WindowList);
		temp.TurnOnRandomWindow();
		
	}	
	
	private void SetSkyBackground() {
		pane1 = new Pane();
		pane2 = new Pane();
		
		ImageView SkyImage1 = new ImageView(SkyBackground);
		ImageView SkyImage2 = new ImageView(SkyBackground);
		pane1.getChildren().add(SkyImage1);
		pane2.getChildren().add(SkyImage2);
		pane1.setLayoutX(-3500);
		pane2.setLayoutX(-11300);
		gamePane.getChildren().addAll(pane1, pane2);
	}
	
	private void SetCityBackground() {
		city = new Pane();
		
		ImageView CityBackgroundImage = new ImageView(CityBackground);
		city.getChildren().add(CityBackgroundImage);
		gamePane.getChildren().add(city);
	}
	
	private void MoveSkyBackground() {
		pane1.setLayoutX(pane1.getLayoutX() + 0.4);
		pane2.setLayoutX(pane2.getLayoutX() + 0.4);
		
		if(pane1.getLayoutX() >= 7800) {
			pane1.setLayoutX(-7800);
		}
		
		if(pane2.getLayoutX() >= 7800) {
			pane2.setLayoutX(-7800);
		}
	}
	
}
