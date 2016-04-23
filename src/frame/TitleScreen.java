package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.StartGame;
import mainPackage.Game;

@SuppressWarnings("serial")
public class TitleScreen extends JFrame implements ActionListener {

	JButton jouerSolo;
	JButton jouerMulti;
	JButton classement;
	JPanel panel = new JPanel();
	
	public void createScreen(final MainFrame mf) {

		//panel.setBackground(Color.WHITE);
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
		mf.validate();
		mf.repaint();
	}

	
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		// Vérification du button pressé

		Game game = new Game(null, null, 0);
		StartGame start = new StartGame();
		
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
			// Lancement du classement
		}

		System.out.println(game.mode);

		panel.setVisible(false);
		// On clear la fenêtre
	}

}
