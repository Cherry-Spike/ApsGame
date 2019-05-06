package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import java.io.IOException;
import javafx.stage.Stage;
import model.TituloTelaInicial;
import model.button.CityLastLightBotao;
import model.button.CityLastLightBotaoAmarelo;
import model.button.CityLastLightBotaoVerde;
import model.button.CityLastLightBotaoVoltar;

public class ViewManager {
	
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	private static final int Botao_PosicaoX = 468;
	private static final int Botao_PosicaoY = 240;
	private static int PositionCount = 0;	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;	
	
	private PontuacaoSubScene pontuacaoSubScene;
	
	public ViewManager() throws IOException {
		mainPane = new AnchorPane();
		//mainPane = FXMLLoader.load(getClass().getResource("/model/SB_TelaInicial.fxml"));
		mainScene = new Scene(mainPane,WIDTH,HEIGTH);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		
		setMenu();
		setTitle();
		setBackground();
		setSubScene();
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	//Menu & Botoes
	public void setNovoBotao(CityLastLightBotao botao) {
		
		botao.setLayoutX(Botao_PosicaoX);
		PositionCount += 1;
		botao.setLayoutY(Botao_PosicaoY + 100*PositionCount);
		mainPane.getChildren().add(botao);
		
	}
	
	private void setMenu() {					
		createBotaoIniciar();		
		createBotaoPontuacao();		
		createBotaoSair();			
	}
	
	private void createBotaoIniciar() {		
		CityLastLightBotaoVerde Iniciar = new CityLastLightBotaoVerde("Iniciar");
		setNovoBotao(Iniciar);
		Iniciar.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
					GameViewManager gameManeger = new GameViewManager();
					gameManeger.CreateNewGame(mainStage);
				}
		});
	}
	
	private void createBotaoPontuacao() {		
		CityLastLightBotaoAmarelo Pontuacao = new CityLastLightBotaoAmarelo("Pontuação");
		setNovoBotao(Pontuacao);
		
		Pontuacao.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {pontuacaoSubScene.moveSubScene();}
		});
	}
	
	private void createBotaoSair() {	
		CityLastLightBotaoAmarelo Sair = new CityLastLightBotaoAmarelo("Sair");
		setNovoBotao(Sair);
		Sair.setOnAction(actionEvent -> Platform.exit());		
	}
	
	private void createBotaoVoltar() {
		CityLastLightBotaoVoltar Voltar = new CityLastLightBotaoVoltar("");
		Voltar.setLayoutX(90);
		Voltar.setLayoutY(420);
		pontuacaoSubScene.getPane().getChildren().add(Voltar);
		
		Voltar.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {pontuacaoSubScene.closePane();}
		});
	}
	
	//Titulo	
	private void setTitle() {	
		TituloTelaInicial Titulo = new TituloTelaInicial("City Last Light");
		Titulo.setLayoutX(370);
		Titulo.setLayoutY(40);
		mainPane.getChildren().add(Titulo);		
	}
	
	//Background & Scenes
	private void setBackground() {		
		Image backgroundImage = new Image("/view/resources/CityBG.png", 1200,700,false,true); //Background Provisorio!!!;
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));		
	}
	
	private void setSubScene() {
		pontuacaoSubScene = new PontuacaoSubScene();	
		mainPane.getChildren().add(pontuacaoSubScene);
		createBotaoVoltar();
	}
	
}
