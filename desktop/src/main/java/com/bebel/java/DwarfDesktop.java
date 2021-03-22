package com.bebel.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bebel.core.Dwarf;

public class DwarfDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Les Nains du Nord";
		config.width = 1920;
		config.height = 1080;
		config.backgroundFPS = 0;
		config.foregroundFPS = 0;
		config.fullscreen = true;
		config.resizable = false;
		config.vSyncEnabled = true;
		new LwjglApplication(new Dwarf(), config);
	}
}
