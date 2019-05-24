package model.label;

import javafx.scene.paint.Color;
import model.score.ClickScore;
import view.ViewManager;

public class ScoreLabel extends GameLabel {

	public ScoreLabel(String desc, int info, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		intInfo = info;		
		this.setText(desc + intInfo);		
	}
	
	public void UpdateLabel(){
		this.setText(desc + ClickScore.GetTotalScore());
	}
	
	public void GetFinalScore(){	
		this.setText(desc + ViewManager.ScorePoints + "    Dias: " + ViewManager.ScoreDay);
		this.setTextFill(Color.BLACK);	
	}
}
