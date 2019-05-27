package model.window;

public class JanelaAntigaPerspectiva extends CityLastLightWindow {

	public JanelaAntigaPerspectiva(int posX, int posY) {
		super(24, 40, posX, posY);
		WindowLightOn = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaAntigaPerspectiva.png');";
		WindowLightActive = "-fx-background-color: transparent; -fx-cursor: hand; -fx-background-image: url('model/resources/window/JanelaAntigaPerspectivaEntered.png');";
		WindowLightOff = "-fx-background-color: transparent;";
	}
}
