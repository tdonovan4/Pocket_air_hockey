package proxyClient;

import java.util.Timer;
import java.util.TimerTask;

import frame.GameFrame;
import frame.TitleScreen;
import mainPackage.Main;

public class MainTimer extends TimerTask {
	GameFrame gf = new GameFrame();
	static Timer timer = new Timer(true);
	
	public void run() {
		//Rendering a frame
		gf.render();
		completeTask();
		//Stop timer
		if (Main.game.maxScore <= Main.game.scorePlayer1 || Main.game.maxScore <= Main.game.scorePlayer2) {
			timer.cancel();
			timer.purge();
			Main.reset();
			
			Main.mf.getContentPane().remove(GameFrame.paint);
			
	 		TitleScreen ts = new TitleScreen();
			ts.createScreen(Main.mf);
		}
	}
	
    private void completeTask() {
    	//end
    }
	
	public void createTimer() {
		//Creation of timer
		TimerTask timerTask = new MainTimer();
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 17);
		System.out.println("TimerTask started");
	}
}
