package common;

import javax.swing.JComponent;
import javax.swing.JPanel;

import frame.MainFrame;

public class GUIHelper {

	JPanel panel = new JPanel();

	public static void show(final MainFrame mf, JComponent component) {
		mf.getContentPane().add(component);

	}
}
