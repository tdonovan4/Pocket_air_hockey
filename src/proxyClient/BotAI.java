package proxyClient;

import common.Paint;
import mainPackage.Game;

public class BotAI {
	static Paint paint = new Paint();
	static Puck puck = new Puck();

	public static double botX = Game.diameterPlayer / 2;
	public static double botY = Game.gameHeight / 2;

	public static double botSpeedX = 1;
	public static double botSpeedY = 1;
	
	static double dx;
	static double dy;
	
	static double lastPosX;
	static double lastPosY;
	
	public void bot() {	
		lastPosX = botX;
		lastPosY = botY;
		System.out.println(Math.toDegrees(Math.atan2(puck.puckY() - botY, puck.puckX())));
		if(puck.puckX() < Game.width/2) {
			if(Puck.puckX > botX) {
				follow(Puck.puckX, Puck.puckY);
			} else {
				follow(Game.diameterPlayer / 2, botY);
			}
		} else {
			follow(Game.diameterPlayer / 2, Game.gameHeight / 2);
		}
		
		getPos();
		System.out.println(" pos: " + botX + " " + botY);
	}
	private void follow(double x, double y) {
		dx = x - botX;
		dy = y - botY;

		double length = Math.sqrt(dx * dx + dy * dy);

		dx /= length;
		dy /= length;
		
		botSpeedX = dx * (0.05*length);
		botSpeedY = dy * (0.05*length);
	}
	
	private void getPos() {
		botX = botX + botSpeedX;
		botY = botY + botSpeedY;
		//botSpeedX = botX - lastPosX;
		//botSpeedY = botY - lastPosY;
	}
}
