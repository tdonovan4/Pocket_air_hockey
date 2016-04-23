package common;

import frame.GameFrame;

public class StartGame {
    
    public void start() {
        System.out.println("Start!");
        GameFrame gFrame = new GameFrame();
        gFrame.render();
    }
}
