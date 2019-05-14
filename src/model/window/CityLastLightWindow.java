package model.window;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class CityLastLightWindow extends Button {
	
	protected String WindowLightOn;
	protected String WindowLightActive;
	protected String WindowLightOff;
	protected boolean lightON = true;
	protected int Width, Height;
	
	public CityLastLightWindow(int width, int height,  int posX, int posY) {
		setPrefWidth(width);
		setPrefHeight(height);
		setLayoutX(posX);
		setLayoutY(posY);
		InitializerListeners();
	}
	
	public void SetWindowLightOn() {
		lightON = true;
		setStyle(WindowLightOn);
	}
	
	public void SetWindowLightOff() {
		lightON = false;
		DisableWindow();
		setStyle(WindowLightOff);
	}
	
	public void SetWindowLightActive() {
		setStyle(WindowLightActive);
	}
	
	private void InitializerListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					SetWindowLightOn();
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
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
					SetWindowLightActive();
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
					setStyle(WindowLightOn);					
			}
		});
	}
	
	public boolean GetlightON() {
		return lightON;
	}
	
	public void EnableWindow() {
		this.setDisabled(false);
		this.setVisible(true);
	}
	
	public void DisableWindow() {
		this.setDisabled(true);
		this.setVisible(false);
	}

}
