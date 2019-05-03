package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Janela;

public class MainGame{
	private static final int WIDTH = 1200;
	private static final int HEIGTH = 700;
	private Pane newPane;
	private Scene newScene;
	
	public Janela jan1, jan2, jan3, jan4, jan5, jan6;
	public List<Janela> janelas;
	
	public List<Janela> getLista() {
		List<Janela> janelas = new ArrayList<Janela>();
		
		janelas.add(jan1 = new Janela(50,50));
		janelas.add(jan2 = new Janela(150,150));
		janelas.add(jan3 = new Janela(200,200));
		janelas.add(jan4 = new Janela(250,200));
		janelas.add(jan5 = new Janela(300,200));
		janelas.add(jan6 = new Janela(350,200));
		
		return janelas;
	}
	
	public Scene SetMainGameScene() {
		newPane = new Pane();
		newScene = new Scene(newPane,WIDTH,HEIGTH);
		newPane.getChildren().addAll(getLista());
        return newScene;
	}
	
	public Janela janelaAleatoria() {
		Janela randomJanela;
		int random;
		do{
			Random r = new Random();
			random = r.nextInt(5);
			
			randomJanela = janelas.get(random);
		}while(randomJanela.ativa);
			
			return janelas.get(random);
	}
}

