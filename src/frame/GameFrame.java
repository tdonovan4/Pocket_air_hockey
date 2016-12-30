package frame;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.geom.Ellipse2D;

import common.Paint;
import common.Player;
import mainPackage.Main;
import proxyClient.Puck;

public class GameFrame {

	static Paint paint = new Paint();
	static Puck collision = new Puck();

	public void frame() {
		Main.getMainFrame().getContentPane().add(paint);
	}

	private int x;
	private int y;

	Player player = new Player();

	public void collision() {
		collision.checkCollisionPlayer(paint.player1, Paint.puck);
		collision.checkCollision(Paint.puck, Paint.width, Paint.height, Paint.goal1, Paint.goal2, Paint.diameterPlayer);
	}

	public void render() {
		
		getCursorCoord();

		player.setPosX(x);
		player.setPosY(y);
		
		collision();
		
		paint.repaint();
	}

	private void getCursorCoord() {

		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();

		x = (int) b.getX();
		y = (int) b.getY();
	}
	public void start() {
		try {
			Player.replace(Paint.width, Paint.height, Paint.diameterPlayer);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		collision.setPuckPos(Paint.width / 2 - Paint.diameterPuck/2, Paint.height / 2 - Paint.diameterPuck/2);
	}
}