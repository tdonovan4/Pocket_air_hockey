package proxyClient;

import java.util.Timer;
import java.util.TimerTask;

import common.StartGame;

public class MainTimer extends TimerTask {
	
	public void run() {
		StartGame start = new StartGame();
		start.start();
		completeTask();
		System.out.println("TimerTask");
	}
	
    private void completeTask() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void createTimer() {
		TimerTask timerTask = new MainTimer();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 10);
		System.out.println("TimerTask started");
	}
}
