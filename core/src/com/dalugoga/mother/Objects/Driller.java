package com.dalugoga.mother.Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.dalugoga.mother.MotherloadDemo;

/**
 * Created by Daniel on 08/05/2016.
 */
public class Driller extends Sprite{
    public World world;
    public Body b2body;

    public Driller(World world){
        this.world = world;
        defineDriller();
    }

    public void defineDriller(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(40/ MotherloadDemo.PPM,1500/ MotherloadDemo.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/ MotherloadDemo.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}
