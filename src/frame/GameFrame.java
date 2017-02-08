package frame;

import java.awt.AWTException;

import common.Paint;
import common.Player;
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
		puck.checkCollisionPlayer(paint.player1);
		puck.checkCollision(Paint.width, Paint.height, Paint.goalY, Paint.diameterPlayer);
	}

	public void render() {
		// Checking collision
		collision();
		bot.bot();

		// Pos player
		player.posPlayer();

		// Refreshing
		paint.repaint();
	}

	public void start() {
		// Last settings
		try {
			// Moving cursor
			Player.replace(Paint.width, Paint.height, Paint.diameterPlayer);
		} catch (AWTException e) {
			// Cursor cannot be moved
			e.printStackTrace();
		}
		// Setting puck pos
		puck.setPuckPos(Paint.width / 2, Paint.height / 2);
	}
}
