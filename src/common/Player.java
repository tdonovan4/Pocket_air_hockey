package common;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import javax.swing.JPanel;

import mainPackage.Main;

@SuppressWarnings("serial")
public class Player extends JPanel {

	static double posPlayerX;
	static double posPlayerY;

	static double lastPosPlayerX;
	static double lastPosPlayerY;

	static double speedPlayerX;
	static double speedPlayerY;

	public static void replace(double width, double height, int player) throws AWTException {
		Robot r = new Robot();

		lastPosPlayerX = Math.round(Main.getMainFrame().getComponent(0).getLocationOnScreen().x
				+ Main.getMainFrame().getContentPane().getWidth() - player / 2);
		lastPosPlayerY = Math.round(Main.getMainFrame().getComponent(0).getLocationOnScreen().y
				+ Main.getMainFrame().getContentPane().getHeight() / 2);

		posPlayerX = lastPosPlayerX;
		posPlayerY = lastPosPlayerY;

		r.mouseMove((int) lastPosPlayerX, (int) lastPosPlayerY);
		speedPlayerX = 0;
		speedPlayerY = 0;
	}

	public void posPlayer() {
		// Getting cursor position
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();

		// posX
		lastPosPlayerX = posPlayerX;
		posPlayerX = b.getX();
		speedPlayerX = 0.1 * speedPlayerX + (posPlayerX - lastPosPlayerX);
		if (Math.abs(speedPlayerX) < 0.1) {
			speedPlayerX = 0;
		}

		// posY
		lastPosPlayerY = posPlayerY;
		posPlayerY = b.getY();
		speedPlayerY = 0.1 * speedPlayerY + (posPlayerY - lastPosPlayerY);
		if (Math.abs(speedPlayerY) < 0.1) {
			speedPlayerY = 0;
		}
	}

	public double getSpeedPlayerX() {
		return (speedPlayerX);
	}

	public double getSpeedPlayerY() {
		return (speedPlayerY);
	}

	public double getPosX() {
		return posPlayerX;
	}

	public double getPosY() {
		return posPlayerY;
	}

	public double getPosXGC() {
		return (posPlayerX - Main.getMainFrame().getComponent(0).getLocationOnScreen().x);
	}

	public double getPosYGC() {
		return (posPlayerY - Main.getMainFrame().getComponent(0).getLocationOnScreen().y);
	}

}
