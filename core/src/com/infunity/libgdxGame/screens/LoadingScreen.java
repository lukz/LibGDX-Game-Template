package com.infunity.libgdxGame.screens;

import com.badlogic.gdx.Screen;
import com.infunity.libgdxGame.LibgdxGame;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class LoadingScreen implements Screen {

    private LibgdxGame game;

    public LoadingScreen(LibgdxGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        /** If assets loaded go to MainMenu */
        if(game.assets.update()) {
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
