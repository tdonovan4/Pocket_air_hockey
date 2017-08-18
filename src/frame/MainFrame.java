package frame;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public MainFrame() {

		super("Pocket air hockey");
		setSize(711, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Création frame
		
		setVisible(true);
	}
}
