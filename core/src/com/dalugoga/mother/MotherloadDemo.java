package com.dalugoga.mother;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dalugoga.mother.Screens.PlayScreen;

public class MotherloadDemo extends Game {
	public static final int V_WIDTH = 400/2;
	public static final int V_HEIGHT = 500/2;
	public static final float PPM = 16;
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
