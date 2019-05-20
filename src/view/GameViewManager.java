package view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.score.ScoreBars;
import model.button.CityLastLightBotaoVoltar;
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
	private List<CityLastLightWindow> WindowList;
	private Pane pane1;
	private Pane pane2;
	private Pane cityBG;
	private Pane menuBG;
	private Pane bottonMenuBG;
	private Label txtScore;	
	private final int nightSpeed = 70;
	private final int daySpeed = 130;
	private int timerSpeed = daySpeed;	
	public static boolean night = false;	
	private Label timeInfo;
	private Label energyScore;
	private String timeOfDay = "Dia";	
	private static final int WIDTH = 1314;
	private static final int HEIGTH = 790;
	private static final String SkyBackground = "view/resources/SkyBG.png";
	private static final String CityBackground = "view/resources/GameCity.png";
	private static final String SideMenuBackground = "view/resources/fundomenu.png";
	private static final String BottonMenuBackground = "view/resources/FundoMenuDeBaixo.png";
	private static final String ScoreURL = "model/resources/scorebar/barras.png";
	
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
		txtScore = new Label();
		gamePane.getChildren().add(txtScore);
		timeInfo = new Label();
		gamePane.getChildren().add(timeInfo);
		energyScore = new Label();
		gamePane.getChildren().add(energyScore);
		setGameOverSubScene();
		CreateGameLoop();				
	}
	
	private void SetTimeLabel() {
		
		timeInfo.setText("Horario: " + timeOfDay);
		timeInfo.setLayoutX(150);
		timeInfo.setLayoutY(40);
		timeInfo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
		timeInfo.setTextFill(Color.WHITE);		
	}
	
	private void SetScoreLanel() {
		
		txtScore.setText("Luzes Apagadas: " + ClickScore.GetTotalScore());
		txtScore.setLayoutX(400);
		txtScore.setLayoutY(40);
		txtScore.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
		txtScore.setTextFill(Color.WHITE);		
	}
	
	private void SetEnergyScoreLabel() {
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String x = decimalFormat.format(ScoreBars.GetEnegyPoints());
		energyScore.setText("Pontos de Energia: " + x);
		energyScore.setLayoutX(760);
		energyScore.setLayoutY(40);
		energyScore.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
		energyScore.setTextFill(Color.YELLOW);	
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
				SetScoreLanel();
				WindowTimer();
				TimeCycle();
				SetTimeLabel();
				SetEnergyScoreLabel();
				SetScoreBars();
				GameStatus();
			}

		};
		gameTimer.start();
	}
			
	private void GameStatus() {
		if(ScoreBars.GetEnegyPoints() == 0) {
			gameOverSubScene.moveSubScene();
		}
		
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
			night = true;
			timerSpeed = nightSpeed;
		}
		
		if(pane1.getLayoutX() >= 1350 && pane1.getLayoutX() <= 1360 || pane2.getLayoutX() >= 1350 && pane2.getLayoutX() <= 1360) {
			timeOfDay = "Dia";
			night = false;
			timerSpeed = daySpeed;			
		}
	}
	
	private void setGameOverSubScene() {
		gameOverSubScene = new GameOverSubScene();	
		gamePane.getChildren().add(gameOverSubScene);
		createMenuButton();
	}

	private void createMenuButton() {
		CityLastLightBotaoVoltar Voltar = new CityLastLightBotaoVoltar("");
		Voltar.setLayoutX(90);
		Voltar.setLayoutY(420);
		gameOverSubScene.getPane().getChildren().add(Voltar);
		
		Voltar.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {}
		});	
	}
}
