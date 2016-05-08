package com.dalugoga.mother;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dalugoga.mother.screens.PlayScreen;

public class MotherloadDemo extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 300;
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
