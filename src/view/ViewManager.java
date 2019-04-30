package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import java.io.IOException;
import javafx.stage.Stage;
import model.CityLastLightBotaoAmarelo;
import model.CityLastLightBotaoVerde;
import model.TituloTelaInicial;

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
		setTitle();
		setBackground();
	}	
	
	public Stage getMainStage() {
		return mainStage;
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
	
	private void setTitle() {
		TituloTelaInicial Titulo = new TituloTelaInicial("City Last Light");
		Titulo.setLayoutX(370);
		Titulo.setLayoutY(40);
		mainPane.getChildren().add(Titulo);
	}

	private void setBackground() {
		Image backgroundImage = new Image("/view/resources/CityBG.png", 1200,700,false,true); //Background Provisorio!!!;
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	
	
}
