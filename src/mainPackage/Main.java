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
	
	public static MainFrame getMainFrame() {
		return mf;
	}
	// Appel des classes
}