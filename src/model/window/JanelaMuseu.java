package model.window;

public class JanelaMuseu extends CityLastLightWindow {

	public JanelaMuseu(int posX, int posY) {
		super(52, 49, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaMuseu.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaMuseuEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
