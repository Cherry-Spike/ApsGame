package model.window;

public class JanelaLoja extends CityLastLightWindow {

	public JanelaLoja(int posX, int posY) {
		super(79, 39, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaLoja.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaLojaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
