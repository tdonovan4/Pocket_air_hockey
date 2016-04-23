package mainPackage;

public class Game {
	public Boolean singlemode;
	public String username;
	public int score;
	public boolean gameOver;
	//Variables modifié
	
	public boolean mode;
	public String name;
	public int currentScore;
	//Variables brute
	
	public Game(Boolean mode, String name, int currentScore, Boolean gameOver) {
		singlemode = mode;
		username = name;
		score = currentScore;
		this.gameOver = gameOver;
	}
	//Constructeur des settings du jeu
}
