package model;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;

public class CityLastLightBotao extends Button{
	
	@FXML
	Button Pontuacao, Iniciar, Sair;
	
	public final String BotaoPressionado = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloPressionado.png');";
	public final String BotaoSolto = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloSolto.png');";
	public final String BotaoAcionado = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloClaro.png');";
	private final String BotaoPressionadoIni = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoVerdePressionado.png');";
	private final String BotaoSoltoIni = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoVerdeSolto.png');";
	private final String BotaoAcionadoIni = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoVerdeClaro.png');";
	
	public CityLastLightBotao() {
		initialize();
	}
	
	@FXML
	private void SetBotaoPressionado() {
		Pontuacao.setStyle(BotaoPressionado);
	}
	
	@FXML
	private void SetBotaoSolto() {
		Pontuacao.setStyle(BotaoSolto);
	}
	
	@FXML
	private void SetBotaoAcionado() {
		Pontuacao.setStyle(BotaoAcionado);
	}
	
	@FXML
	private void SetBotaoPressionadoSair() {
		Sair.setStyle(BotaoPressionado);
	}
	
	@FXML
	private void SetBotaoSoltoSair() {
		Sair.setStyle(BotaoSolto);
	}
	
	@FXML
	private void SetBotaoAcionadoSair() {
		Sair.setStyle(BotaoAcionado);
	}
	
	@FXML
	private void SetBotaoPressionadoIni() {
		Iniciar.setStyle(BotaoPressionadoIni);
	}
	
	@FXML
	private void SetBotaoSoltoIni() {
		Iniciar.setStyle(BotaoSoltoIni);
	}
	
	@FXML
	private void SetBotaoAcionadoIni() {
		Iniciar.setStyle(BotaoAcionadoIni);
	}	

	public void initialize(){
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoPressionado();
			}			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoSolto();
			}			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoAcionado();
			}	
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoSolto();
			}			
		});
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoPressionadoIni();
			}			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoSoltoIni();
			}			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoAcionadoIni();
			}	
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoSoltoIni();
			}			
		});
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoPressionadoSair();
			}			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					SetBotaoSoltoSair();
			}			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoAcionadoSair();
			}	
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SetBotaoSoltoSair();
			}			
		});
	}
}
