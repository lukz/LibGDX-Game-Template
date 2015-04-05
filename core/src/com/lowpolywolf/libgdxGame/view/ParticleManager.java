package com.lowpolywolf.libgdxGame.view;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lowpolywolf.libgdxGame.LibgdxGame;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class ParticleManager {

    private Array<ParticleEffectPool> effectPools = new Array();
    private Array<ParticleEffectPool.PooledEffect> runningEffects = new Array();

    /*
     * Effects ids
     */
//    public static final short SAMPLE_EFFECT = 0;

    public ParticleManager() {
        ParticleEffect temp;

        // COIN_EFFECT = 0
//        temp = LibgdxGame.assets.get("particles/sample.p", ParticleEffect.class);
//        effectPools.add(new ParticleEffectPool(temp, 10, 100));

    }

    public void update(float dt) {
        for (int i = runningEffects.size - 1; i >= 0; i--) {
            ParticleEffectPool.PooledEffect effect = runningEffects.get(i);
            effect.update(dt);
            if (effect.isComplete()) {
                effect.free();
                runningEffects.removeIndex(i);
            }
        }

    }

    public void draw(SpriteBatch batch) {
        for (int i = runningEffects.size - 1; i >= 0; i--) {
            runningEffects.get(i).draw(batch);
        }
    }

    /*
     * Reset all effects that are still alive
     */
    public void reset() {
        for (int i = runningEffects.size - 1; i >= 0; i--)
            runningEffects.get(i).free();
        runningEffects.clear();
    }

    /*
     * Obtain effect, which parameters can be changed.
     * Configured effect should be spawned by addEffect(effect);
     */
    public ParticleEffectPool.PooledEffect obtainEffect(short effectId) {
        return effectPools.get(effectId).obtain();
    }

    /*
     * Adds effect to render
     */
    public void addEffect(ParticleEffectPool.PooledEffect effect) {
        runningEffects.add(effect);
    }

    public void dispose() {

    }

}
