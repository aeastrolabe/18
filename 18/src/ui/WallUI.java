package ui;

import game.core.Wall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WallUI extends JPanel{
	private static final long serialVersionUID = -6119743875630827366L;
	
	private int tall = 60, slim = 5;

	private Wall wall;
	
	public WallUI(Wall w) {
		wall = w;
		setWallSize();
	}
	
	public void setWallSize() {
		if (wall.isHorizontal()) {
			this.setPreferredSize(new Dimension(tall, slim));
		}
		else {
			this.setPreferredSize(new Dimension(slim, tall));
		}
	}
	
	public void paintComponent(Graphics g){
		if (wall.isSolid() || wall.getDamage() == 2) {
			paintWallSolid(g);
		}
		else{
			paintWallNone(g);
		}
		if (wall.isDoor()) {
			if (wall.isHasDoor() && wall.isDoorOpen()) {
				paintOpenDoor(g);
			}
			if (wall.isHasDoor() && !wall.isDoorOpen()) {
				paintClosedDoor(g);
			}
			if (!wall.isHasDoor()) {
				paintNoDoor(g);
			}
		}
	}

	private void paintWallSolid(Graphics g) {
		switch(wall.getDamage()) {
		case 0:
			g.setColor(Color.WHITE);
			break;
		case 1:
			g.setColor(Color.GRAY);
			break;
		case 2:
			g.setColor(Color.BLACK);
			break;
		default:
			g.setColor(Color.RED);
			break;
		}
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	private void paintWallNone(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	

	private void paintOpenDoor(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	private void paintClosedDoor(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	private void paintNoDoor(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
