package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import model.Janela;

public class MainGame{
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	private Pane newPane;
	private Scene newScene;
	private Janela janela;
	
	public Scene SetMainGameScene() {
		newPane = new Pane();
		newScene = new Scene(newPane,WIDTH,HEIGTH);
		newPane.getChildren().add(SetJanelas());
        return newScene;
	}
	
	public Janela SetJanelas() {		
			janela = new Janela();
			return janela;
	}
}

