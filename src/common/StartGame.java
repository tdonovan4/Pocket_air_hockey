package common;

import frame.GameFrame;

public class StartGame {
	
	GameFrame gFrame = new GameFrame();
	
	public void start() {
		System.out.println("Start!");
		//go!
		gFrame.paintComponent(null);
	}
}
