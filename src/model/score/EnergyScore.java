package model.score;

import java.util.List;

import model.window.CityLastLightWindow;
import model.window.WindowList;

public  class EnergyScore {
	private static double energypoints = 100; 
	private List <CityLastLightWindow> listwindow ;
	private int cont = 0;
	private int timerAc = 0;
	private int scoreTimer = 40;
	private int scoreCont = 0; 
	
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
					if(cont > 4) {
						energypoints -= 2;// consumo de energia por janela 
						if(cont  == cont+2) {
							timerAc -= 2;
							scoreTimer -= timerAc;
							
						}
					}
					
				}
			
			}
			
		
	
	
	public  void AccumulateEnergyPoints(){
		
			if(energypoints <= 100 && energypoints >= 0) {
			energypoints += 1;
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
	public void ScoreTimer(){
		if(scoreCont > scoreTimer) {
			ConsumeEnergyPoints(listwindow);
			AccumulateEnergyPoints();
			scoreCont = 0;
		}
		scoreCont++;
	}
	
	public static double GetEnegyPoints() {
		return energypoints;
	}	
	
	
}
