package mainPackage;

public class Game {
	public Boolean currentMode;
	public String username;
	public static int scorePlayer1;
	public static int scorePlayer2;
	public boolean gameOver;
	public static int maxScore;
	
	public static int width = 711;
	public static int height = 400;
	public static int gameWidth = 695;
	public static int gameHeight = 361;
	
	public static int diameterPlayer = 75;
	
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
