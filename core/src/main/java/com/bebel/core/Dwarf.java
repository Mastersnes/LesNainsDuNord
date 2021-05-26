package com.bebel.core;

import com.badlogic.gdx.Gdx;
import com.bebel.api.BebelGame;
import com.bebel.api.BebelScreen;
import com.bebel.api.manager.SceneManager;
import com.bebel.api.resources.ResourceManager;
import com.bebel.core.scenes.Scenes;

public class Dwarf extends BebelGame {
    public Dwarf() {super(0.05f);}

    @Override
    public void create() {
        super.create();
        ResourceManager.getInstance().finishLoading();
        Gdx.graphics.setWindowedMode(800, 600);

        Scenes.SCENE1.select();
    }
}
