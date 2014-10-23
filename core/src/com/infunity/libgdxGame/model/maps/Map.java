package com.infunity.libgdxGame.model.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.infunity.libgdxGame.model.Box2DWorld;
import com.infunity.libgdxGame.model.EntityManager;
import com.infunity.libgdxGame.view.ParticleManager;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class Map {

    protected EntityManager entMan;
    protected ParticleManager particleManager;

    protected Box2DWorld box2dworld;
//    protected Player player;

    protected Map(Box2DWorld box2dworld) {
        this.box2dworld = box2dworld;
        this.entMan = new EntityManager(this);

        this.particleManager = new ParticleManager();
    }

    public void update(float delta) {
        entMan.update(delta);
    }

    public void draw(SpriteBatch batch, float delta) {
        entMan.draw(batch);

        particleManager.update(delta);
        particleManager.draw(batch);
    }

    public void resetGame() {
        entMan.reset();
    }

    public void dispose() {
        entMan.dispose();
    };
}
