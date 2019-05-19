package model.score;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.window.CityLastLightWindow;

public  class EnergyScore {
	private static double energypoints = 100; 
	private List <CityLastLightWindow> listwindow ;
	private int cont = 0;
	private double Acumulator = 0.2;
	private int scoreTimer = 5;
	private int scoreCont = 0; 
	private static final String EnergyURL = "model/resources/scorebar/energia.png";
	private static ImageView[] points = new ImageView[100];
	private static double energyPositionY = 514.5;
	
	public  EnergyScore(){
		//AccumulateEnergyPoints();
		//ConsumeEnergyPoints();
	}
	
	
	public  void ConsumeEnergyPoints(List <CityLastLightWindow> listwindow) {
		this.listwindow = listwindow;
			
		for(int i = 0 ; i < listwindow.size() ; i++) {
			if(listwindow.get(i).GetlightON() == true){
				cont++;
			}					
		}
		
		if(cont > 4) {					
			energypoints -= Acumulator;// consumo de energia por janela 
			if(cont >= 8) {
				Acumulator += 0.003;
			}else if(cont >= 14) {
				Acumulator += 0.003;
			}
			else if(cont >= 18) {
				Acumulator += 0.003;
			}
			else if(cont >= 22) {
				Acumulator += 0.003;
			}
			else if(cont >= 26) {
				Acumulator += 0.003;
			}else {
				Acumulator = 0.1;
			}
		}else {
			energypoints -= 0;
		}
				
		cont = 0;
	}
				
	public  void AccumulateEnergyPoints(){
		
		if(energypoints <= 100 && energypoints >= 0) {
		energypoints += 0.1;
		}
		if(energypoints > 100){
		energypoints = 100;
		}
		if(energypoints < 0) {
		energypoints = 0;
		}
	}
	public void setWindow(List <CityLastLightWindow> x) {
		 listwindow = x;
	}
	public void ScoreTimer(Pane menuBG){
	
		if(scoreCont > scoreTimer) {
			ConsumeEnergyPoints(listwindow);
			AccumulateEnergyPoints();
			if(energypoints < 100) {
				menuBG.getChildren().remove(points[(int)energypoints]);
			}
			scoreCont = 0;
		}
		scoreCont++;
	}
	
	public static double GetEnegyPoints() {
		return energypoints;
	}	
	
	public static void EnergyLevel(Pane menuBG) {
		
		for(int i = 0 ; i < 100; i++) {
			points[i] = new ImageView(EnergyURL);
			points[i].setLayoutX(66);
			points[i].setLayoutY(energyPositionY);
			menuBG.getChildren().add(points[i]);
			energyPositionY -= 3;
		}
		
		energyPositionY = 514.5;
	}
	
}
