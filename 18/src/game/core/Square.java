package game.core;

import ui.SquareUI;

public class Square {

	/* Members */
	
	private Board board;
	private int x,y;
	private SState state = SState.EMPTY;
	private Players[] players = null;
	private boolean hotspot = false;
	private boolean hazard = false;
	private boolean hasGuy = false;
	private Guy guy = null;
	private boolean ambulanceParking = false;
	private boolean hasAmbulance = false;
	private boolean firetruckParking = false;
	private boolean hasFiretruck = false;
	
	public SquareUI ui;
	
	public Square(int i, int j) {
		x = i;
		y = j;
		
		ui = new SquareUI(this);
	}
	
	/* Methods */
	
	public Board getBoard() { return board; }
	public void setBoard(Board board) { this.board = board; }

	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	
	public SState getState() { return state; }
	public void setState(SState state) { this.state = state; }
	
	public Players[] getPlayers() { return players; }
	public void setPlayers(Players[] players) { this.players = players; }
	
	public boolean isHotspot() { return hotspot; }
	public void setHotspot(boolean hotspot) { this.hotspot = hotspot; }
	
	public boolean isHazard() { return hazard; }
	public void setHazard(boolean hazard) { this.hazard = hazard; }
	
	public boolean hasGuy() { return hasGuy; }
	public void setHasGuy(boolean hasGuy) { this.hasGuy = hasGuy; }
	
	public Guy getGuy() { return guy; }
	public void setGuy(Guy guy) { this.guy = guy; }
	
	public boolean isAmbulanceParking() { return ambulanceParking; }
	public void setAmbulanceParking(boolean ambulanceParking) { this.ambulanceParking = ambulanceParking; }
	
	public boolean isHasAmbulance() { return hasAmbulance; }
	public void setHasAmbulance(boolean hasAmbulance) { this.hasAmbulance = hasAmbulance; }
	
	public boolean isFiretruckParking() { return firetruckParking; }
	public void setFiretruckParking(boolean firetruckParking) { this.firetruckParking = firetruckParking; }
	
	public boolean isHasFiretruck() { return hasFiretruck; }
	public void setHasFiretruck(boolean hasFiretruck) { this.hasFiretruck = hasFiretruck; }
	
	public Wall[] getWalls() {
		return null;
	}
	
	// True means the propagation ended, false means it needs to be propagated further
	public boolean propagateExplosion(Direction d) {
		return true;
	}

}
