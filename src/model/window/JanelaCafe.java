package model.window;

public class JanelaCafe extends CityLastLightWindow {

	public JanelaCafe(int posX, int posY) {
		super(30, 28, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaCafe.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaCafeEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
