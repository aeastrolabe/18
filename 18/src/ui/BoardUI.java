package ui;

import game.core.Board;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

public class BoardUI extends JPanel {
	private static final long serialVersionUID = -3166208994182265328L;

	private Board board;
	
	private JPanel[][] pillars;
	
	public BoardUI(Board b) {
		board = b;
		createPillars();
		createLayout();
	}
	
 	private void createPillars() {
		pillars = new JPanel[board.width+1][board.height+1];
		for(int i = 0; i <board.width+1; i++) {
			for(int j = 0; j < board.height+1; j++) {
				pillars[i][j] = new JPanel();
				pillars[i][j].setBackground(Color.WHITE);
			}
		}
	}
	
	public void createLayout() {
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(false);
		layout.setAutoCreateContainerGaps(false);
		
		
		layout.setHorizontalGroup(
			createHorizontalGroup(layout)
		);
		layout.setVerticalGroup(
			createVerticalGroup(layout)
		);
	}
	
	private SequentialGroup createHorizontalGroup(GroupLayout layout) {
		SequentialGroup sqgroup = layout.createSequentialGroup();
		for(int i = 0; i < board.width; i++) {
			sqgroup.addGroup(createLayoutRow0(layout, i))
				   .addGroup(createLayoutRow1(layout, i));
		}
		sqgroup.addGroup(createLayoutRow0(layout, board.width));
		return sqgroup;
	}
	
	private SequentialGroup createVerticalGroup(GroupLayout layout) {
		SequentialGroup sqgroup = layout.createSequentialGroup();
		for(int i = 0; i < board.height; i++) {
			sqgroup.addGroup(createLayoutCol1(layout, i))
				   .addGroup(createLayoutCol0(layout, i));
		}
		sqgroup.addGroup(createLayoutCol1(layout, board.height));
		return sqgroup;
	}
	
	private ParallelGroup createLayoutRow1(GroupLayout layout, int i) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for(int j = 0; j < board.height; j++) {
			parallelgroup.addComponent(new WallUI(board.getWall(i, j, 0)));
			parallelgroup.addComponent(new SquareUI(board.getSquare(i, j)));
		}
		parallelgroup.addComponent(new WallUI(board.getWall(i, board.height, 0)));
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutRow0(GroupLayout layout, int i) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for(int j = 0; j < board.height; j++) {
			parallelgroup.addComponent(pillars[i][j]);
			parallelgroup.addComponent(new WallUI(board.getWall(i, j, 1)));
		}
		parallelgroup.addComponent(pillars[i][board.height]);
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutCol0(GroupLayout layout, int j) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for(int i = 0; i < board.width; i++) {
			parallelgroup.addComponent(new WallUI(board.getWall(i, j, 1)));
			parallelgroup.addComponent(new SquareUI(board.getSquare(i, j)));
		}
		parallelgroup.addComponent(new WallUI(board.getWall(board.width, j, 1)));
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutCol1(GroupLayout layout, int j) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for(int i = 0; i < board.width; i++) {
			parallelgroup.addComponent(pillars[i][j]);
			parallelgroup.addComponent(new WallUI(board.getWall(i, j, 0)));
		}
		parallelgroup.addComponent(pillars[board.width][j]);
		return parallelgroup;
	}
	
	public void paintComponent(Graphics g) {
		
	}
}
