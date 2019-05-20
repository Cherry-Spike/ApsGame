package model.button;

import javafx.scene.paint.Color;

public class CityLastLightBotaoVermelho extends CityLastLightBotao {
		
		public CityLastLightBotaoVermelho(String text) {		
			super(text);	
			SetButtonColor();
			BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/button/BotaoVermelhoPressionado.png');";
			BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/button/BotaoVermelhoSolto.png');";
			BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/button/BotaoVermelhoClaro.png');";
			setStyle(BotaoSolto);
		}
		
		public void SetButtonColor() {
			setTextFill(Color.WHITE);
		}
				
}
