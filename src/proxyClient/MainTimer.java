package proxyClient;

import java.util.Timer;
import java.util.TimerTask;

import frame.GameFrame;

public class MainTimer extends TimerTask {
	
	GameFrame gf = new GameFrame();
	
	public void run() {
		gf.render();
		completeTask();
	}
	
    private void completeTask() {
    	//end
    }
	
	public void createTimer() {
		TimerTask timerTask = new MainTimer();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 17);
		System.out.println("TimerTask started");
	}
}
