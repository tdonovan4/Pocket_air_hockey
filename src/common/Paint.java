package common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import frame.GameFrame;
import mainPackage.Main;
import proxyClient.Puck;

@SuppressWarnings("serial")
public class Paint extends JPanel {

	// Bonne chance

	Player player = new Player();
	GameFrame gm = new GameFrame();
	static Puck Puck1 = new Puck();

	public static int width = Main.getMainFrame().getComponent(0).getWidth();
	public static int height = Main.getMainFrame().getComponent(0).getHeight();

	int originX = Main.getMainFrame().getX();
	int originY = Main.getMainFrame().getY();

	static double scale = /*
							 * Math.min((double) width/711, (double) height/400)
							 */ 1;
	static double scaleX = /* (double) width/711 */1.0;
	static double scaleY = /* (double) height/400 */1.0;

	static int goalY = (int) Math.round(175 * scaleY);

	public static int diameterPuck = (int) Math.round(55 * scale);
	public static int diameterPlayer = (int) Math.round(75 * scale);

	int xPlayer1 = Math.round(Main.getMainFrame().getComponent(0).getLocationOnScreen().x+Main.getMainFrame().getContentPane().getWidth()-diameterPlayer/2);
	int yPlayer1 = Math.round(Main.getMainFrame().getComponent(0).getLocationOnScreen().y+Main.getMainFrame().getContentPane().getHeight()/2);

	static public Ellipse2D puck = new Ellipse2D.Float((int) Math.round(Puck1.puckX() * scaleX),
			(int) Math.round(Puck1.puckY() * scaleY), diameterPuck, diameterPuck);
	public Ellipse2D player1 = new Ellipse2D.Float(xPlayer1, yPlayer1, diameterPlayer, diameterPlayer);

	static public Rectangle goal1 = new Rectangle(0, height / 2 - goalY / 2 + diameterPuck / 2, diameterPuck,
			goalY - diameterPuck);
	static public Rectangle goal2 = new Rectangle(width, height / 2 - goalY / 2 + diameterPuck / 2, diameterPuck,
			goalY - diameterPuck);

	public void paintComponent(Graphics g) {
		
		//Puck1.setPuckPos(width/2-diameterPuck/2, height/2-diameterPuck/2);
		Graphics2D g2 = (Graphics2D) g;

		width = Main.getMainFrame().getContentPane().getWidth();
		height = Main.getMainFrame().getContentPane().getHeight();

		scale = /* Math.min((double) width/711, (double) height/400) */1;
		scaleX = /* (double) width/711 */1.0;
		scaleY = /* (double) height/400 */1.0;

		Rectangle frame = new Rectangle(0, 0, this.getWidth(), this.getHeight());

		originX = Main.getMainFrame().getX() - (width - this.getWidth());
		originY = Main.getMainFrame().getY() - (height - this.getHeight());

		int border = (int) Math.round(10 * scaleX);
		int roundX = (int) Math.round(150 * scaleX);
		int roundY = (int) Math.round(150 * scaleY);
		int goalX = (int) Math.round(175 * scaleX);
		goalY = (int) Math.round(175 * scaleY);

		diameterPlayer = (int) Math.round(75 * scale);

		// xPlayer1 = Math.max((int)
		// Math.round(player.getPosXGC())-diameterPlayer/2,
		// width/2+diameterPlayer/2);
		// double posXGC = Math.max((int) Math.round(player.getPosXGC()),
		// width/2+diameterPlayer/2);
		double posXGC = Math.max((int) Math.round(player.getPosXGC()), 0 + diameterPlayer / 2);
		xPlayer1 = Math.min((int) Math.round(posXGC) - diameterPlayer / 2, width - diameterPlayer);

		yPlayer1 = Math.max((int) Math.round(player.getPosYGC()) - diameterPlayer / 2, 0 + diameterPlayer / 2);
		double posYGC = Math.max((int) Math.round(player.getPosYGC()), 0 + diameterPlayer / 2);
		yPlayer1 = Math.min((int) Math.round(posYGC) - diameterPlayer / 2, height - diameterPlayer);

		diameterPuck = (int) Math.round(55 * scale);

		Rectangle lineLeft = new Rectangle(0, 0, border, height);
		Rectangle lineRight = new Rectangle(width - border, 0, border, height);
		Rectangle lineMiddle = new Rectangle((int) Math.round(width * 0.5 - border * 0.5), 0, border, height);
		Rectangle lineTop = new Rectangle(0, 0, width, border);
		Rectangle lineBot = new Rectangle(0, height - border, width, border);

		Ellipse2D ovalMiddle = new Ellipse2D.Float((int) Math.round(width * 0.5 - roundX * 0.5),
				(int) Math.round(height * 0.5 - roundY * 0.5), roundX, roundY);
		Ellipse2D ovalBut1 = new Ellipse2D.Float((int) Math.round(0 - goalX * 0.5),
				(int) Math.round(height * 0.5 - goalY * 0.5), goalX, goalY);
		Ellipse2D ovalBut2 = new Ellipse2D.Float((int) Math.round(this.getWidth() - goalX * 0.5),
				(int) Math.round(height * 0.5 - goalY * 0.5), goalX, goalY);

		Ellipse2D ovalButExt1 = new Ellipse2D.Float((int) Math.round(0 - goalX * 0.5),
				(int) Math.round(height * 0.5 - goalY * 0.5), goalX, goalY);
		Ellipse2D ovalButExt2 = new Ellipse2D.Float((int) Math.round(this.getWidth() - goalX * 0.5),
				(int) Math.round(height * 0.5 - goalY * 0.5), goalX, goalY);

		goal1 = new Rectangle(1 - diameterPuck, height / 2 - goalY / 2 + diameterPuck / 2, diameterPuck,
				goalY - diameterPuck);
		goal2 = new Rectangle(width - 1, height / 2 - goalY / 2 + diameterPuck / 2, diameterPuck, goalY - diameterPuck);

		player1 = new Ellipse2D.Float(xPlayer1, yPlayer1, diameterPlayer, diameterPlayer);

		puck = new Ellipse2D.Float((int) Math.round(Puck1.puckX() * scaleX), (int) Math.round(Puck1.puckY() * scaleY),
				diameterPuck, diameterPuck);

		g.setColor(Color.white);
		g2.fill(frame);

		Color lightRed = new Color(255, 102, 102);
		Color lightBlue = new Color(100, 149, 237);

		g.setColor(lightRed);
		g2.fill(lineLeft);
		// Ligne de gauche
		g2.fill(lineRight);
		// Ligne de droite

		g2.fill(lineMiddle);
		// Ligne du milieu

		g2.fill(lineTop);
		// Ligne du haut
		g2.fill(lineBot);
		// Ligne du bas

		// Cercle du milieu
		g2.setStroke(new BasicStroke(border));

		g.setColor(lightBlue);
		g2.draw(ovalMiddle);

		// Cercle bleu des buts
		g2.fill(ovalBut1);
		g2.fill(ovalBut2);

		// Cercle rouge des buts
		g.setColor(lightRed);
		g2.draw(ovalButExt1);
		g2.draw(ovalButExt2);

		// Puck
		g.setColor(Color.BLACK);
		g2.fill(puck);
		
		//Text
        BufferedImage text1 = new BufferedImage(150, 150, 
                BufferedImage.TYPE_INT_ARGB);
        BufferedImage text2 = new BufferedImage(150, 150, 
                BufferedImage.TYPE_INT_ARGB);
		
        Graphics2D gBuffImg1 = text1.createGraphics();
        Graphics2D gBuffImg2 = text2.createGraphics();

		gBuffImg1.setBackground(new Color(0, 0, 0, 0) );
		gBuffImg2.setBackground(new Color(0, 0, 0, 0) );
        //gBuffImg.setBackground(Color.red);
	    gBuffImg1.setColor(Color.BLACK);
	    gBuffImg2.setColor(Color.BLACK);

	    Font f = new Font("Arial Narrow", Font.PLAIN, 100);
	    
		gBuffImg1.setFont(f);
		gBuffImg2.setFont(f);
        gBuffImg1.setColor(Color.BLACK);
        gBuffImg2.setColor(Color.BLACK);
		
        String scorePlayer1 = Main.game.scorePlayer1+"";
        String scorePlayer2 = Main.game.scorePlayer2+"";
        
        FontMetrics metrics = gBuffImg1.getFontMetrics(f);
        int widthText = metrics.stringWidth(scorePlayer1);
        int heightText = metrics.getHeight();
        
		gBuffImg1.drawString(scorePlayer1, text1.getWidth()/2-widthText/2, text1.getHeight()/2+heightText/3);
        widthText = metrics.stringWidth(scorePlayer2);
		gBuffImg2.drawString(scorePlayer2, text2.getWidth()/2-widthText/2, text2.getHeight()/2+heightText/3);
		
        g2.drawImage(text1, width / 4 * 3 - text1.getWidth() / 2, height / 2 - text1.getHeight()/2, null);
        g2.drawImage(text2, width / 4 - text2.getWidth() / 2, height / 2 - text2.getHeight()/2, null);
        gBuffImg1.dispose();
        gBuffImg2.dispose();

		// Player1
		g.setColor(Color.red);
		g2.fill(player1);

		// test
		/*
		 * g.setColor(Color.BLACK); g2.fill(goal1); g2.fill(goal2);
		 */
	}
}
