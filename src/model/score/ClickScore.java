package model.score;


public class ClickScore {
	private static int TotalScore;
	
	public static void AddNewPoint(){
		TotalScore++;
	}
	
	public static int GetTotalScore() {
		return TotalScore;
	}
	
	public static int ResetScore() {
		return TotalScore = 0;
	}
}
