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

import mainPackage.Game;
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
		//Creation of panel and components
		panel.setBackground(Color.WHITE);
		
		GridLayout layout = new GridLayout(0, 1, 10, 10);
		panel.setLayout(layout);

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
		mf.add(panel);
		repaint(Main.mf);
	}

	public void actionPerformed(ActionEvent e)  {
		//Check if button pressed
		Object source = e.getSource();

		System.out.println(Main.game.currentMode);
		
		//Main buttons
		if (source == jouerSolo) {
			System.out.println("Jouer en Solo!");
			Main.game.currentMode = true;
			enterGameInfo();

		} else if (source == jouerMulti) {
			System.out.println("Jouer en Multi!");
			Main.game.currentMode = false;

		} else if (source == classement) {
			System.out.println("Classement");
		}
		//Button for selecting number of points for win
		if (source == start) {
			try {
				//Setting maxScore
				Game.maxScore = Integer.parseInt(numberOfPoints.getText());
				if (Integer.parseInt(numberOfPoints.getText()) < 1) {
					Game.maxScore = 10;
				}
			} catch (NumberFormatException ex) {
				//Wrong value
				Game.maxScore = 10;
			}
			System.out.println(Game.maxScore);
			startGame();
		}
	}

	private void enterGameInfo() {
		//Creation of panel for game settings
		Main.mf.remove(panel);
		
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
		
		//Setting layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END; 
		
		//Rendering frame
		gameInfoPanel.add(start, c);
		Main.mf.add(gameInfoPanel);
		gameInfoPanel.setVisible(true);
		repaint(Main.mf);
	}
	
	private void startGame() {
		//Starting the game
		
		gameInfoPanel.setVisible(false);
		
		GameFrame gFrame = new GameFrame();
		MainTimer timer = new MainTimer();
		
		gFrame.frame();
		gFrame.start();
		timer.createTimer();
		
		Main.mf.remove(gameInfoPanel);
	}

	public void repaint(final MainFrame mf) {
		//Refreshing frame
		mf.validate();
		mf.repaint();
	}
}
