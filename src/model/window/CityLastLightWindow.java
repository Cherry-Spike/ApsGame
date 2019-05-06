package model.window;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class CityLastLightWindow extends Button {
	
	protected String WindowLightOn;
	protected String WindowLightOff;
	protected int Width, Height;
	
	public CityLastLightWindow(int width, int height) {
		setPrefWidth(width);
		setPrefHeight(height);
		InitializerListeners();
	}
	
	public void SetWindowLightOn() {
		setStyle(WindowLightOn);
	}
	
	public void SetWindowLightOff() {
		setStyle(WindowLightOff);		
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
	}

}
