package model.label;

public class TimeLabel extends GameLabel {

	public TimeLabel(String desc, int info, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		intInfo = info;		
		this.setText(desc + intInfo);		
	}
	
	public void UpdateLabel(int countDay){
		this.setText(desc + countDay);
	}

	protected void UpdateLabel() {
		
	}	
}
