package view;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.CityLastLightBotao;
import model.CityLastLightBotaoVerde;

public class PontuacaoSubScene extends SubScene {

	protected final static String BGImage = "view/resources/PlacaBg.png";

	public PontuacaoSubScene() {
		super(new Pane(), 726, 637);
		prefWidth(736);
		prefHeight(637);
		
		BackgroundImage Image = new BackgroundImage(new Image(BGImage,736,637,false,true),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		
		Pane root2 = (Pane) this.getRoot();
		root2.setBackground(new Background(Image));
		
		setLayoutX(250);
		setLayoutY(700);
	}
	
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		transition.setToY(-637);
		
		transition.play();
	}
	
	public Pane getPane() {
		return (Pane) this.getRoot();
	}
}
