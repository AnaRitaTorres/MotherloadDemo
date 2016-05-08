package com.dalugoga.mother.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dalugoga.mother.MotherloadDemo;
import com.dalugoga.mother.scenes.Hud;

public class PlayScreen implements Screen{

    private MotherloadDemo game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    public PlayScreen(MotherloadDemo game){
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MotherloadDemo.V_WIDTH/2, MotherloadDemo.V_HEIGHT/2, gamecam);
        hud = new Hud(game.batch);

        maploader = new TmxMapLoader();
        map = maploader.load("map.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
    }

    @Override
    public void show(){

    }

    public void inputhandler(float dt){

        int x, y, dx, dy;
        if(Gdx.input.isTouched()) {
            x = Gdx.input.getX();
            y = Gdx.input.getY();


            dx = Gdx.graphics.getWidth()/2 - x;
            dy = Gdx.graphics.getHeight()/2 - y;

            gamecam.position.x -= dx *dt;
            gamecam.position.y += dy *dt;
        }
    }

    public void update(float dt)    {
        inputhandler(dt);
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        renderer.render();
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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

    }
}
