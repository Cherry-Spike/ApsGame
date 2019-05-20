package view;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;

public class GameOverSubScene extends SubScene{

	protected final static String BGImage = "view/resources/CityGameOverBg.png";

	public GameOverSubScene() {
		super(new Pane(), 1314, 800);
		prefWidth(1314);
		prefHeight(800);
		
		BackgroundImage Image = new BackgroundImage(new Image(BGImage,1314,800,false,true),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		
		Pane root2 = (Pane) this.getRoot();
		root2.setBackground(new Background(Image));
	}
	
	public Pane getPane() {
		return (Pane) this.getRoot();
	}
}
