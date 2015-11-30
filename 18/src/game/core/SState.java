package game.core;

import java.awt.Color;

public enum SState {
EMPTY, FUMES, FIRE;

private Color color;

static {
	EMPTY.color = Color.green;
	FUMES.color = Color.white;
	FIRE.color = Color.red;
}

	public Color color() {
		return color;
	}
}
