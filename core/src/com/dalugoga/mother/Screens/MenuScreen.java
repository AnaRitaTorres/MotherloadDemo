package com.dalugoga.mother.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dalugoga.mother.MotherloadDemo;

public class MenuScreen implements Screen {

    private MotherloadDemo game;
    Texture Mback;
    private OrthographicCamera menuCam;
    private Viewport menuPort;

    public MenuScreen(MotherloadDemo game) {
        this.game = game;
        Mback = new Texture("MenuBackground.png");
        menuCam = new OrthographicCamera();
        menuCam.setToOrtho(false, 1920, 1030);
        menuPort = new FitViewport(1920,1030, menuCam);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuCam.update();
        game.batch.setProjectionMatrix(menuCam.combined);
        game.batch.begin();
        game.batch.draw(Mback, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        menuPort.update(width,height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Mback.dispose();
    }
}