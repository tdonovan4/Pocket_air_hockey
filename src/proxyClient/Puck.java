package proxyClient;

import java.awt.AWTException;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import common.Player;
import frame.GameFrame;
import mainPackage.Main;

@SuppressWarnings("serial")
public class Puck extends JPanel {

	Player player = new Player();
	GameFrame gm = new GameFrame();

	static double puckSpeedX;
	static double puckSpeedY;

	static double dist;

	static double cx2;
	static double cy2;
	static double rad1;
	static double rad2 = 25;

	static double puckX = 0;
	static double puckY = 0;

	static boolean goal = false;

	public void setPuckPos(double x, double y) {
		// Reset puck pos
		puckX = x;
		puckY = y;
	}

	public void collisionPlayer() {
		// Setting puck speed after collision with player (x)
		double a1 = (puckX - player.getPosXGC()) / dist;
		a1 = Math.min(a1, 1.0);
		a1 = Math.max(a1, -1.0);
		if (a1 > 0) {
			a1 = a1 * -1;
		}
		puckSpeedX = -1 * puckSpeedX + player.getSpeedPlayerX();

		// Setting puck speed after collision with player (y)
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
		// Checking if puck and player in collision

		rad1 = player1.getWidth() * 0.5;
		rad2 = puck.getWidth() * 0.5;
		double cx1 = player1.getCenterX();
		double cy1 = player1.getCenterY();
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		dist = Math.sqrt((cx2 - cx1) * (cx2 - cx1) + (cy2 - cy1) * (cy2 - cy1));

		boolean collision = dist <= rad1 + rad2;

		if (collision) {
			// Collision with player!
			puckX = puckX + (rad1 + rad2 - dist) * Math.signum(player.getSpeedPlayerX());
			puckY = puckY + (rad1 + rad2 - dist) * Math.signum(player.getSpeedPlayerY());
			collisionPlayer();
		}
		return collision;
	}

	public boolean checkCollision(Ellipse2D puck, double sizeX, double sizeY, int goalY, int p1) {
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		rad2 = puck.getWidth() * 0.5;

		boolean collision = false;

		if (puck.getX() >= -puck.getWidth() && puck.getX() <= sizeX + puck.getWidth() / 2) {
			goal = false;
		}

		if (cx2 - rad2 < 0) {
			if (puckY < sizeY / 2 + goalY / 2 - p1 / 2 && puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
				if (puckX <= -puck.getWidth()) {
					goal = true;

					puckX = sizeX / 4 - puck.getWidth() / 2;
					puckY = sizeY / 2 - puck.getHeight() / 2;

					try {
						Player.replace(sizeX, sizeY, p1);
					} catch (AWTException e) {
						e.printStackTrace();
					}

					puckSpeedX = 0;
					puckSpeedY = 0;

					Main.game.scorePlayer1++;
					System.out.println("Goal!");
				}
			} else {
				collision = true;
				collisionHoriz(0);
			}
		}
		if (cy2 - rad2 < 0) {
			collision = true;
			collisionVert(0);
		}
		if (cx2 + rad2 > sizeX) {
			if (puckY < sizeY / 2 + goalY / 2 - p1 / 2 && puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
				if (puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
					goal = true;

					puckX = sizeX / 4 * 3 - puck.getWidth() / 2;
					puckY = sizeY / 2 - puck.getHeight() / 2;

					try {
						Player.replace(sizeX, sizeY, p1);
					} catch (AWTException e) {
						e.printStackTrace();
					}

					puckSpeedX = 0;
					puckSpeedY = 0;

					Main.game.scorePlayer2++;
				}
			} else {
				collision = true;
				collisionHoriz(sizeX - (rad2 * 2));
			}
		}
		if (cy2 + rad2 > sizeY) {
			collision = true;
			collisionVert(sizeY - (rad2 * 2));
		}
		return collision;
	}
}
