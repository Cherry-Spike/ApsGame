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
import model.CityLastLightBotao;
import model.CityLastLightBotaoAmarelo;
import model.CityLastLightBotaoVerde;
import model.TituloTelaInicial;

public class ViewManager {
	
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	private static final int Botao_PosicaoX = 468;
	private static final int Botao_PosicaoY = 240;
	private static int PositionCount = 0;	
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
	
	public void setNovoBotao(CityLastLightBotao botao) {
		botao.setLayoutX(Botao_PosicaoX);
		PositionCount += 1;
		botao.setLayoutY(Botao_PosicaoY + 100*PositionCount);
	}
		
	private void createButtons() {
		
		CityLastLightBotaoVerde Iniciar = new CityLastLightBotaoVerde("Iniciar");
		setNovoBotao(Iniciar);
		
		CityLastLightBotaoAmarelo Pontuacao = new CityLastLightBotaoAmarelo("Pontuação");
		setNovoBotao(Pontuacao);
		
		CityLastLightBotaoAmarelo Sair = new CityLastLightBotaoAmarelo("Sair");
		setNovoBotao(Sair);
		
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
