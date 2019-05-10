package model.window;

public class TestWindow extends CityLastLightWindow {

	public TestWindow() {
		super(50, 50);
		WindowLightOn = "-fx-background-size: 50 50; -fx-background-image: url('Model/resources/windows/WindowON.png');";
		WindowLightOff = "-fx-background-size: 50 50; -fx-background-image: url('Model/resources/windows/WindowOff.png');";
		setStyle(WindowLightOn);
	}

}
