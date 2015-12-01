package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Viewport extends JFrame {
	private static final long serialVersionUID = 6755198448470352739L;

	public Viewport() {
		super();
		getContentPane().setPreferredSize(new Dimension(800,600));

		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
}
