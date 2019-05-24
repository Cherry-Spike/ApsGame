package model.score;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.window.CityLastLightWindow;

public class ScoreBars {
	private static double energypoints = 100; 
	private static double happinesspoints = 99; 
	private List <CityLastLightWindow> listwindow ;
	private int cont = 0;
	private static double Acumulator = 0.2;
	private int scoreTimer = 3;
	private int scoreCont = 0;
	private boolean increanse = true;
	private static final String EnergyURL = "model/resources/scorebar/energia.png";
	private static final String HappinessURL = "model/resources/scorebar/felicidade.png";
	private static ImageView[] Epoints = new ImageView[100];
	private static ImageView[] Hpoints = new ImageView[100];
	private static double LevelPositionY = 514.5;	
	
	
	public void setWindow(List<CityLastLightWindow> list) {
		 listwindow = list;
	}	
	
	public  void ConsumeEnergyPoints(List<CityLastLightWindow> listwindow) {
		this.listwindow = listwindow;
			
		for(int i = 0 ; i < listwindow.size() ; i++) {
			if(listwindow.get(i).GetlightON() == true){
				cont++;
			}					
		}	
		
		if(cont > 4) {					
			energypoints -= Acumulator;// consumo de energia por x janela
			increanse = false;
			if(cont >= 8 && cont < 14) {
				Acumulator = 0.2;
				Acumulator += 0.05;
			}else if(cont >= 14 && cont < 18) {
				Acumulator = 0.25;
				Acumulator += 0.1;
			}
			else if(cont >= 18 && cont < 22) {
				Acumulator = 0.35;
				Acumulator += 0.15;
			}
			else if(cont >= 22 && cont < 25) {
				Acumulator = 0.5;
				Acumulator += 0.15;
			}
			else if(cont >= 25) {
				Acumulator = 0.65;
				Acumulator += 0.15;
			}else {
				Acumulator = 0.2;
			}
		}else {
			energypoints -= 0;
			increanse = true;
		}			
		cont = 0;
		
	}
				
	public void AccumulateEnergyPoints(){
		
		if(energypoints <= 100 && energypoints >= 0) {
		energypoints += 0.125;
		}
		if(energypoints > 100){
		energypoints = 100;
		}
		if(energypoints < 0) {
		energypoints = 0;
		}
	}
	
	public void AccumulateHappinessPoints(){
		
		if(happinesspoints < 100 && happinesspoints >= 0) {
			happinesspoints += 0.032;
			Hpoints[(int)happinesspoints].setVisible(true);
			for(int i=0; i < happinesspoints; i++) {
				Hpoints[i].setVisible(true);			
			}			
		}
		if(happinesspoints > 99){
			happinesspoints = 99;
		}
		if(happinesspoints < 0) {
			happinesspoints = 0;
		}
	
	}
	
	public static void AddNewEnergyPoint(){
		if(Acumulator > 0.215) {
			energypoints++;
		}
		energypoints += 0.5;
	}
	
	public static void RemoveHappinessPoint(){
		
		if(happinesspoints < 100 && happinesspoints > 0) {
			if(Hpoints[(int)happinesspoints].isVisible() == true) {
			Hpoints[(int)happinesspoints].setVisible(false);
			happinesspoints -= 1;
			}
		}	
	}
	
	public void EnergyLevel() {
		
		if(energypoints < 100 && increanse == false) {			
			Epoints[(int)energypoints].setVisible(false);
			for(int i=0; i > energypoints; i++) {
				Epoints[i].setVisible(false);
			}			
		}else if(energypoints < 100 && increanse == true) {			
			Epoints[(int)energypoints].setVisible(true);
			for(int i=0; i < energypoints; i++) {
				Epoints[i].setVisible(true);				
			}			
		}		
	}
	
	public void ScoreTimer(Pane menuBG){
	
		if(scoreCont > scoreTimer) {
			ConsumeEnergyPoints(listwindow);
			AccumulateEnergyPoints();
			AccumulateHappinessPoints();
			EnergyLevel();
			scoreCont = 0;
		}
		scoreCont++;
	}
	
	public static double GetEnergyPoints() {
		return energypoints;
	}
	
	public static double GetHappinessPoints() {
		return happinesspoints;
	}
	
	public static void ResetPoints() {
		energypoints = 100;
		happinesspoints = 99;
	}
	
	public static void SetEnergyLevelArray(Pane menuBG) {
		
		for(int i = 0 ; i < 100; i++) {
			Epoints[i] = new ImageView(EnergyURL);
			Epoints[i].setLayoutX(78);
			Epoints[i].setLayoutY(LevelPositionY);
			menuBG.getChildren().add(Epoints[i]);
			LevelPositionY -= 3;
		}	
		
		LevelPositionY = 514.5;
		
		for(int i = 0 ; i < 100; i++) {
			Hpoints[i] = new ImageView(HappinessURL);
			Hpoints[i].setLayoutX(32);
			Hpoints[i].setLayoutY(LevelPositionY);
			menuBG.getChildren().add(Hpoints[i]);
			LevelPositionY -= 3;
		}
		
		LevelPositionY = 514.5;
	}	
	
}
