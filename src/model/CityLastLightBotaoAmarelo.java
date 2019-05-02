package model;

public class CityLastLightBotaoAmarelo extends CityLastLightBotao {
	
	public CityLastLightBotaoAmarelo(String text) {
		super(text);
		BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoAmareloPressionado.png');";
		BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoAmareloSolto.png');";
		BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/BotaoAmareloClaro.png');";
		setStyle(BotaoSolto);
	}
}
