package view;

import javafx.animation.FadeTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameOverSubScene extends SubScene{

	protected final static String BGImage = "view/resources/CityGameOverBg.png";

	public GameOverSubScene() {
		super(new Pane(), 1324, 800);
		prefWidth(1324);
		prefHeight(800);
		setOpacity(0);
		
		BackgroundImage Image = new BackgroundImage(new Image(BGImage,1324,800,false,true),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		
		FadeTransition FadeIn = new FadeTransition(Duration.millis(2000), this);
		FadeIn.setFromValue(0.0);
		FadeIn.setToValue(1.0);
		FadeIn.play();
	
		Pane root2 = (Pane) this.getRoot();
		root2.setBackground(new Background(Image));
	}
	
	public Pane getPane() {
		return (Pane) this.getRoot();
	}
}
