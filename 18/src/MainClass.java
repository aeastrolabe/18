

import game.Game;
import ui.Viewport;

public class MainClass {
	
	private static Viewport viewport = null;

	public static void main(String[] args) {
		//Initialize Game variables

		//Create the UI
		viewport = new Viewport();
		
		//Create new game
		new Game(viewport);
	}

}
