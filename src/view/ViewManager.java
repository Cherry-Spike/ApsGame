package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import java.io.IOException;
import javafx.stage.Stage;
import model.button.CityLastLightBotao;
import model.button.CityLastLightBotaoAmarelo;
import model.button.CityLastLightBotaoVerde;
import model.button.CityLastLightBotaoVoltar;

public class ViewManager {
	
	private static final int WIDTH = 1314;
	private static final int HEIGTH = 790;
	private static final double Botao_PosicaoX = 521.5;
	private static final int Botao_PosicaoY = 260;
	private static int PositionCount = 0;	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;	
	
	private PontuacaoSubScene pontuacaoSubScene;
	
	public ViewManager() throws IOException {
		mainPane = new AnchorPane();
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
		final ImageView selectedImage = new ImageView();
		Image Titulo = new Image("/view/resources/TelaInicial3.png", 1200,71,false,true);
		selectedImage.setImage(Titulo);
		selectedImage.setLayoutX(70);
		selectedImage.setLayoutY(135);
		mainPane.getChildren().add(selectedImage);		
	}
	
	//Background & Scenes
	private void setBackground() {		
		Image backgroundImage = new Image("/view/resources/CityBG.png", 1314,800,false,true); //Background Provisorio!!!;
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));		
	}
	
	private void setSubScene() {
		pontuacaoSubScene = new PontuacaoSubScene();	
		mainPane.getChildren().add(pontuacaoSubScene);
		createBotaoVoltar();
	}
	
}
