package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.score.Score;
import model.window.JanelaTripla;

public class GameViewManager {

	private Scene gameScene;
	private Stage gameStage;
	private AnchorPane gamePane;
	private Stage menuStage;
	private JanelaTripla randomW;
	private static int counter = 0;
	private List<JanelaTripla> listWindows;
	private Pane pane1;
	private Pane pane2;
	private Pane city;
	private Label txtScore;
	private Random rand;
	private static final int WIDTH = 1190;
	private static final int HEIGTH = 690;
	private static final String SkyBackground = "view/resources/SkyBG.png";
	private static final String CityBackground = "view/resources/GameCity.png";
	
	public int[] validador ;
	public int[] pDisponivel;
	
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
		
		//JanelaTripla[] j = new JanelaTripla[9];
		JanelaTripla w1, w2, w3, w4, w5, w6, w7, w8, w9, w10;
		
		listWindows = new ArrayList<JanelaTripla>();
		/*int c = 1;
		for(int i=0; i < 9; i++) {			
			do {
				c = 1;
			}while(i == 5);
			
			if(i < 5) {
				j[i] = new JanelaTripla(106, 233 + 64*c);
			}else {
				j[i] = new JanelaTripla(187, 233 + 64*c);				
			}
			c++;		
			listWindows.add(j[i]);
		}*/
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
	}

	private void CreateGameLoop() {
		AnimationTimer gameTimer = new AnimationTimer() {		
			@Override
			public void handle(long now) {
				MoveSkyBackground();
				SetScorePanel();
				RandomWindows();
			}
		};
		gameTimer.start();
	}
			
	public void RandomWindows() {
	
		validador = new int[listWindows.size()];
		rand = new Random();
		
		for (int i = 0; i < listWindows.size(); i++) {
			if(listWindows.get(i).GetlightON() == false) {					
				validador[i] = i; 												
			}else {
				validador[i] = -1;
			}
		}
		
		//temporizador	
		if(counter > 150){	
			int posicao=0, r=0, cont=0, cpos=0;
			
			//logica para pegar a posicao das janelas apagadas aleatoriamente			
			for (int j = 0; j < listWindows.size(); j++) {
				if(validador[j] != -1) {							
					cont++;
				}						
			}
			
			if(cont > 0) {				
				pDisponivel = new int[cont];
				
				for (int j = 0; j < listWindows.size(); j++) {
				if(validador[j] != -1) {							
					pDisponivel[cpos] = validador[j];
					cpos++;
					}
				}			
				posicao = rand.nextInt(pDisponivel.length);
				r = pDisponivel[posicao];
				randomW = listWindows.get(r);
				randomW.EnableWindow();
				randomW.SetWindowLightOn();
				counter = 0;		
			}									
		}	
		counter++;	
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
