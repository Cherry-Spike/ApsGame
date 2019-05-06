package model;

public class JanelaTripla extends Window {

	public JanelaTripla() {
		super(55, 35);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Window/JanelaTriplaON.png');";
		WindowLightOff = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('Model/resources/Window/JanelaTriplaOFF.png');";
		setStyle(WindowLightOn);
	}

}
