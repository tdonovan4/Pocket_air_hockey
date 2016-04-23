package common;

import proxyClient.MainClock;

public class StartGame {

	public void start() {
		
		System.out.println("Start!");
		
		MainClock clock = new MainClock();
		clock.clock();
	}
}
