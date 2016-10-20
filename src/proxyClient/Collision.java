package proxyClient;

import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

import proxyClient.Puck;

@SuppressWarnings("serial")
public class Collision extends JPanel {

	Puck Puck = new Puck();

	double cx2;
	double cy2;
	double rad2;
	boolean collision;
	static double dist;

	public boolean checkCollisionPlayer(Ellipse2D player, Ellipse2D puck) {

		double rad1 = player.getWidth() * 0.5;
		rad2 = puck.getWidth() * 0.5;
		double cx1 = player.getCenterX();
		double cy1 = player.getCenterY();
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		dist = Math.sqrt((cx2 - cx1) * (cx2 - cx1) + (cy2 - cy1) * (cy2 - cy1));
		collision = dist <= rad1 + rad2;
		
		if (collision) {
			Puck.collisionPlayer();
		}
		return collision;
	}
	
	public void setDist() {
		Puck.getDist(dist);
	}

	public boolean checkCollision(Ellipse2D puck) {
		cx2 = puck.getCenterX();
		cy2 = puck.getCenterY();

		rad2 = puck.getWidth() * 0.5;

		boolean collision = false;
		
		if (cx2 - rad2 <= 0) {
			collision = true;
			Puck.collision();
		}
		return collision;
	}
}