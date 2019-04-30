package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public abstract class CityLastLightBotao extends Button {
	
	//protected String SetFont = "-fx-font: bold italic 20pt \"Arial\";";
	protected String BotaoPressionado;
	protected String BotaoSolto;
	protected String BotaoAcionado;
	
	public CityLastLightBotao(String text) {
		setText(text);
		SetFont();
		setPrefWidth(267);
		setPrefHeight(77);
		setStyle(BotaoSolto);
		InitializerListeners();
	}
	
	public void SetFont() {
		setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
	}
	
	public void SetBotaoPressionado() {
		setStyle(BotaoPressionado);
	}
	
	public void SetBotaoSolto() {
		setStyle(BotaoSolto);		
	}
	
	public void SetBotaoAcionado() {
		setStyle(BotaoAcionado);		
	}
	
	private void InitializerListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetBotaoPressionado();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetBotaoSolto();
				}
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
	}

}
