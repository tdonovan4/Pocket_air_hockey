package mainPackage;

import frame.MainFrame;
import frame.TitleScreen;

public class Main {
	public static MainFrame mf = new MainFrame();
	public static Game game = new Game(null, null, 0, false);

	public static void main(String[] args) {
		TitleScreen ts = new TitleScreen();
		ts.createScreen(mf);
	}
	// Appel des classes
}