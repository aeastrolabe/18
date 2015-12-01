package game.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.SquareUI;

public class BoardHandler implements MouseListener {
	
	private Board board;
	
	public BoardHandler(Board b) {
		board = b;
	}

	@Override
 	public void mouseClicked(MouseEvent e) {
		SquareUI sui = ((SquareUI) e.getSource());
		System.out.println(sui.getSquare().getBoard() == null);
		System.out.println(sui.getSquare().getX()+"   "+sui.getSquare().getY());
		System.out.println(sui.getSquare().getBoard().getSquare(sui.getSquare(), Direction.UP).getX());
		System.out.println(sui.getSquare().getBoard().getSquare(sui.getSquare(), Direction.UP).getY());
		System.out.println(sui.getSquare().getState());
		sui.getSquare().getBoard().explosionAt(sui.getSquare().getX(), sui.getSquare().getY());
		board.boardUI.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
