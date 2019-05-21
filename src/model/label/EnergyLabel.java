package model.label;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import model.score.ScoreBars;

public class EnergyLabel extends GameLabel {

	public EnergyLabel(String desc, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetEnegyPoints());
		this.stringInfo = df;
		this.setTextFill(Color.YELLOW);	
		this.setText(desc + stringInfo);
	}

	public void UpdateLabel(){
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		String df = decimalFormat.format(ScoreBars.GetEnegyPoints());
		this.stringInfo = df;
		this.setText(desc + stringInfo);
	}
}
