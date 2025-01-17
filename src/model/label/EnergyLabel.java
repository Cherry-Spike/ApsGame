package model.label;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import model.score.ScoreBars;

public class EnergyLabel extends GameLabel {
	
	private boolean realocate = true;
	private int position;

	public EnergyLabel(String desc, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		position = layoutX;
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetEnergyPoints());
		this.stringInfo = df;
		this.setTextFill(Color.YELLOW);	
		this.setText(desc + stringInfo);
	}

	public void UpdateLabel(){
		if(ScoreBars.GetEnergyPoints() < 100 && realocate == true) {
			position += 4;
			this.setLayoutX(position);
			realocate = false;
		}else if(ScoreBars.GetEnergyPoints() == 100 && realocate == false){
			position -= 4;
			this.setLayoutX(position);
			realocate = true;
		}
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetEnergyPoints());
		this.stringInfo = df;
		this.setText(desc + stringInfo);
	}
}
