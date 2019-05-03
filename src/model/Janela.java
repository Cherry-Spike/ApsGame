package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Janela extends Button{
	
	protected String JanelaAcesa = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloPressionado.png');";
	protected String JanelaApagada = "-fx-background-color: transparent; -fx-background-image: url('Model/resources/BotaoAmareloSolto.png');";
	
	public Janela() {
		setPrefWidth(267);
		setPrefHeight(77);
		setStyle(JanelaApagada);
		InitializerListeners();
	}
	
	
	public void SetJanelaAcesa() {
		setStyle(JanelaAcesa);
	}
	
	public void SetJanelaApagada() {
		setStyle(JanelaApagada);		
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
