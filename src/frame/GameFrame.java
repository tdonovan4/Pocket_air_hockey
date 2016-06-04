package frame;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;

import common.Paint;
import common.Player;
import mainPackage.Main;

public class GameFrame {

	static Paint paint = new Paint();

	public void frame() {
		Main.getMainFrame().setContentPane(paint);
	}

	private int x;
	private int y;

	public void render() {

		Player player = new Player();

		getCursorCoord();

		player.setPosX(x);
		player.setPosY(y);

		paint.repaint();
	}

	private void getCursorCoord() {

		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();

		x = (int) b.getX();
		y = (int) b.getY();
	}

	private double width;
	private double height;
	private double scale;
	private double originX;
	private double originY;
	private double screenWidth;
	private double screenHeight;
	Rectangle size;

	private void getFrameSize() {

		size = Main.getMainFrame().getBounds();
		Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();

		screenWidth = resolution.getWidth();
		screenHeight = resolution.getWidth();

		width = (size.getWidth() / screenWidth);
		height = (size.getHeight() / screenHeight);
		originX = size.getX();
		originY = size.getY();
		scale = Math.min(width, height);
	}

	public Rectangle getSize() {
		getFrameSize();
		return size;
	}

	public double getScreenWidth() {
		getFrameSize();
		return screenWidth;
	}

	public double getScreenHeight() {
		getFrameSize();
		return screenHeight;
	}

	public double getOriginX() {
		getFrameSize();
		return originX;
	}

	public double getOriginY() {
		getFrameSize();
		return originY;
	}

	public double getWidth() {
		getFrameSize();
		return width;
	}

	public double getHeight() {
		getFrameSize();
		return height;
	}

	public double getScale() {
		getFrameSize();
		return scale;
	}
}