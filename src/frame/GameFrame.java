package frame;

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
	public static Ellipse2D puck = Paint.puck;

	public void frame() {
		Main.getMainFrame().getContentPane().add(paint);
	}

	private int x;
	private int y;

	Player player = new Player();

	public void collision() {
		collision.checkCollisionPlayer(paint.player1, puck);
		collision.checkCollision(puck, Paint.width, Paint.height, Paint.goal1, Paint.goal2, Paint.diameterPlayer);
	}

	public void render() {
		
		getCursorCoord();

		player.setPosX(x);
		player.setPosY(y);

		puck = Paint.puck;
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
		collision.setPuckPos(Paint.width / 2 - Paint.diameterPuck/2, Paint.height / 2 - Paint.diameterPuck/2);
	}
}