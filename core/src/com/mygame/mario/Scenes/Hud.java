package com.mygame.mario.Scenes;

/*import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygame.mario.MainClass;
//
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.awt.Color;
import java.awt.Label;*/

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygame.mario.MainClass;

public class Hud implements Disposable{
    public Stage stage;
    private Viewport viewport;

    private static Integer score;
    private Integer time; //InGame time
    private float countTime;

    private Label lcount;
    private static Label lscore;
    private Label ltime;
    private Label llevel;
    private Label lworld;
    private Label lmario;

    public Hud(SpriteBatch sbatch) {
        time = 300;
        countTime = 0;
        score = 0;

        viewport = new FitViewport(MainClass.V_WIDTH, MainClass.V_HEIGTH, new OrthographicCamera()); //Creates camera with set dimensions
        stage = new Stage(viewport, sbatch);

        Table table = new Table();
        table.bottom();
        table.setFillParent(true);

        //define labels
        lcount = new Label(String.format("%03d", time), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lscore = new Label(String.format("%06d", score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ltime = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        llevel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lworld = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lmario = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //organize table

            //first line
        table.add(lmario).expandX().padBottom(5);
        table.add(lworld).expandX().padBottom(5);
        table.add(ltime).expandX().padBottom(5);
            //second line
        table.row();
        table.add(lscore).expandX().padBottom(350);
        table.add(llevel).expandX().padBottom(350);
        table.add(lcount).expandX().padBottom(350);

        MainClass.manager.get("Audio/music/mario_music.ogg",Music.class).play();
        stage.addActor(table);
    }

    public void update (float fl)
    {
        countTime += fl;
        if(countTime >= 1)
        {
            time--;
            lcount.setText(String.format("%03d", time));
            countTime = 0;
        }
        else if(time <= 0){

            //KILL MARIO
        }
    }

    public static void updateScore(int value)
    {
        score += value;
        lscore.setText(String.format("%06d", score));
    }


    @Override
    public void dispose() {
        stage.dispose();

    }
}
