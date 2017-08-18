package frame;

import java.awt.AWTException;

import common.Paint;
import common.Player;
import mainPackage.Game;
import mainPackage.Main;
import proxyClient.BotAI;
import proxyClient.Puck;

public class GameFrame {

	public static Paint paint = new Paint();
	static Puck puck = new Puck();
	static BotAI bot = new BotAI();
	
	public void frame() {
		// Adding paint to frame
		Main.getMainFrame().getContentPane().add(paint);
	}

	Player player = new Player();

	public void collision() {
		// Checking collision
		puck.checkCollisionPlayer(paint.player1, BotAI.botX, BotAI.botY);
		puck.checkCollision(Paint.width, Paint.height, Paint.goalY, Game.diameterPlayer);
	}

	public void render() {
		// Pos player
		player.posPlayer();
		
		// Checking collision
		bot.bot();
		collision();
		puck.speedLimit();

		// Refreshing
		paint.repaint();
	}

	public void start() {
		// Last settings
		try {
			// Moving cursor
			Player.replace(Paint.width, Paint.height, Game.diameterPlayer);
		} catch (AWTException e) {
			// Cursor cannot be moved
			e.printStackTrace();
		}
		// Setting puck pos
		puck.setPuckPos(Game.gameWidth / 2, Game.gameHeight / 2);
	}
	public void win() {
		Paint.win = true;
		paint.repaint();
	}
}
