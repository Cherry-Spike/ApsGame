package model.button;


public class CityLastLightBotaoAmarelo extends CityLastLightBotao {
	
	public CityLastLightBotaoAmarelo(String text) {
		super(text);
		BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoAmareloPressionado.png')";
		BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoAmareloSolto.png');";
		BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/button/BotaoAmareloClaro.png');";
		setStyle(BotaoSolto);
	}
}
