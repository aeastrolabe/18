package game.core;

import ui.BoardUI;

public class Board {
	
	public int width = 8;
	public int height = 6;
	
	public BoardUI boardUI;

	private Square[][] squares = null;

	/** walls is a 2*_ array with _ = w x(h+1) and (w+1)x h
	First horizontal walls, then vertical */
	private Wall[][][] walls = null;
	
	public Board() {
		createSquares();
		createWalls();
		boardUI = new BoardUI(this);
	}
	
	private void createSquares() {
		squares = new Square[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				squares[i][j] = new Square();
			}
		}
	}
	
	private void createWalls() {
		walls = new Wall[2][][];
		walls[0] = new Wall[width][height+1];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height+1; j++) {
				walls[0][i][j] = new Wall();
			}
		}
		walls[1] = new Wall[width+1][height];
		for(int i = 0; i < width+1; i++) {
			for(int j = 0; j < height; j++) {
				walls[1][i][j] = new Wall();
			}
		}
	}
	
	public Square[][] getSquares() { return squares; }
	public void setSquares(Square[][] squares) { this.squares = squares; }
	
	public Square getSquare(int i, int j) { return squares[i][j]; }
	public void setSquare(Square square, int i, int j) {this.squares[i][j] = square; }
	public Square getSquare(Square s, Direction d) {
		switch (d) {
		case UP:
			return this.squares[s.getX()][s.getY()-1];
		case DOWN:
			return this.squares[s.getX()-1][s.getY()+1];
		case LEFT:
			return this.squares[s.getX()-1][s.getY()];
		case RIGHT:
			return this.squares[s.getX()+1][s.getY()];
		}
		return null;
	}
	
	public Wall[][][] getWalls() { return walls; }
	public void setWalls(Wall[][][] walls) { this.walls = walls; }
	
	/** walls is a 2*_ array with _ = w x(h+1) and h x(w+1)
	First horizontal walls, then vertical */
	public Wall getWall(int i, int j, int o) { return walls[o][i][j]; }
	public void setWall(Wall wall, int i, int j, int o) { this.walls[o][i][j] = wall; }
	public Wall getWall(Square square, Direction d) {
		try {
			switch (d) {
			case UP:
				return this.walls[0][square.getX()][square.getY()];
			case DOWN:
				return this.walls[0][square.getX()][square.getY()+1];
			case LEFT:
				return this.walls[1][square.getX()][square.getY()];
			case RIGHT:
				return this.walls[1][square.getX()][square.getY()+1];
			}
			return null;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public void explosionAt(int i, int j) {
		Square s = getSquare(i, j);
		explosionAtAlong(s, Direction.UP);
		explosionAtAlong(s, Direction.LEFT);
		explosionAtAlong(s, Direction.DOWN);
		explosionAtAlong(s, Direction.RIGHT);
	}
	
	private boolean explosionAtAlong(Square s, Direction d) {
		Square currentSquare = s;
		while (explosionAtAlongStep(currentSquare, d)) {
			currentSquare = getSquare(currentSquare, d);
			if (currentSquare == null) { return false; }
		}
		return true;
	}
	
	/**
	 * Carefull, this method has side-effects !!!
	 * @param Square s
	 * @param Direction d
	 * @return whether the wall explosion succeeded
	 */
	private boolean explosionAtAlongStep(Square s, Direction d) {
		if (s.getState() == SState.EMPTY) {
			s.setState(SState.FIRE);
			return true;
		}
		else {
			return getWall(s,d).dealExplosionDamage();
		}
	}

	public boolean propagateFire() {
		while (!propagatedFireStep()) {	};
		return true;
	}
	
	private boolean propagatedFireStep() {
		Square[][] squaresSaved = squares.clone();
		for(Square[] row : squares) {
			for(Square s : row) {
				if (s.getState() == SState.FIRE) {
					for(Direction d : Direction.values()) {
						Square n = getSquare(s, d);
						if (n != null && n.getState() == SState.FUMES) {
							n.setState(SState.FIRE);
						}
					}
				}
			}
		}
		return squaresSaved.equals(squares);
	}
}
