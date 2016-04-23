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
import mainPackage.Main;

@SuppressWarnings("serial")
public class TitleScreen extends JFrame implements ActionListener {

	JButton jouerSolo;
	JButton jouerMulti;
	JButton classement;
	JPanel panel = new JPanel();

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

		System.out.println(Main.game.mode);

		StartGame start = new StartGame();

		if (source == jouerSolo) {
			System.out.println("Jouer en Solo!");
			Main.game.mode = true;
			// On launch le jeu en Solo

		} else if (source == jouerMulti) {
			System.out.println("Jouer en Multi!");
			Main.game.mode = false;
			// On launch le jeu en Multi

		} else {
			System.out.println("Classement");
			// Lancement du classement
		}
		// On clear la fenêtre
		panel.setVisible(false);
		repaint(Main.mf);
		start.start();
	}

	public void repaint(final MainFrame mf) {
		mf.validate();
		mf.repaint();
	}

}
