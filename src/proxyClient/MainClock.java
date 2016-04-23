package proxyClient;

import frame.GameFrame;
import mainPackage.Main;

public class MainClock {
	public void clock() {

		GameFrame gFrame = new GameFrame();
		gFrame.frame(Main.mf);

		while (true) {
			
			gFrame.render();

			System.out.println("Start!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
