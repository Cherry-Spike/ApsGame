package model;

import javafx.scene.paint.Color;

public class CityLastLightBotaoVerde extends CityLastLightBotao {
		
		public CityLastLightBotaoVerde(String text) {		
			super(text);	
			//SetFont = "-fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; ;";
			SetButtonColor();
			BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoVerdePressionado.png');";
			BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoVerdeSolto.png');";
			BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoVerdeClaro.png');";
			setStyle(BotaoSolto);
		}
		
		public void SetButtonColor() {
			setTextFill(Color.WHITE);
		}
				
}
