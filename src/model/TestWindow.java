package model;

public class TestWindow extends Window {

	public TestWindow() {
		super(50, 50);
		WindowLightOn = "-fx-background-size: 50 50; -fx-background-image: url('Model/resources/Window/WindowON.png');";
		WindowLightOff = "-fx-background-size: 50 50; -fx-background-image: url('Model/resources/Window/WindowOff.png');";
		setStyle(WindowLightOn);
	}

}
