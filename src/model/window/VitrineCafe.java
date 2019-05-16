package model.window;

public class VitrineCafe extends CityLastLightWindow {

	public VitrineCafe(int posX, int posY) {
		super(114, 47, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/VitrineCafe.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/VitrineCafeEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
