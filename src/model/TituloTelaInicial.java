package model;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TituloTelaInicial extends Label {
	
	public TituloTelaInicial(String text) {
		setText(text);
		setPrefWidth(500);
		setPrefHeight(300);
		SetFont();
		setTextFill(Color.rgb(37, 0, 61));
	}
	
	public void SetFont() {
		setFont(Font.font("Segoe UI", FontWeight.BOLD, 70));
	}

}
