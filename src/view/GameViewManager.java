package view;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.score.ScoreBars;
import model.button.CityLastLightBotaoVermelho;
import model.label.TimeLabel;
import model.label.EnergyLabel;
import model.label.IntLabel;
import model.label.StringLabel;
import model.score.ClickScore;
import model.window.CityLastLightWindow;
import model.window.Timer;
import model.window.WindowList;

public class GameViewManager {
	
	private ScoreBars enegyscore = new ScoreBars();
	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private GameOverSubScene gameOverSubScene;
	private AnimationTimer gameTimer;
	private List<CityLastLightWindow> WindowList;
	private Pane pane1;
	private Pane pane2;
	private Pane cityBG;
	private Pane menuBG;
	private Pane bottonMenuBG;
	private final int nightSpeed = 70;
	private final int daySpeed = 130;
	private int timerSpeed = daySpeed;	
	public static boolean night = false;	
	public boolean validateDay = true;
	public boolean gameOverStopCall = false;
	private TimeLabel dayCountInfo;
	private EnergyLabel energyScore;
	private IntLabel clickScoreInfo;	
	private StringLabel timeInfo;
	private String daytimeInfo = "Dia";
	private int countDay = 0;
	private static final int WIDTH = 1314;
	private static final int HEIGTH = 790;
	private final String SkyBackground = "view/resources/SkyBG.png";
	private final String CityBackground = "view/resources/GameCity.png";
	private final String SideMenuBackground = "view/resources/fundomenu.png";
	private final String BottonMenuBackground = "view/resources/FundoMenuDeBaixo.png";
	private final String ScoreURL = "model/resources/scorebar/barras.png";
	
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
		SetSideMenuBackground();
		SetBottonMenuBackground();
		CreateWindows();
		InitializeLabels();
		CreateGameLoop();				
	}
	
	private void InitializeLabels() {	
		
		timeInfo = new StringLabel("Horario: ", daytimeInfo, 580, 730, 30);
		gamePane.getChildren().add(timeInfo);
		
		clickScoreInfo = new IntLabel("Luzes Apagadas: ", ClickScore.GetTotalScore(), 990, 734, 25);
		gamePane.getChildren().add(clickScoreInfo);
		
		dayCountInfo = new TimeLabel("Dia: ", countDay, 130, 731, 30);
		gamePane.getChildren().add(dayCountInfo);	
		
		energyScore = new EnergyLabel("Pontos de Energia: ", 760, 40, 30);
		gamePane.getChildren().add(energyScore);		
	}
	
	private void UpdateGameLabels() {	
		timeInfo.UpdateLabel(daytimeInfo);
		clickScoreInfo.UpdateLabel();
		dayCountInfo.UpdateLabel(countDay);
		energyScore.UpdateLabel();
	}

	private void CreateWindows() {
		WindowList = new ArrayList<CityLastLightWindow>();
		WindowList list = new WindowList();
		WindowList = list.GetWindowList();

		gamePane.getChildren().addAll(WindowList);
	}

	private void CreateGameLoop() {
		gameTimer = new AnimationTimer() {		
			@Override
			public void handle(long now) {
				MoveSkyBackground();
				WindowTimer();
				TimeCycle();
				UpdateGameLabels();
				SetScoreBars();
				GameStatus();
				DayCount();
			}
		};
		gameTimer.start();
	}
			
	private void GameStatus() {
		if(ScoreBars.GetEnegyPoints() == 0 && gameOverStopCall == false) {
			setGameOverSubScene();
			gameOverStopCall = true;
		}	
	}
	
	public void WindowTimer() {
	
		Timer temp = new Timer(WindowList, timerSpeed);
		temp.TurnOnRandomWindow();
		
	}	
	
	private void SetCityBackground() {
		cityBG = new Pane();
		
		ImageView CityBackgroundImage = new ImageView(CityBackground);
		cityBG.getChildren().add(CityBackgroundImage);
		gamePane.getChildren().add(cityBG);
	}
	
	private void SetSideMenuBackground() {
		bottonMenuBG = new Pane();
		
		ImageView menuBackgroundImage = new ImageView(BottonMenuBackground);
		bottonMenuBG.getChildren().add(menuBackgroundImage);
		bottonMenuBG.setLayoutY(700);
		gamePane.getChildren().add(bottonMenuBG);
		
	}
	
	private void SetBottonMenuBackground() {
		menuBG = new Pane();
		
		ImageView menuBackgroundImage = new ImageView(SideMenuBackground);
		menuBG.getChildren().add(menuBackgroundImage);
		menuBG.setLayoutX(1200);
		gamePane.getChildren().add(menuBG);
		SetMenuBars();
	}
	
	private void SetMenuBars() {
		ImageView scorebars = new ImageView(ScoreURL);
		scorebars.setLayoutX(21);
		scorebars.setLayoutY(179.5);
		menuBG.getChildren().add(scorebars);
		ScoreBars.SetEnergyLevelArray(menuBG);
	}	
	
	private void SetScoreBars() {
		enegyscore.setWindow(WindowList);
		enegyscore.ScoreTimer(menuBG);
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
			daytimeInfo = "Noite";
			night = true;
			timerSpeed = nightSpeed;
		}
		
		if(pane1.getLayoutX() >= 1350 && pane1.getLayoutX() <= 1360 || pane2.getLayoutX() >= 1350 && pane2.getLayoutX() <= 1360) {
			daytimeInfo = "Dia";
			night = false;
			timerSpeed = daySpeed;			
		}
	}
	
	private void DayCount() {
		
		if(night == false && validateDay == true) {
			countDay++;
			validateDay = false;
		}
		if(night == true && validateDay == false) {
			validateDay = true;
		}
	}
	
	private void setGameOverSubScene() {
		gameOverSubScene = new GameOverSubScene();	
		gamePane.getChildren().add(gameOverSubScene);
		createMenuButton();
	}

	private void createMenuButton() {	
		
		CityLastLightBotaoVermelho MenuPrincipal = new CityLastLightBotaoVermelho("Menu Principal");
		MenuPrincipal.setLayoutX(521.5);
		MenuPrincipal.setLayoutY(400);
		gameOverSubScene.getPane().getChildren().add(MenuPrincipal);
		
		MenuPrincipal.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				menuStage.show();
				gameTimer.stop();
				GameReset();
				gameStage.hide();				
			}
		});	
	}
	
	private void GameReset() {
		validateDay = true;
		timerSpeed = daySpeed;
		daytimeInfo = "Dia";
		gameOverStopCall = false;
		night = false;
		countDay = 0;
		ClickScore.ResetScore();
		ScoreBars.ResetPoints();
	}
}
