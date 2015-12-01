package ui;

import game.core.Square;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SquareUI extends JPanel {
	private static final long serialVersionUID = 7742451930906873750L;
	
	private Square square;
	
	public SquareUI(Square s) {
		square = s;
		setPreferredSize(new Dimension(60, 60));
	}
	
	public Square getSquare() { return square; }
	
	public void paintComponent(Graphics g) {
		drawBackground(g);
	}
	
	private void drawBackground(Graphics g) {
		g.setColor(square.getState().color());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	
}
