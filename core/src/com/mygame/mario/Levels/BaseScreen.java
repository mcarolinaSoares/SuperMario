package com.mygame.mario.Levels;

import com.badlogic.gdx.Screen;
import com.mygame.mario.MainClass;

public abstract class BaseScreen implements Screen {

    protected MainClass game;

    public BaseScreen(MainClass game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
