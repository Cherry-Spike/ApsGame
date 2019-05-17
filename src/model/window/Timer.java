package model.window;

import java.util.List;
import java.util.Random;

public class Timer {
	
	private List<CityLastLightWindow> list;
	private Random rand;
	private int timerSpeed;
	private int[] validador ;
	private int[] pDisponivel;
	private static int counter = 0;
	
	public Timer(List<CityLastLightWindow> list, int timerSpeed) {
		
		this.timerSpeed = timerSpeed;
		this.list = list;
		TurnOnRandomWindow();
		
	}
	
	public void TurnOnRandomWindow() {
		
		validador = new int[list.size()];
		rand = new Random();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).GetlightON() == false) {					
				validador[i] = i; 												
			}else {
				validador[i] = -1;
			}
		}
		
		//temporizador & janelas randomicas
		if(counter > timerSpeed){	
			int posicao=0, r=0, cont=0, cpos=0;
			
			for (int j = 0; j < list.size(); j++) {
				if(validador[j] != -1) {							
					cont++;
				}						
			}
			
			if(cont > 0) {				
				pDisponivel = new int[cont];
				
				for (int j = 0; j < list.size(); j++) {
				if(validador[j] != -1) {							
					pDisponivel[cpos] = validador[j];
					cpos++;
					}
				}			
				posicao = rand.nextInt(pDisponivel.length);
				r = pDisponivel[posicao];
				list.get(r).EnableWindow();
				list.get(r).SetWindowLightOn();
				counter = 0;		
			}									
		}	
		counter++;			
	}

}
