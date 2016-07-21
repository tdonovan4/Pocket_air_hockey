package common;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel {
	
	static int posPlayerX;
	static int posPlayerY;

	public void setPosX(int posX) {
		posPlayerX = posX;
	}

	public void setPosY(int posY) {
		posPlayerY = posY;
	}

		public int getPosX() {
		return posPlayerX;
	}

	public int getPosY() {
		return posPlayerY;
	}
	
}