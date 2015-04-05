package com.lowpolywolf.libgdxGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.lowpolywolf.libgdxGame.LibgdxGame;
import com.lowpolywolf.libgdxGame.input.DefaultInputHandler;
import com.lowpolywolf.libgdxGame.model.Box2DWorld;
import com.lowpolywolf.libgdxGame.model.GameWorld;
import com.lowpolywolf.libgdxGame.model.maps.Map;
import com.lowpolywolf.libgdxGame.model.maps.TestMap;
import com.lowpolywolf.libgdxGame.view.WorldRenderer;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class GameScreen implements Screen {

    public LibgdxGame game;

    /** Logic */
    private GameWorld world;
    private Box2DWorld box2DWorld;

    /** Renderer */
    private WorldRenderer render;

    /*
	 * Things for Fixed Timestep - look into render for implementation and docs
	 */
    private float fixedTimestepAccumulator = 0f;
    private final float MAX_ACCUMULATED_TIME = 1.0f;
    private final float TIMESTEP = 1/60f;

    public GameScreen(LibgdxGame game) {
        this.game = game;

        this.box2DWorld = new Box2DWorld(new Vector2(0, 0));

        Map map = new TestMap(box2DWorld);
        this.world = new GameWorld(box2DWorld, map);
        this.render = new WorldRenderer(world);

        Gdx.input.setInputProcessor(new DefaultInputHandler(game));
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        /*
		 * Implementation of fixed timestep
		 * docs:
		 * - http://gafferongames.com/game-physics/fix-your-timestep/
		 * - http://temporal.pr0.pl/devblog/download/arts/fixed_step/fixed_step.pdf
		 */

        fixedTimestepAccumulator += delta;
        if(fixedTimestepAccumulator > MAX_ACCUMULATED_TIME)
            fixedTimestepAccumulator = MAX_ACCUMULATED_TIME;

        while (fixedTimestepAccumulator >= TIMESTEP) {

			/*
			 * Update physics
			 */
            box2DWorld.update(TIMESTEP);
            world.update(TIMESTEP);

            fixedTimestepAccumulator -= TIMESTEP;
        }

		/*
		 * Render
		 */
        render.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        render.resize(width, height);
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
        world.dispose();
        render.dispose();
    }
}
