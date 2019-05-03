package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.MainGame;

public class Janela extends Button{
	
	protected String JanelaAcesa = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloPressionado.png');";
	protected String JanelaApagada = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloSolto.png');";
	public boolean ativa = true;
	
	public Janela(int x, int y) {
		setPrefWidth(50);
		setPrefHeight(50);
		setLayoutX(x);
		setLayoutY(y);
		setStyle(JanelaAcesa);
		InitializerListeners();
	}
	
	
	public void SetJanelaAcesa() {
		setStyle(JanelaAcesa);
	}
	
	public void SetJanelaApagada() {
		setStyle(JanelaApagada);	
		ativa = false;
	}
	
	private void InitializerListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetJanelaAcesa();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetJanelaApagada();
				}
			}
		});		
	}
}
