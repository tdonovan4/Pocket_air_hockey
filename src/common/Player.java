package common;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import frame.GameFrame;

@SuppressWarnings("serial")
public class Player extends JPanel {
	
	private int sizePlayer = 150;
	private int menuHeight = 22;
	private int cursorSizeX = 10;
	private int cursorSizeY = 10;
	private int posX;
	private int posY;
	
	public void paintComponent(Graphics g) {
		
		GameFrame gm = new GameFrame();
		
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    
	    int diameter = (int) Math.round(sizePlayer*gm.getScale());
	    int x = (int) Math.round((posX - gm.getOriginX())-0.5*diameter - cursorSizeX);
	    int y = (int) Math.round((posY - gm.getOriginY())-0.5*diameter - menuHeight -cursorSizeY);
	    
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter );
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}