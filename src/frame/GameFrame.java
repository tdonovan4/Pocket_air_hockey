package frame;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;

import common.Player;
import mainPackage.Main;

public class GameFrame {

	static Player player = new Player();

	public void frame(final MainFrame mf) {
		mf.setContentPane(player);
	}

	public void render() {
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		player.setPosX(x);
		player.setPosY(y);

		player.repaint();
	}
	
	private double width;
	private double height;
	private double scale;
	private double originX;
	private double originY;
	
	private void getFrameSize() {
		
		Rectangle size = Main.getMainFrame().getBounds();
		
		width = (size.getWidth()/1920);
		height = (size.getHeight()/1080);
		originX = size.getX();
		originY = size.getY();
		scale = Math.min(width,height);
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