package model.label;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import model.score.ScoreBars;

public class HappinessLabel extends GameLabel {
	
	private boolean realocate = true;
	private int position;

	public HappinessLabel(String desc, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		position = layoutX;
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetHappinessPoints());
		this.stringInfo = df;
		this.setTextFill(Color.RED);	
		this.setText(desc + stringInfo);
	}

	public void UpdateLabel(){
		if(ScoreBars.GetHappinessPoints() + 1 < 100 && realocate == true) {
			position += 10;
			this.setLayoutX(position);
			realocate = false;
		}else if(ScoreBars.GetHappinessPoints() + 1 == 100 && realocate == false){
			position -= 10;
			this.setLayoutX(position);
			realocate = true;
		}
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetHappinessPoints() + 1);
		this.stringInfo = df;
		this.setText(desc + stringInfo);
	}
}
