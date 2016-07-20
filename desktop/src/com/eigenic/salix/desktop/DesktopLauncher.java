package com.eigenic.salix.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eigenic.salix.SxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Salix";
		config.width = 16 * 80;
		config.height = 9 * 80;
		new LwjglApplication(new SxGame(), config);
	}
}
