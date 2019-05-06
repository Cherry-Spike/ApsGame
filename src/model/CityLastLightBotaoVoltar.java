package model;

public class CityLastLightBotaoVoltar extends CityLastLightBotao {

	public CityLastLightBotaoVoltar(String text) {
		super(text);
		BotaoPressionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BackButton.png');";
		BotaoSolto = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BackButton.png');";
		BotaoAcionado = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Button/BackButtonActive.png');";
		setPrefWidth(67);
		setPrefHeight(63);
		setStyle(BotaoSolto);
		
	}
}
