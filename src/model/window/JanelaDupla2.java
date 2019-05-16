package model.window;

public class JanelaDupla2 extends CityLastLightWindow {

	public JanelaDupla2(int posX, int posY) {
		super(52, 39, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaDupla2.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaDupla2Entered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
