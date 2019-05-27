package model.button;

import javafx.scene.paint.Color;

public class CityLastLightBotaoVerde extends CityLastLightBotao {
		
		public CityLastLightBotaoVerde(String text) {		
			super(text);	
			SetButtonColor();
			BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoVerdePressionado.png');";
			BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoVerdeSolto.png');";
			BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoVerdeClaro.png');";
			setStyle(BotaoSolto);
		}
		
		public void SetButtonColor() {
			setTextFill(Color.WHITE);
		}
				
}
