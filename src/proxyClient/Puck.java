package proxyClient;

import java.awt.AWTException;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import common.Player;
import frame.GameFrame;
import mainPackage.Game;

@SuppressWarnings("serial")
public class Puck extends JPanel {

	Player player = new Player();
	GameFrame gm = new GameFrame();

	static double puckSpeedX;
	static double puckSpeedY;

	static double distPlayer1;
	static double distPlayer2;

	static double cx2;
	static double cy2;
	static double rad1;
	static double rad2 = 25;

	static double puckX = 0;
	static double puckY = 0;

	static boolean goal = false;

	public static int diameterPuck = 55;

	public void setPuckPos(double x, double y) {
		// Reset puck pos
		puckX = x;
		puckY = y;
	}

	public void collisionPlayer1() {
		// Setting puck speed after collision with player (x)
		double a1 = (puckX - player.getPosX()) / distPlayer1;
		a1 = Math.min(a1, 1.0);
		a1 = Math.max(a1, -1.0);
		if (a1 > 0) {
			a1 = a1 * -1;
		}
		puckSpeedX = -1 * puckSpeedX + player.getSpeedPlayerX();

		// Setting puck speed after collision with player (y)
		double a2 = (puckY - player.getPosY()) / distPlayer1;
		a2 = Math.min(a2, 1.0);
		a2 = Math.max(a2, -1.0);
		if (a2 > 0) {
			a2 = a2 * -1;
		}
		puckSpeedY = -1 * puckSpeedY + player.getSpeedPlayerY();

		// System.out.println("a1: " + a1);
		// System.out.println("a2: " + a2);
	}
	
	public void collisionPlayer2() {
		// Setting puck speed after collision with player (x)
		double a1 = (puckX - BotAI.botX) / distPlayer2;
		a1 = Math.min(a1, 1.0);
		a1 = Math.max(a1, -1.0);
		if (a1 > 0) {
			a1 = a1 * -1;
		}
		puckSpeedX = -1 * puckSpeedX + BotAI.botSpeedX;

		// Setting puck speed after collision with player (y)
		double a2 = (puckY - BotAI.botY) / distPlayer2;
		a2 = Math.min(a2, 1.0);
		a2 = Math.max(a2, -1.0);
		if (a2 > 0) {
			a2 = a2 * -1;
		}
		puckSpeedY = -1 * puckSpeedY + BotAI.botSpeedY;
		
		System.out.println("Yep");
	}

	public void collisionVert(double limit) {
		puckSpeedY = puckSpeedY * -1;
		puckY = limit;
	}

	public void collisionHoriz(double limit) {
		puckSpeedX = puckSpeedX * -1;
		puckX = limit;
	}
	
	public void speedLimit() {
		int maxSpeed = 5;
		if(puckSpeedX >= maxSpeed) {
			puckSpeedX = maxSpeed;
		}
		if(puckSpeedY >= maxSpeed) {
			puckSpeedY = maxSpeed;
		}
		puckSpeedX = puckSpeedX - (0.015 * puckSpeedX);
		puckSpeedY = puckSpeedY - (0.015 * puckSpeedY);
	}
	
	public double puckX() {
		puckX = puckX + puckSpeedX;
		return puckX;
	}

	public double puckY() {
		puckY = puckY + puckSpeedY;
		return puckY;
	}

	public boolean checkCollisionPlayer(Ellipse2D player1, double botX, double botY) {
		// Checking if puck and player in collision

		rad1 = player1.getWidth() * 0.5;
		rad2 = diameterPuck / 2;
		double cx1 = player1.getCenterX();
		double cy1 = player1.getCenterY();
		
		cx2 = puckX;
		cy2 = puckY;
		distPlayer1 = Math.sqrt((cx2 - cx1) * (cx2 - cx1) + (cy2 - cy1) * (cy2 - cy1));
		
		cx1 = BotAI.botX;
		cy1 = BotAI.botY;
		distPlayer2 = Math.sqrt((cx2 - cx1) * (cx2 - cx1) + (cy2 - cy1) * (cy2 - cy1));

		boolean collisionPlayer1 = distPlayer1 <= rad1 + rad2;
		boolean collisionPlayer2 = distPlayer2 <= rad1 + rad2;

		if (collisionPlayer1) {
			// Collision with player!
			puckX = puckX + (rad1 + rad2 - distPlayer1) * Math.signum(player.getSpeedPlayerX());
			puckY = puckY + (rad1 + rad2 - distPlayer1) * Math.signum(player.getSpeedPlayerY());
			collisionPlayer1();
		}
		if (collisionPlayer2) {
			// Collision with player!
			puckX = puckX + (rad1 + rad2 - distPlayer2) * Math.signum(BotAI.botSpeedX);
			puckY = puckY + (rad1 + rad2 - distPlayer2) * Math.signum(BotAI.botSpeedY);
			collisionPlayer2();
		}
		if (collisionPlayer1 || collisionPlayer2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCollision(double sizeX, double sizeY, int goalY, int p1) {
		cx2 = puckX;
		cy2 = puckY;

		rad2 = diameterPuck / 2;

		boolean collision = false;

		if (puckX >= -puckX && puckX <= sizeX + puckX / 2) {
			goal = false;
		}

		if (cx2 - rad2 < 0) {
			if (puckY < sizeY / 2 + goalY / 2 - p1 / 2 && puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
				if (puckX <= -puckX) {
					goal = true;

					puckX = sizeX / 4;
					puckY = sizeY / 2;

					try {
						Player.replace(sizeX, sizeY, p1);
					} catch (AWTException e) {
						e.printStackTrace();
					}

					puckSpeedX = 0;
					puckSpeedY = 0;

					Game.scorePlayer1++;
					System.out.println("Goal!");
				}
			} else {
				collision = true;
				collisionHoriz(rad2);
			}
		}
		if (cy2 - rad2 < 0) {
			collision = true;
			collisionVert(rad2);
		}
		if (cx2 + rad2 > sizeX) {
			if (puckY < sizeY / 2 + goalY / 2 - p1 / 2 && puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
				if (puckY > sizeY / 2 - goalY / 2 - p1 / 2) {
					goal = true;

					puckX = sizeX / 4 * 3;
					puckY = sizeY / 2;

					try {
						Player.replace(sizeX, sizeY, p1);
					} catch (AWTException e) {
						e.printStackTrace();
					}

					puckSpeedX = 0;
					puckSpeedY = 0;

					Game.scorePlayer2++;
				}
			} else {
				collision = true;
				collisionHoriz(sizeX - rad2);
			}
		}
		if (cy2 + rad2 > sizeY) {
			collision = true;
			collisionVert(sizeY - rad2);
		}
		return collision;
	}
}
