package mainPackage;

public class Game {
	public Boolean currentMode;
	public String username;
	public int scorePlayer1;
	public int scorePlayer2;
	public boolean gameOver;
	public int maxScore;

	public Game(Boolean mode, String name, int score1, int score2, Boolean gameOver, int max) {
		maxScore = max;
		currentMode = mode;
		username = name;
		scorePlayer1 = score1;
		scorePlayer2 = score2;
		this.gameOver = gameOver;
	}
	// Game setting
}
