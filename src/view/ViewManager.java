package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CityLastLightBotaoAmarelo;
import model.CityLastLightBotaoVerde;
import javafx.fxml.FXML;

public class ViewManager {
	
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	private Pane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public ViewManager() throws IOException {
		mainPane = new AnchorPane();
		//mainPane = FXMLLoader.load(getClass().getResource("/model/SB_TelaInicial.fxml"));
		mainScene = new Scene(mainPane,WIDTH,HEIGTH);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
	}
	
	private void createButtons() {
		CityLastLightBotaoVerde Iniciar = new CityLastLightBotaoVerde("Iniciar");
		Iniciar.setLayoutX(468);
		Iniciar.setLayoutY(340);
		
		CityLastLightBotaoAmarelo Pontuacao = new CityLastLightBotaoAmarelo("Pontuação");
		Pontuacao.setLayoutX(468);
		Pontuacao.setLayoutY(440);
		
		CityLastLightBotaoAmarelo Sair = new CityLastLightBotaoAmarelo("Sair");
		Sair.setLayoutX(468);
		Sair.setLayoutY(540);
						
		mainPane.getChildren().add(Iniciar);
		mainPane.getChildren().add(Pontuacao);
		mainPane.getChildren().add(Sair);
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	public void SetNewScene(VBox layout) {
		Scene newScene = new Scene(layout,WIDTH,HEIGTH);
		mainStage.setScene(newScene);
	}
}
