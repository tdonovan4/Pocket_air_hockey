package common;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel {

	static int posPlayerX;
	static int posPlayerY;

	int lastPosPlayerX;
	int lastPosPlayerY;

	static int speedPlayerX;
	static int speedPlayerY;

	public void setPosX(int posX) {
		lastPosPlayerX = posPlayerX;
		posPlayerX = posX;
		speedPlayerX = posPlayerX - lastPosPlayerX;
	}

	public void setPosY(int posY) {
		lastPosPlayerY = posPlayerY;
		posPlayerY = posY;
		speedPlayerY = posPlayerY - lastPosPlayerY;
	}

	public int getSpeedPlayerX() {
		return (speedPlayerX);
	}

	public int getSpeedPlayerY() {
		return (speedPlayerY);
	}

	public int getPosX() {
		return posPlayerX;
	}

	public int getPosY() {
		return posPlayerY;
	}

}