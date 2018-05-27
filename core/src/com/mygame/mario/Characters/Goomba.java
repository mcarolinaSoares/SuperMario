package com.mygame.mario.Characters;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygame.mario.Levels.BaseScreen;
import com.mygame.mario.MainClass;

public class Goomba extends Enemys {

    private float timeGoomba;
    private Array<TextureRegion> frames;
    private Animation <TextureRegion> goombaRun;

    public Goomba(BaseScreen screen, float x, float y) {
        super(screen, x, y);
        //screen.getTexAtlas().findRegion("Sprites_ready/goomba_edited")

        frames = new Array<TextureRegion> ();
        loadTextures(frames);
        timeGoomba = 0;

        setBounds(getX(), getY(), 16 / MainClass.PPM, 16 / MainClass.PPM);
    }


    public void loadTextures(Array<TextureRegion> frames) {

        for(int i = 0; i < 2; i++)
        {
            frames.add(new TextureRegion(screen.getTexAtlas().findRegion("Sprites_ready/goomba_edited"), i*16, 10, 16, 16));
        }
        goombaRun = new Animation(0.4f, frames);
        //frames.clear();
    }

    @Override
    protected void defineEnenmy() {
        BodyDef bodyd = new BodyDef();
        bodyd.position.set(12/ MainClass.PPM, 12/ MainClass.PPM);
        bodyd.type = BodyDef.BodyType.DynamicBody;

        body = world.createBody(bodyd);

        FixtureDef fixtured = new FixtureDef();
        CircleShape cshape = new CircleShape();
        cshape.setRadius(6 / MainClass.PPM);

        fixtured.filter.categoryBits = MainClass.ENEMY_BIT;
        fixtured.filter.maskBits = MainClass.DEFAULT_BIT | MainClass.COIN_BIT | MainClass.BRICK_BIT | MainClass.ENEMY_BIT |MainClass.OBJECT_BIT | MainClass.MARO_BIT;

        fixtured.shape = cshape;
        body.createFixture(fixtured);

    }

    public void update(float fl) {
        timeGoomba += fl;
        setPosition(body.getPosition().x - getRegionWidth() / 2, body.getPosition().y - getHeight() / 2);
        //setRegion((Texture) goombaRun.getKeyFrame(timeGoomba));
        setRegion(goombaRun.getKeyFrame(timeGoomba, true));
    }
}
