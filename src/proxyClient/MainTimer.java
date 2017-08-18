package proxyClient;

import java.util.Timer;
import java.util.TimerTask;

import frame.GameFrame;
import frame.TitleScreen;
import mainPackage.Game;
import mainPackage.Main;

public class MainTimer extends TimerTask {
	GameFrame gf = new GameFrame();
	static Timer timer = new Timer(true);
	
	public void run() {
		if (Game.maxScore <= Game.scorePlayer1 || Game.maxScore <= Game.scorePlayer2) {
			timer.cancel();
			timer.purge();
			
			gf.win();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Main.reset();
			Main.mf.getContentPane().remove(GameFrame.paint);
			
	 		TitleScreen ts = new TitleScreen();
			ts.createScreen(Main.mf);
		} else {
			gf.render();
		}
		completeTask();
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
