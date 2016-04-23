package frame;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public JFrame frame = new JFrame();

	public MainFrame() {

		super("Pocket air hockey");
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Création frame

		setVisible(true);
	}
}