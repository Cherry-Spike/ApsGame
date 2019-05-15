package model.window;

public class JanelaTripla extends CityLastLightWindow {

	public JanelaTripla(int posX, int posY) {
		super(61, 41, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaON.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
		setStyle(WindowLightOn);
	}
}
