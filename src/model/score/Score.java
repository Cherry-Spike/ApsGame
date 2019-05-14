package model.score;


public class Score {
	private static int TotalScore;
	
	public static void AddNewPoint(){
		TotalScore++;
	}
	
	public static int GetTotalScore() {
		return TotalScore;
	}
}
