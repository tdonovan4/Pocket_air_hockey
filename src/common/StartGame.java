package common;


import java.awt.Dimension;

import frame.GameFrame;
import mainPackage.Main;

public class StartGame {
	
	public void start() {
		
		GameFrame gFrame = new GameFrame();
		
		gFrame.setPreferredSize(new Dimension(400,200));
		
		GUIHelper.show(Main.mf, gFrame);
		//go!
	}
}
