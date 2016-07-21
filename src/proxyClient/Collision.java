package proxyClient;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import common.Paint;

@SuppressWarnings("serial")
public class Collision extends JPanel {
	
	Paint paint = new Paint();
	
	public boolean checkCollision(Ellipse2D r1, Ellipse2D puck) {
		return r1.getBounds().intersects(puck.getBounds());
	}
}
