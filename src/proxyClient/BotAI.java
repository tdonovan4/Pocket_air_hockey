package proxyClient;

import common.Paint;

public class BotAI {
	static Paint paint = new Paint();
	static Puck puck = new Puck();

	public static double botX;
	public static double botY;

	public void bot() {
		double dx = puck.puckX() - botX;
		double dy = puck.puckY() - botY;

		double length = Math.sqrt(dx * dx + dy * dy);

		dx /= length;
		dy /= length;

		botX = botX + dx;
		botY = botY + dy;

		System.out.println(" pos: " + botX + " " + botY);
	}

	public void collision() {

	}
}
