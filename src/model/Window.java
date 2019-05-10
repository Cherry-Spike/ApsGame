package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class Window extends Button {
	
	protected String WindowLightOn;
	protected String WindowLightOff;
	protected boolean lightON = true;
	protected int Width, Height;
	
	public Window(int width, int height, int posX, int posY) {
		setPrefWidth(width);
		setPrefHeight(height);
		setLayoutX(posX);
		setLayoutY(posY);
		SetWindowLightOn();
		InitializerListeners();
	}
	
	public void SetWindowLightOn() {
		setStyle(WindowLightOn);
		lightON = true;
	}
	
	public void SetWindowLightOff() {
		setStyle(WindowLightOff);
		lightON = false;
	}
	
	private void InitializerListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetWindowLightOff();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetWindowLightOff();
				}
			}
		});
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetWindowLightOff();
				}
			}
		});
	}
	
	public boolean GetlightON() {
		return lightON;
	}
}
