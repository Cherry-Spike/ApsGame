package model.window;

public class JanelaTripla extends CityLastLightWindow {

	public JanelaTripla(int posX, int posY) {
		super(55, 35, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaON.png');";
		WindowLightOff = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaOFF.png');";
		setStyle(WindowLightOn);
	}

}
