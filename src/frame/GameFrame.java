package frame;

import java.awt.AWTException;

import common.Paint;
import common.Player;
import mainPackage.Main;
import proxyClient.Puck;

public class GameFrame {

	static Paint paint = new Paint();
	static Puck puck = new Puck();

	public void frame() {
		// Adding paint to frame
		Main.getMainFrame().getContentPane().add(paint);
	}

	Player player = new Player();

	public void collision() {
		//Checking collision
		puck.checkCollisionPlayer(paint.player1, Paint.puck);
		puck.checkCollision(Paint.puck, Paint.width, Paint.height, Paint.goal1, Paint.goal2, Paint.diameterPlayer);
	}

	public void render() {
		//Pos player
		player.posPlayer();
		
		//Checking collision
		collision();
		
		//Refreshing
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
		puck.setPuckPos(Paint.width / 2 - Paint.diameterPuck / 2, Paint.height / 2 - Paint.diameterPuck / 2);
	}
}