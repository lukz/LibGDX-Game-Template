package com.lowpolywolf.libgdxGame.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class Assets extends AssetManager {

    // Textures
    public final String SampleTex = "badlogic.jpg";

    // Sounds

    // Fonts

    // Skins

    // Particles

    public Assets() {
        enqueueAssets();
    }

    public void enqueueAssets() {
        // Textures
        load(SampleTex, Texture.class);

        // Sounds

        // Fonts

        // Skins

        // Particles

    }


}
