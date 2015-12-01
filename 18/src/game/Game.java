package game;

import java.awt.BorderLayout;

import game.core.Board;
import game.core.BoardType;
import game.core.Difficulty;
import game.core.Gamemode;
import ui.Viewport;

public class Game {
	
	/* Members */
	private Viewport viewport;
	
	private int Nplayers = 2;

	private Gamemode gamemode = Gamemode.BASIC;
	
	private Difficulty difficulty = Difficulty.EASY;
	
	private BoardType boardType = BoardType.EASY;
	
	private Board board = null; //initialize with gamemode, difficulty and board version



	/* Methods */
	
	public Game(Viewport v) {
		board = new Board();
		viewport = v;
		
		viewport.add(board.boardUI, BorderLayout.CENTER);
	}
	

	public int getNplayers() { return Nplayers; }
	public void setNplayers(int nplayers) { Nplayers = nplayers; } 

	public Gamemode getGamemode() { return gamemode; }
	public void setGamemode(Gamemode gamemode) { this.gamemode = gamemode; }
	
	public Difficulty getDifficulty() { return difficulty; }
	public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
	
	public BoardType getBoardType() { return boardType; }
	public void setBoardType(BoardType boardType) { this.boardType = boardType; }
	
	public Board getBoard() { return board; }
	public void setBoard(Board board) { this.board = board; }

	
}
