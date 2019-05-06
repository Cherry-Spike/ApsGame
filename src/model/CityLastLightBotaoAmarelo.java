package model;

public class CityLastLightBotaoAmarelo extends CityLastLightBotao {
	
	public CityLastLightBotaoAmarelo(String text) {
		super(text);
		BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BotaoAmareloPressionado.png');";
		BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BotaoAmareloSolto.png');";
		BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BotaoAmareloClaro.png');";
		setStyle(BotaoSolto);
	}
}
