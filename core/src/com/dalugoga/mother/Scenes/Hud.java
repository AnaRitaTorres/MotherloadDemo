package com.dalugoga.mother.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dalugoga.mother.MotherloadDemo;

/**
 * Created by Daniel on 07/05/2016.
 */
public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer fuel;
    private Integer health;
    private Integer score;

    Label fuelLabel;
    Label healthLabel;
    Label scoreLabel;

    public Hud(SpriteBatch sb){
        fuel = 10;
        health = 100;
        score = 0;

        viewport  = new FitViewport(MotherloadDemo.V_WIDTH*2, MotherloadDemo.V_HEIGHT*2, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        fuelLabel = new Label(String.format("fuel: %03d/%3d", fuel, 010), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthLabel = new Label(String.format("health: %03d%%", health), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("score: %09d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(fuelLabel).expandX().padTop(10);
        table.add(healthLabel).expandX().padTop(10);
        table.add(scoreLabel).expandX().padTop(10);


        stage.addActor(table);
    }


}
