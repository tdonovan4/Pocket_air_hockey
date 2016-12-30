package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mainPackage.Main;
import proxyClient.MainTimer;

@SuppressWarnings("serial")
public class TitleScreen extends JFrame implements ActionListener {

	JButton jouerSolo;
	JButton jouerMulti;
	JButton classement;
	JPanel panel = new JPanel();
	JPanel gameInfoPanel = new JPanel();
	JButton start;
	static JTextField numberOfPoints;

	public void createScreen(final MainFrame mf) {

		panel.setBackground(Color.WHITE);
		// Création panel

		GridLayout layout = new GridLayout(0, 1, 10, 10);
		panel.setLayout(layout);
		// Gérer la position des buttons

		panel.add(Box.createRigidArea(new Dimension(0, 0)));
		jouerSolo = new JButton("Jouer en Solo!");
		jouerSolo.setForeground(Color.blue);
		panel.add(jouerSolo);
		panel.add(Box.createRigidArea(new Dimension(0, 0)));

		jouerMulti = new JButton("Jouer en Multi!");
		jouerMulti.setForeground(Color.blue);
		panel.add(jouerMulti);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		classement = new JButton("Classement");
		classement.setForeground(Color.blue);
		panel.add(classement);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		jouerSolo.addActionListener(this);
		jouerMulti.addActionListener(this);
		classement.addActionListener(this);
		// Création buttons
		mf.add(panel);
		repaint(Main.mf);
	}

	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		// Vérification du button pressé

		System.out.println(Main.game.currentMode);

		if (source == jouerSolo) {
			System.out.println("Jouer en Solo!");
			Main.game.currentMode = true;
			enterGameInfo();
			// On launch le jeu en Solo

		} else if (source == jouerMulti) {
			System.out.println("Jouer en Multi!");
			Main.game.currentMode = false;
			enterGameInfo();
			// On launch le jeu en Multi

		} else if (source == classement) {
			System.out.println("Classement");
			// Lancement du classement
		// On clear la fenêtre
		}
		if (source == start) {
			try {
				Main.game.maxScore = Integer.parseInt(numberOfPoints.getText());
				if (Integer.parseInt(numberOfPoints.getText()) < 1) {
					Main.game.maxScore = 10;
				}
			} catch (NumberFormatException ex) {
				Main.game.maxScore = 10;
			}
			System.out.println(Main.game.maxScore);
			startGame();
		}
	}

	private void enterGameInfo() {
		panel.setVisible(false);
		
		gameInfoPanel.setBackground(Color.white);
		
		GridBagLayout layout2 = new GridBagLayout();
		gameInfoPanel.setLayout(layout2);
		
		numberOfPoints = new JTextField(2);
		JTextArea text1 = new JTextArea("Enter number of points to win : ");
		start = new JButton("Start game!");
		start.setForeground(Color.blue);
		start.addActionListener(this);
		
		gameInfoPanel.add(text1);
		gameInfoPanel.add(numberOfPoints);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END; 
		
		gameInfoPanel.add(start, c);
		Main.mf.add(gameInfoPanel);
		gameInfoPanel.setVisible(true);
		repaint(Main.mf);
	}
	
	private void startGame() {
		gameInfoPanel.setVisible(false);
		
		MainTimer timer = new MainTimer();
		GameFrame gFrame = new GameFrame();
		
		gFrame.frame();
		timer.createTimer();
		gFrame.start();
	}

	public void repaint(final MainFrame mf) {
		mf.validate();
		mf.repaint();
	}
}