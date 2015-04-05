package com.lowpolywolf.libgdxGame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lowpolywolf.libgdxGame.LibgdxGame;
import com.lowpolywolf.libgdxGame.model.GameWorld;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class WorldRenderer {

    private GameWorld world;
    private OrthographicCamera cam;
    private SpriteBatch batch;

    public WorldRenderer(GameWorld world) {
        this.world = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());

        batch = new SpriteBatch();
    }

    public void render(float delta) {
        // Set cam position here
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        world.getMap().draw(batch, delta);

        batch.end();

        if (LibgdxGame.DEBUG) {
            world.getBox2dworld().render(cam);
        }
    }

    public void resize(int width, int height) {

    }

    public OrthographicCamera getCamera() {
        return cam;
    }

    public void dispose() {
        batch.dispose();
    }
}
