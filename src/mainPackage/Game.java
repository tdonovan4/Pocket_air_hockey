package mainPackage;

public class Game {
	public Boolean singlemode;
	public String username;
	public int score;
	//Variables modifié
	
	public boolean mode;
	public String name;
	public int currentScore;
	//Variables brute
	
	public Game(Boolean mode, String name, int currentScore) {
		singlemode = mode;
		username = name;
		score = currentScore;
	}
	//Constructeur des settings du jeu
}
