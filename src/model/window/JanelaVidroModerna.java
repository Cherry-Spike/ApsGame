package model.window;

public class JanelaVidroModerna extends CityLastLightWindow {

	public JanelaVidroModerna(int posX, int posY) {
		super(45, 44, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaVidroModerna.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaVidroModernaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
