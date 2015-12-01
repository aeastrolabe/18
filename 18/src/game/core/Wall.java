package game.core;

import ui.WallUI;

public class Wall {

	private boolean isSolid = false;
	private boolean isDoor = false; //a door is not a solid wall
	private boolean hasDoor = false;
	private boolean isDoorOpen = false;
	private int damage = 0;
	private boolean isHorizontal = false;
	public int i , j;
	
	public WallUI ui;
	
	public Wall(int i, int j, boolean hor) {
		this.i = i;
		this.j = j;
		isHorizontal = hor;
		ui = new WallUI(this);
	}
	
	public boolean isSolid() { return isSolid; }
	public void setSolid(boolean isSolid) { this.isSolid = isSolid; }
	
	public boolean isDoor() { return isDoor; }
	public void setDoor(boolean isDoor) { this.isDoor = isDoor; }
	
	public boolean isHasDoor() { return hasDoor; }
	public void setHasDoor(boolean hasDoor) { this.hasDoor = hasDoor; }
	
	public boolean isDoorOpen() { return isDoorOpen; }
	public void setDoorOpen(boolean isDoorOpen) { this.isDoorOpen = isDoorOpen; }
	
	public int getDamage() { return damage; }
	public void setDamage(int damage) { this.damage = damage; }
	
	public boolean isHorizontal() { return isHorizontal; }
	public void setHorizontal(boolean isHorizontal) { this.isHorizontal = isHorizontal; }
	
	public boolean dealPlayerDamage() {
		if (isSolid) {
			if (damage < 2) damage++;
			if (damage == 2) isSolid = false;
			return true;
		}
		else { return false; }
	}
	
	public boolean dealExplosionDamage() {
		if (isSolid) {
			if (damage < 2) damage++;
			if (damage == 2) isSolid = false;
			return true;
		}
		else {
			if (isDoor && !isDoorOpen && hasDoor) { isDoorOpen = true; hasDoor = false; return true; } //a door that blew up is considered open
		}
		return false;
	}
}
