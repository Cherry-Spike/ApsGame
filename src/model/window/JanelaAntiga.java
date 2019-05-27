package model.window;

public class JanelaAntiga extends CityLastLightWindow {

	public JanelaAntiga(int posX, int posY) {
		super(27, 37, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaAntiga.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaAntigaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
