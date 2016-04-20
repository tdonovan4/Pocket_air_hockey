package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import common.StartGame;
import mainPackage.Game;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	Game game = new Game(null, null, 0);
	StartGame start = new StartGame();

	JFrame frame;
	JButton jouerSolo;
	JButton jouerMulti;
	JButton classement;
	JPanel panel;

	public MainFrame() {
		frame = new JFrame("Pocket air hockey");

		setLookAndFeel();
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Création frame

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		// Création panel

		GridLayout layout = new GridLayout(0, 1, 10, 10);
		panel.setLayout(layout);
		// Gérer la position des buttons

		panel.add(Box.createRigidArea(new Dimension(0, 0)));
		jouerSolo = new JButton("Jouer en Solo!");
		panel.add(jouerSolo);
		panel.add(Box.createRigidArea(new Dimension(0, 0)));

		jouerMulti = new JButton("Jouer en Multi!");
		panel.add(jouerMulti);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		classement = new JButton("Classement");
		panel.add(classement);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		jouerSolo.addActionListener(this);
		jouerMulti.addActionListener(this);
		classement.addActionListener(this);
		// Création buttons

		add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// Vérification du button pressé

		if (source == jouerSolo) {
			System.out.println("Jouer en Solo!");
			game.mode = true;
			start.start();
			// On launch le jeu en Solo

		} else if (source == jouerMulti) {
			System.out.println("Jouer en Multi!");
			game.mode = false;
			start.start();
			// On launch le jeu en Multi

		} else {
			System.out.println("Classement");
			//Lancement du classement
		}

		System.out.println(game.mode);

		panel.removeAll();
		panel.validate();
		panel.repaint();
		//On clear la fenêtre
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			// Méchante erreur!
		}
	}

}
