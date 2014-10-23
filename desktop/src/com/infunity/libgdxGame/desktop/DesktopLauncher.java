package com.infunity.libgdxGame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.infunity.libgdxGame.LibgdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1024;
        config.height = 576;

		new LwjglApplication(new LibgdxGame(), config);
	}
}
