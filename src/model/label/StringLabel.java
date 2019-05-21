package model.label;

public class StringLabel extends GameLabel {

	public StringLabel(String desc, String info, int layoutX, int layoutY, int size) {
		
		super(desc, layoutX, layoutY, size);
		stringInfo = info;		
		this.setText(desc + stringInfo);		
	}
	
	public void UpdateLabel(String info){
		stringInfo = info;
		this.setText(desc + stringInfo);
	}

	public void UpdateLabel() {		
	}

}
