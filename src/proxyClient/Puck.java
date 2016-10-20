package proxyClient;

import javax.swing.JPanel;

import common.Player;
import frame.GameFrame;

@SuppressWarnings("serial")
public class Puck extends JPanel {

	Player player = new Player();
	GameFrame gm = new GameFrame();

	// Current puck position
	static int puckX = 9000;
	static int puckY = 9000;

	// Puck speed
	static int puckSpeedX;
	static int puckSpeedY;

	static double dist;

	// Reset puck pos
	public void setPuckPos(int x, int y) {
		if (dist < puckSpeedX) {
		puckX = (int) (x - (puckSpeedX - dist));
		} else if (dist < -1) {
		puckY = (int) (y - (puckSpeedY - dist));
		} else {
		puckX = x;
		puckY = y;
		}
	}
	// Get distance between puck and object
	public void getDist(double dist1) {
		dist = dist1;
	}

	// Call when player collide with puck
	public void collisionPlayer() {
		// Speed player
		System.out.println(player.getSpeedPlayerX());
		System.out.println(player.getSpeedPlayerY());

		puckSpeedX = (1 - 3) / (1 + 3) * puckSpeedX + 2 * 3 / (1 - 3) * player.getSpeedPlayerX();
		puckSpeedY = (1 - 3) / (1 + 3) * puckSpeedY + 2 * 3 / (1 - 3) * player.getSpeedPlayerY();
	}

	// Call when puck collide with objects
	public void collision() {
		puckSpeedX = puckSpeedX * -1;
		puckSpeedY = puckSpeedY * -1;
		
		System.out.println(puckSpeedX);
	}

	public int getPuckX() {
		puckX = puckX + puckSpeedX;
		return puckX;
	}

	public int getPuckY() {
		puckY = puckY + puckSpeedY;
		return puckY;
	}
}
