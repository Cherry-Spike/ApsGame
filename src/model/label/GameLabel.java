package model.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public abstract class GameLabel extends Label {
	
	protected String desc;
	protected String stringInfo;
	protected double doubleInfo;
	protected int intInfo;
	protected int layoutX;
	protected int layoutY;
	protected int size;

	public GameLabel(String desc, int layoutX, int layoutY, int size) {
		this.desc = desc;
		this.setLayoutX(layoutX);
		this.setLayoutY(layoutY);
		this.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, size));
		this.setTextFill(Color.WHITE);		
	}
	
	protected abstract void UpdateLabel();
	
}
