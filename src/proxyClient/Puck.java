package proxyClient;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import common.Player;
import frame.GameFrame;
import mainPackage.Main;

@SuppressWarnings("serial")
public class Puck extends JPanel {

	Player player = new Player();
	GameFrame gm = new GameFrame();
	// Puck speed
	static double puckSpeedX;
	static double puckSpeedY;

	static double dist;

	static double cx2;
	static double cy2;
	static double rad1;
	static double rad2 = 25;
	
	// Current puck position
	static double puckX = 0;
	static double puckY = 0;
	
	static boolean nearGoal = false;
	static boolean goal = false;
	
	// Reset puck pos
	public void setPuckPos(double x, double y) {
		puckX = x;
		puckY = y;
	}

	// Call when player collide with puck
	public void collisionPlayer() {
		// Speed player
		double a1 = (puckX - player.getPosXGC()) / dist;
		a1 = Math.min(a1, 1.0);
		a1 = Math.max(a1, -1.0);
		if (a1 > 0) {
			a1 = a1 * -1;
		}
		puckSpeedX = -1 * puckSpeedX + player.getSpeedPlayerX();

		double a2 = (puckY - player.getPosYGC()) / dist;
		a2 = Math.min(a2, 1.0);
		a2 = Math.max(a2, -1.0);
		if (a2 > 0) {
			a2 = a2 * -1;
		}
		puckSpeedY = -1 * puckSpeedY + player.getSpeedPlayerY();

		// System.out.println("a1: " + a1);
		// System.out.println("a2: " + a2);
	}

	// Call when puck collide with objects
	public void collisionVert(double limit) {
		puckSpeedY = puckSpeedY * -1;
		puckY = limit;
	}

	public void collisionHoriz(double limit) {
		puckSpeedX = puckSpeedX * -1;
		puckX = limit;
	}

	public double puckX() {
		puckSpeedX = Math.min(puckSpeedX, 30.0);
		puckSpeedX = puckSpeedX - (0.015 * puckSpeedX);
		puckX = puckX + puckSpeedX;
		return puckX;
	}

	public double puckY() {
		puckSpeedY = Math.min(puckSpeedY, 30.0);
		puckSpeedY = puckSpeedY - (0.015 * puckSpeedY);
		puckY = puckY + puckSpeedY;
		return puckY;
	}

	public boolean checkCollisionPlayer(Ellipse2D player1, Ellipse2D puck) {

		rad1 = player1.getWidth() * 0.5;
		rad2 = puck.getWidth() * 0.5;
		double cx1 = player1.getCenterX();
		double cy1 = player1.getCenterY();
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		dist = Math.sqrt((cx2 - cx1) * (cx2 - cx1) + (cy2 - cy1) * (cy2 - cy1));

		boolean collision = dist <= rad1 + rad2;

		if (collision && goal == false) {
			puckX = puckX + (rad1 + rad2 - dist) * Math.signum(player.getSpeedPlayerX());
			puckY = puckY + (rad1 + rad2 - dist
					) * Math.signum(player.getSpeedPlayerY());
			collisionPlayer();
		}
		return collision;
	}

	public boolean checkCollision(Ellipse2D puck, double sizeX, double sizeY, Rectangle goal1, Rectangle goal2, int p1) {
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		rad2 = puck.getWidth() * 0.5;

		boolean collision = false;
		
		if (goal1.intersects(puck.getBounds()) || goal2.intersects(puck.getBounds())) {
			nearGoal = true;
		} else {
			nearGoal = false;
		}
		
		if(puck.getX()<=-puck.getWidth()) {
			
			goal = true;
			
			puckX = sizeX/4-puck.getWidth()/2;
			puckY = sizeY/2-puck.getHeight()/2;
			
			puckSpeedX = 0;
			puckSpeedY = 0;
			
			try {
				Player.goal(sizeX, sizeY, p1);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			Main.game.scorePlayer1++;
		}
		
		if(puck.getX()>=sizeX+puck.getWidth()/2) {
			
			goal = true;
			
			puckX = sizeX/4*3-puck.getWidth()/2;
			puckY = sizeY/2-puck.getHeight()/2;
			
			puckSpeedX = 0;
			puckSpeedY = 0;
			
			try {
				Player.goal(sizeX, sizeY, p1);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			Main.game.scorePlayer2++;
		}
		
		if(puck.getX()>=-puck.getWidth() && puck.getX()<=sizeX+puck.getWidth()/2) {
			goal = false;
		}
		
		if (cx2 - rad2 < 0 && nearGoal == false) {
			collision = true;
			collisionHoriz(0);
		}
		if (cy2 - rad2 < 0) {
			collision = true;
			collisionVert(0);
		}
		if (cx2 + rad2 > sizeX && nearGoal == false) {
			collision = true;
			collisionHoriz(sizeX - (rad2 * 2));
		}
		if (cy2 + rad2 > sizeY) {
			collision = true;
			collisionVert(sizeY - (rad2 * 2));
		}
		return collision;
	}
}
