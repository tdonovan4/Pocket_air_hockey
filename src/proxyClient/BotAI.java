package proxyClient;

import java.util.Vector;

import common.Paint;

public class BotAI {
	static Paint paint = new Paint();
	public static double botX = paint.player2.getCenterX();
	public static double botY = paint.player2.getCenterY();

	public void bot() {
		double dx = Paint.puck.getCenterX() - botX;
		double dy = Paint.puck.getCenterY() - botY;
		
		double length = Math.sqrt(dx*dx+dy*dy);
		
		dx/=length;
		dy/=length;

		botX = botX + dx;
		botY = botY + dy;

		System.out.println(" pos: " + botX + " " + botY);
	}
	public void collision() {
		
	}
}
