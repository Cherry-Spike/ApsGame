package model.label;

import model.score.ClickScore;

public class IntLabel extends GameLabel {

	public IntLabel(String desc, int info, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		intInfo = info;		
		this.setText(desc + intInfo);		
	}
	
	public void UpdateLabel(){
		this.setText(desc + ClickScore.GetTotalScore());
	}	
}
