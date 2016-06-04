package proxyClient;

import java.util.Timer;
import java.util.TimerTask;

import frame.GameFrame;

public class MainTimer extends TimerTask {
	
	public void run() {
		GameFrame gf = new GameFrame();
		gf.render();
		completeTask();
	}
	
    private void completeTask() {
    	//
    }
	
	public void createTimer() {
		TimerTask timerTask = new MainTimer();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 17);
		System.out.println("TimerTask started");
	}
}
