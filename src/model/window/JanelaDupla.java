package model.window;

public class JanelaDupla extends CityLastLightWindow {

	public JanelaDupla(int posX, int posY) {
		super(53, 36, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaDupla.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaDuplaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
