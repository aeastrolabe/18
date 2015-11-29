package game;

import ui.Viewport;

public class Main {
	
	private static Viewport viewport;

	public static void main(String[] args) {
		//Initialize Game variables
		
		//Create the UI
		viewport = new Viewport();
		
		//Create new game
		new Game(viewport);
	}

}
