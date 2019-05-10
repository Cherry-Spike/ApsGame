package model.window;

public class TestWindow extends CityLastLightWindow {

	public TestWindow(int posX, int posY) {
		super(50, 50, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-size: 50 50; -fx-background-image: url('Model/resources/WindowON.png');";
		WindowLightOff = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-size: 50 50; -fx-background-image: url('Model/resources/WindowOff.png');";
		setStyle(WindowLightOn);
	}

}
