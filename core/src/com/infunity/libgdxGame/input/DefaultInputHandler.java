package com.infunity.libgdxGame.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.infunity.libgdxGame.LibgdxGame;
import com.infunity.libgdxGame.screens.GameScreen;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class DefaultInputHandler implements InputProcessor {

    private LibgdxGame game;

    public DefaultInputHandler(LibgdxGame game) {
        this.game = game;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.R:
                game.setScreen(new GameScreen(game));
                return true;
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
