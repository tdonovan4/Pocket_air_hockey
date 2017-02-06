package mainPackage;

import frame.MainFrame;
import frame.TitleScreen;

public class Main {
	public static MainFrame mf = new MainFrame();
	public static Game game = new Game(null, null, 0, 0, false, 0);

	public static void main(String[] args) {
		TitleScreen ts = new TitleScreen();

		ts.createScreen(mf);
	}

	public static void reset() {
		game.currentMode = null;
		game.username = null;
		game.scorePlayer1 = 0;
		game.scorePlayer2 = 0;
		game.gameOver = false;
		game.maxScore = 0;
	}

	public static MainFrame getMainFrame() {
		return mf;
	}
	// Appel des classes
}
