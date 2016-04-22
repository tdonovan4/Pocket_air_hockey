package frame;

import java.awt.Graphics;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameFrame extends JPanel {
	
	public void paint( Graphics g) {
		
		super.paintComponent(g);  
		g.fillOval(20, 20, 75, 75);

	}
}
