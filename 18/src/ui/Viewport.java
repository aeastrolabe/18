package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Viewport extends JFrame {
	private static final long serialVersionUID = 6755198448470352739L;

	public Viewport() {
		super();
		setSize(200,100);
		setVisible(true);
		setLayout(new BorderLayout());
	}
}
