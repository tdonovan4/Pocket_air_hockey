package common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import frame.GameFrame;
import proxyClient.Puck;

@SuppressWarnings("serial")
public class Paint extends JPanel {
	
	//Bonne chance
	
	Player player = new Player();
	GameFrame gm = new GameFrame();
	Puck Puck = new Puck();
	
    int border = (int) Math.round(30*gm.getScale());
    int round = (int) Math.round(600*gm.getScale());
    int goal = (int) Math.round(500*gm.getScale());
    
    int width = this.getWidth();
    int height = this.getHeight();
	
    int diameterPlayer = (int) Math.round(250*gm.getScale());
    int xPlayer1 = (int) Math.round((player.getPosX() - gm.getOriginX())-0.5*diameterPlayer - 5);
    int yPlayer1 = (int) Math.round((player.getPosY() - gm.getOriginY())-0.5*diameterPlayer - 25);
    
    int diameterPuck = (int) Math.round(150*gm.getScale());
    
	public Rectangle lineLeft = new Rectangle(0, 0, border, height);
	public Rectangle lineRight = new Rectangle(width-border, 0, border, height);
    public Rectangle lineMiddle = new Rectangle((int) Math.round(width*0.5-border*0.5), 0, border, height);
    public Rectangle lineTop = new Rectangle(0, 0, width, border);
    public Rectangle lineBot = new Rectangle(0,height-border,width, border);
    
    public Ellipse2D ovalMiddle = new Ellipse2D.Float((int) Math.round(width*0.5-round*0.5), (int) Math.round(height*0.5-round*0.5), round, round);
	public Ellipse2D ovalBut1 = new Ellipse2D.Float((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
	public Ellipse2D ovalBut2 = new Ellipse2D.Float((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
	
	public Ellipse2D ovalButExt1 = new Ellipse2D.Float((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
	public Ellipse2D ovalButExt2 = new Ellipse2D.Float((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
	
	public Ellipse2D player1 = new Ellipse2D.Float(xPlayer1, yPlayer1, diameterPlayer, diameterPlayer);
	
	public Ellipse2D puck = new Ellipse2D.Float(width/2-diameterPuck/2, height/2-diameterPuck/2, diameterPuck, diameterPuck);
	
	public int puckWidth = width/2-diameterPuck/2;
	public int puckHeight = height/2-diameterPuck/2;
			
public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
	    
	    Rectangle frame = new Rectangle(0, 0, this.getWidth(), this.getHeight());
	    
	    border = (int) Math.round(30*gm.getScale());
	    round = (int) Math.round(600*gm.getScale());
	    goal = (int) Math.round(500*gm.getScale());
	    
	    width = this.getWidth();
	    height = this.getHeight();
		
	    diameterPlayer = (int) Math.round(250*gm.getScale());
	    xPlayer1 = (int) Math.round((player.getPosX() - gm.getOriginX())-0.5*diameterPlayer - 5);
	    yPlayer1 = (int) Math.round((player.getPosY() - gm.getOriginY())-0.5*diameterPlayer - 25);
	    
	    diameterPuck = (int) Math.round(150*gm.getScale());
	    
		lineLeft = new Rectangle(0, 0, border, height);
		lineRight = new Rectangle(width-border, 0, border, height);
	    lineMiddle = new Rectangle((int) Math.round(width*0.5-border*0.5), 0, border, height);
	    lineTop = new Rectangle(0, 0, width, border);
	    lineBot = new Rectangle(0,height-border,width, border);
	    
	    ovalMiddle = new Ellipse2D.Float((int) Math.round(width*0.5-round*0.5), (int) Math.round(height*0.5-round*0.5), round, round);
		ovalBut1 = new Ellipse2D.Float((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		ovalBut2 = new Ellipse2D.Float((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		
		ovalButExt1 = new Ellipse2D.Float((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		ovalButExt2 = new Ellipse2D.Float((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		
		player1 = new Ellipse2D.Float(xPlayer1, yPlayer1, diameterPlayer, diameterPlayer);
		
		puck = new Ellipse2D.Float((int) Math.round(Puck.getPuckX()*gm.getScale()), Puck.getPuckY(), diameterPuck, diameterPuck);
	    
		puckWidth = width/2-diameterPuck/2;
		puckHeight = height/2-diameterPuck/2;
	    
	    //Reset puck
	    if(Puck.getPuckX() == 9000) {
	    	Puck.setPuckPos(puckWidth, puckHeight);
	    }
	    
		g.setColor(Color.white);
	    g2.fill(frame);
	   
	    Color lightRed = new Color (255,102,102);
	    Color lightBlue = new Color (100,149,237);
	    
	    g.setColor(lightRed);
		g2.fill(lineLeft);
		//Ligne de gauche
		g2.fill(lineRight);
		//Ligne de droite
		
		g2.fill(lineMiddle);
		//Ligne du milieu
		
		g2.fill(lineTop);
		//Ligne du haut
		g2.fill(lineBot);
		//Ligne du bas
		
        //Cercle du milieu
		g2.setStroke(new BasicStroke(border));
		
		g.setColor(lightBlue);
		g2.draw(ovalMiddle);
		
		
		//Cercle bleu des buts
		g2.fill(ovalBut1);
		g2.fill(ovalBut2);
		
		//Cercle rouge des buts
		
		g.setColor(lightRed);
		g2.draw(ovalButExt1);
		g2.draw(ovalButExt2);
		
		g.setColor(Color.BLACK);
		g2.fill(puck);	
		
		g.setColor(Color.red);
		g2.fill(player1);
	}
}
