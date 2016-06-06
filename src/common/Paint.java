package common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import frame.GameFrame;

@SuppressWarnings("serial")
public class Paint extends JPanel {

	Player player = new Player();
	GameFrame gm = new GameFrame();
	
public void paintComponent(Graphics g) {
		
	    int diameter = (int) Math.round(250*gm.getScale());
	    int x = (int) Math.round((player.getPosX() - gm.getOriginX())-0.5*diameter - 5);
	    int y = (int) Math.round((player.getPosY() - gm.getOriginY())-0.5*diameter - 25);
	    
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	    int border = (int) Math.round(30*gm.getScale());
	    int round = (int) Math.round(600*gm.getScale());
	    int goal = (int) Math.round(500*gm.getScale());
	    
	    int width = this.getWidth();
	    int height = this.getHeight();
	   
	    Color lightRed = new Color (255,102,102);
	    Color lightBlue = new Color (100,149,237);
	    
	    g.setColor(lightRed);
		g.fillRect(0, 0, border, height);
		//Ligne de droite
		g.fillRect(width-border, 0, border, height);
		//Ligne de gauche
		
		g.fillRect((int) Math.round(width*0.5-border*0.5), 0, border, height);
		//Ligne du milieu
		
		g.fillRect(0, 0, width, border);
		//Ligne du haut
		g.fillRect(0,height-border,width, border);
		//Ligne du bas
		
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(border));
		
        //Cercle du milieu
		g.setColor(lightBlue);
		g2.drawOval((int) Math.round(width*0.5-round*0.5), (int) Math.round(height*0.5-round*0.5), round, round);
		
		
		//Cercle bleu des buts
		g.fillOval((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		g.fillOval((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		
		//Cercle rouge des buts
		g.setColor(lightRed);
		g2.drawOval((int) Math.round(0-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		g2.drawOval((int) Math.round(this.getWidth()-goal*0.5), (int) Math.round(height*0.5-goal*0.5), goal, goal);
		
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter );
	}
}
