package com.mygame.mario.Logic;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygame.mario.Characters.Bricks;
import com.mygame.mario.Characters.Qmark;
import com.mygame.mario.MainClass;

public class LoadMap {

    private BodyDef bodyd;
    private PolygonShape shape;
    private FixtureDef fixtured;
    private Body body;
    private Qmark qmark;
    private Bricks bricks;

    public LoadMap (World world, TiledMap map)
    {
        bodyd = new BodyDef();
        shape = new PolygonShape();
        fixtured = new FixtureDef();

        recognizeMap(world, map);
    }


    void recognizeMap(World world, TiledMap map){

        // recognize empty block
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bodyd.type = BodyDef.BodyType.StaticBody;
            bodyd.position.set((rectangle.getX() + rectangle.getWidth() / 2) / MainClass.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / MainClass.PPM);

            body = world.createBody(bodyd);

            shape.setAsBox(rectangle.getWidth() / 2 / MainClass.PPM, rectangle.getHeight() / 2 / MainClass.PPM);
            fixtured.shape = shape;
            body.createFixture(fixtured);
        }

        // recognize ground
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bodyd.type = BodyDef.BodyType.StaticBody;
            bodyd.position.set((rectangle.getX() + rectangle.getWidth() / 2) / MainClass.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / MainClass.PPM);

            body = world.createBody(bodyd);

            shape.setAsBox(rectangle.getWidth() / 2 / MainClass.PPM, rectangle.getHeight() / 2 / MainClass.PPM);
            fixtured.shape = shape;
            body.createFixture(fixtured);
        }

        // recognize bricks
        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bricks = new Bricks(world, map, rectangle);
        }

        // recognize pipes
        for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bodyd.type = BodyDef.BodyType.StaticBody;
            bodyd.position.set((rectangle.getX() + rectangle.getWidth() / 2) / MainClass.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / MainClass.PPM);

            body = world.createBody(bodyd);

            shape.setAsBox(rectangle.getWidth() / 2 / MainClass.PPM, rectangle.getHeight() / 2 / MainClass.PPM);
            fixtured.shape = shape;
            body.createFixture(fixtured);
        }

        // recognize stairs
        for (MapObject object : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bodyd.type = BodyDef.BodyType.StaticBody;
            bodyd.position.set((rectangle.getX() + rectangle.getWidth() / 2) / MainClass.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / MainClass.PPM);

            body = world.createBody(bodyd);

            shape.setAsBox(rectangle.getWidth() / 2 / MainClass.PPM, rectangle.getHeight() / 2 / MainClass.PPM);
            fixtured.shape = shape;
            body.createFixture(fixtured);
        }

        // recognize pipe level
        for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bodyd.type = BodyDef.BodyType.StaticBody;
            bodyd.position.set((rectangle.getX() + rectangle.getWidth() / 2) / MainClass.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / MainClass.PPM);

            body = world.createBody(bodyd);

            shape.setAsBox(rectangle.getWidth() / 2 / MainClass.PPM, rectangle.getHeight() / 2 / MainClass.PPM);
            fixtured.shape = shape;
            body.createFixture(fixtured);
        }

        // recognize question mark block
        for (MapObject object : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            qmark = new Qmark(world, map, rectangle);
        }

    }
}
