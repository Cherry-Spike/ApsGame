package model.window;

public class JanelaAp extends CityLastLightWindow {

	public JanelaAp(int posX, int posY) {
		super(38, 41, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaAp.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaApEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
