package view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.score.EnergyScore;
import model.score.Score;
import model.window.CityLastLightWindow;
import model.window.Timer;
import model.window.WindowList;

public class GameViewManager {
	
	private EnergyScore enegyscore = new EnergyScore();
	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private List<CityLastLightWindow> WindowList;
	private Pane pane1;
	private Pane pane2;
	private Pane cityBG;
	private Label txtScore;	
	private final int nightSpeed = 50;
	private final int daySpeed = 140;
	private int timerSpeed = daySpeed;	
	private Label timeInfo;
	private Label energyScore;
	private String timeOfDay = "Dia";	
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
		timeInfo = new Label();
		gamePane.getChildren().add(timeInfo);
		energyScore = new Label();
		gamePane.getChildren().add(energyScore);
		CreateGameLoop();				
		
	}	
	
	private void SetTimeLabel() {
		
		timeInfo.setText("Horario: " + timeOfDay);
		timeInfo.setLayoutX(150);
		timeInfo.setLayoutY(30);
		timeInfo.setFont(new Font(40));
		timeInfo.setTextFill(Color.GREENYELLOW);		
	}
	
	private void SetScorePanel() {
		
		txtScore.setText("Luzes Apagadas: " + Score.GetTotalScore());
		txtScore.setLayoutX(400);
		txtScore.setLayoutY(30);
		txtScore.setFont(new Font(40));
		txtScore.setTextFill(Color.YELLOW);		
	}
	
	private void SetEnergyScoreLabel() {
		
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String x = decimalFormat.format(EnergyScore.GetEnegyPoints());
		energyScore.setText("Pontos de Energia: " + x);
		energyScore.setLayoutX(750);
		energyScore.setLayoutY(30);
		energyScore.setFont(new Font(40));
		energyScore.setTextFill(Color.RED);	
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
				TimeCycle();
				SetTimeLabel();
				SetEnergyScoreLabel();
				SetScoreBars();
			}
		};
		gameTimer.start();
	}
			
	public void WindowTimer() {
	
		Timer temp = new Timer(WindowList, timerSpeed);
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
		cityBG = new Pane();
		
		ImageView CityBackgroundImage = new ImageView(CityBackground);
		cityBG.getChildren().add(CityBackgroundImage);
		gamePane.getChildren().add(cityBG);
	}
	
	private void MoveSkyBackground() {
		pane1.setLayoutX(pane1.getLayoutX() + 0.5);
		pane2.setLayoutX(pane2.getLayoutX() + 0.5);
				
		if(pane1.getLayoutX() >= 7800) {
			pane1.setLayoutX(-7800);
		}
		
		if(pane2.getLayoutX() >= 7800) {
			pane2.setLayoutX(-7800);
		}
	}
	
	private void TimeCycle() {
		
		if(pane1.getLayoutX() >= -1000 && pane1.getLayoutX() <= -990 || pane2.getLayoutX() >= -1000 && pane2.getLayoutX() <= -990) {
			timeOfDay = "Noite";
			timerSpeed = nightSpeed;
		}
		
		if(pane1.getLayoutX() >= 1350 && pane1.getLayoutX() <= 1360 || pane2.getLayoutX() >= 1350 && pane2.getLayoutX() <= 1360) {
			timeOfDay = "Dia";
			timerSpeed = daySpeed;
		}
	}
	
	private void SetScoreBars() {
		enegyscore.setWindow(WindowList);
		enegyscore.ScoreTimer();
	}
}
