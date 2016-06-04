package common;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import frame.GameFrame;

@SuppressWarnings("serial")
public class Paint extends JPanel {

public void paintComponent(Graphics g) {
		
		Player player = new Player();
		GameFrame gm = new GameFrame();
		
	    int diameter = (int) Math.round(250*gm.getScale());
	    int x = (int) Math.round((player.getPosX() - gm.getOriginX())-0.5*diameter - 5);
	    int y = (int) Math.round((player.getPosY() - gm.getOriginY())-0.5*diameter - 25);
	    
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	    int border = (int) Math.round(30*gm.getScale());
	    
	    g.setColor(Color.lightGray);
		g.fillRect(0, 0, border, (int) gm.getSize().getHeight());
		g.fillRect((int) Math.round(gm.getSize().getWidth()*0.5-border), 0, border, (int) gm.getSize().getHeight());
		g.fillRect((int) gm.getSize().getWidth()-16-border, 0, border, (int) gm.getSize().getHeight());
		
		g.fillRect(0, 0,(int) gm.getSize().getWidth(), border);
		g.fillRect(0,(int) gm.getSize().getHeight()-39-border,(int) gm.getSize().getWidth(), border);
		
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter );
	}
}
