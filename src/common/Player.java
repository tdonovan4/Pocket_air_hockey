package common;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel {

	private int posX = 50;
	private int posY = 50;

	public void paintComponent(Graphics g) {
		System.out.println("Player");
		g.setColor(Color.red);
		g.fillOval(posX, posY, 50, 50);
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