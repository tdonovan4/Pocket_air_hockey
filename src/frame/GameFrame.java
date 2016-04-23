package frame;

import java.awt.MouseInfo;

import javax.swing.JFrame;

import common.Player;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	static Player player = new Player();
	
	public void frame(final MainFrame mf) {
		mf.setContentPane(player);
	}

	public void render() {
		
		int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
		int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
		
		player.setPosX(x);
		player.setPosY(y);

		player.repaint();

		System.out.println("test");
	}
}
