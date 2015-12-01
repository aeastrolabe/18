package ui;

import game.core.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

public class BoardUI extends JPanel {
	private static final long serialVersionUID = -3166208994182265328L;

	private Board board;
	
	private JPanel[][] pillars;
	
	public int squareWH = 30;
	public int wallW = 5, wallH = 30;
	
	public BoardUI(Board b) {
		board = b;
		createPillars();
		createLayout();
		
		setBackground(Color.LIGHT_GRAY);
	}
	
 	private void createPillars() {
		pillars = new JPanel[board.width+1][board.height+1];
		for(int i = 0; i <board.width+1; i++) {
			for(int j = 0; j < board.height+1; j++) {
				pillars[i][j] = new JPanel();
				pillars[i][j].setBackground(Color.LIGHT_GRAY);
				pillars[i][j].setPreferredSize(new Dimension(wallW, wallW));
			}
		}
	}
	
	public void createLayout() {
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		this.setMaximumSize(new Dimension(board.width*squareWH + (board.width+1)*wallW, board.height*squareWH + (board.height+1)*wallW));
		
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
			sqgroup.addGroup(createLayoutRowWithPillars(layout, i))
				   .addGroup(createLayoutRowWithoutPillars(layout, i));
		}
		sqgroup.addGroup(createLayoutRowWithPillars(layout, board.width));
		return sqgroup;
	}
	
	private SequentialGroup createVerticalGroup(GroupLayout layout) {
		SequentialGroup sqgroup = layout.createSequentialGroup();
		for(int j = 0; j < board.height; j++) {
			sqgroup.addGroup(createLayoutColWithPillars(layout, j))
				   .addGroup(createLayoutColWithoutPillars(layout, j));
		}
		sqgroup.addGroup(createLayoutColWithPillars(layout, board.height));
		return sqgroup;
	}
	
	private ParallelGroup createLayoutRowWithPillars(GroupLayout layout, int i) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
		for(int j = 0; j < board.height; j++) {
			parallelgroup.addComponent(pillars[i][j]);
			parallelgroup.addComponent(board.getWall(i, j, 1).ui);
		}
		parallelgroup.addComponent(pillars[i][board.height]);
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutRowWithoutPillars(GroupLayout layout, int i) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
		for(int j = 0; j < board.height; j++) {
			parallelgroup.addComponent(board.getWall(i, j, 0).ui);
			parallelgroup.addComponent(board.getSquare(i, j).ui);
		}
		parallelgroup.addComponent(board.getWall(i, board.height, 0).ui);
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutColWithoutPillars(GroupLayout layout, int j) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		for(int i = 0; i < board.width; i++) {
			parallelgroup.addComponent(board.getWall(i, j, 1).ui);
			parallelgroup.addComponent(board.getSquare(i, j).ui);
		}
		parallelgroup.addComponent(board.getWall(board.width, j, 1).ui);
		return parallelgroup;
	}
	
	private ParallelGroup createLayoutColWithPillars(GroupLayout layout, int j) {
		ParallelGroup parallelgroup = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		for(int i = 0; i < board.width; i++) {
			parallelgroup.addComponent(pillars[i][j]);
			parallelgroup.addComponent(board.getWall(i, j, 0).ui);
		}
		parallelgroup.addComponent(pillars[board.width][j]);
		return parallelgroup;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.paintComponents(g);
	}
}
