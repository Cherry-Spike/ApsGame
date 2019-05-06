package model.window;

public class JanelaTripla extends CityLastLightWindow {

	public JanelaTripla() {
		super(55, 35);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaON.png');";
		WindowLightOff = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/window/JanelaTriplaOFF.png');";
		setStyle(WindowLightOn);
	}

}
