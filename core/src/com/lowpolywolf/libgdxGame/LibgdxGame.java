package com.lowpolywolf.libgdxGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.lowpolywolf.libgdxGame.model.Assets;
import com.lowpolywolf.libgdxGame.screens.LoadingScreen;

public class LibgdxGame extends Game {

    public static final boolean DEBUG = true;
    public static final float TARGET_WIDTH = 1024;
    public static final float TARGET_HEIGHT = 576;

    public static Assets assets;

    private FPSLogger log;

    public LibgdxGame() {
        this.log = new FPSLogger();
    }

    @Override
    public void create () {
        assets = new Assets();
        log = new FPSLogger();

        this.setScreen(new LoadingScreen(this));
    }

    @Override
    public void render () {
        super.render();
        log.log();
    }

    @Override
    public void dispose() {
        super.dispose();
        assets.dispose();
    }
}
