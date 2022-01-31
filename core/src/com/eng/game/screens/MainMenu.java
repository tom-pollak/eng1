package com.eng.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.eng.game.PirateGame;

/**
 * Creates the main menu
 * Is the opening menu and gets returned to after the win/loss screen
 */

public class MainMenu implements Screen {

    private final Texture background;


    private final BitmapFont font;

    private final int backgroundx;
    private final int backgroundy;



    PirateGame game;

    public MainMenu(PirateGame game) {
        this.game = game;
        // Gets texture paths and sets the camera
        background = new Texture("img/Background.PNG");
        backgroundx = (int)(background.getWidth() * 1.1);
        backgroundy = (int)(background.getHeight() / 1.1);


        // Sets text style
        font = new BitmapFont();
        font.setColor(1, 1,1, 1);
        font.getData().setScale(backgroundx / 300, backgroundy / 300);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Draws the background and the button
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background, 0, 0, backgroundx, backgroundy);
        font.draw(game.batch, "Press space to start", backgroundx / 4 + 25, backgroundy / 2);


        // change scene when space bar is pressed
        if ((Gdx.input.isKeyJustPressed(Input.Keys.SPACE))){
            this.dispose();
            game.setScreen(new Play((game)));
        }
        game.batch.end();

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
        // Stop using textures when the screen changes
        background.dispose();
        font.dispose();
    }
}
