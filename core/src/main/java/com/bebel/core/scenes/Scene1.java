package com.bebel.core.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.bebel.api.Global;
import com.bebel.api.elements.complex.BebelScene;
import com.bebel.api.elements.complex.Personnage;
import com.bebel.core.resources.NainsAssets;
import com.bebel.core.resources.Scene1Assets;

public class Scene1 extends BebelScene {
    protected Personnage nain;

    public Scene1() {
        super("Premiere Scene - Pont");
    }

    @Override
    protected void createImpl() {
        super.createImpl();

//        Global.debugMode = true;
        activePhysics(0, 0);
        activeProfondeur(0.02f, 0.5f);

        Gdx.graphics.setWindowedMode(800, 600);

        background(Scene1Assets.BACKGROUND, Scene1Assets.PHYSICS)
            .body("scene", BodyDef.BodyType.StaticBody);

        add("Pont", Scene1Assets.Pont.LEVE)
            .size(520 * Global.scale, 183 * Global.scale)
            .position(673 * Global.scale, 665 * Global.scale);

        add("Poutre arriere droite", Scene1Assets.Poutres.Droite.ARRIERE)
            .size(119 * Global.scale, 341 * Global.scale)
            .position(1211 * Global.scale, 349 * Global.scale);

        nain = (Personnage) add(new Personnage("Bourru", NainsAssets.Bourru.PHYSICS))
                .down(NainsAssets.Bourru.FACE_ANIM, NainsAssets.Bourru.FACE_IDLE, "face", BodyDef.BodyType.DynamicBody)
                .right(NainsAssets.Bourru.DROITE_ANIM, NainsAssets.Bourru.DROITE_IDLE, "droite", BodyDef.BodyType.DynamicBody)
                .left(NainsAssets.Bourru.GAUCHE_ANIM, NainsAssets.Bourru.GAUCHE_IDLE, "droite", BodyDef.BodyType.DynamicBody)
                .speed(165f * Global.scale).activeClavier()
                .activeZ()
                .size(200 * Global.scale, 245 * Global.scale)
                .position(923 * Global.scale, 563 * Global.scale);


        add("Poutre avant droite", Scene1Assets.Poutres.Droite.AVANT)
            .size(449 * Global.scale, 721 * Global.scale)
            .position(1224 * Global.scale, 359 * Global.scale);
    }

    @Override
    protected void makeEvents() {
        super.makeEvents();

        input.onKeyDown(k -> {
            if (k.is(Input.Keys.ESCAPE)) Gdx.app.exit();

            if (k.is(Input.Keys.TAB)) {
                if (Gdx.graphics.isFullscreen()) Gdx.graphics.setWindowedMode(800, 600);
                else Gdx.graphics.setFullscreenMode(Global.displayModes.get(0));
            }

            if (k.is(Input.Keys.DOWN)) nain.speed(nain.speed()-0.1f);
            if (k.is(Input.Keys.UP)) nain.speed(nain.speed()+0.1f);

            if (k.containsOneOf(Input.Keys.UP, Input.Keys.DOWN)) Gdx.app.log("SPEED", nain.speed()+"");
        });

        parent.onClick(mouse -> {
            Gdx.app.log("NAIN", nain.x() + ", " + nain.y());

            if (mouse.isRight()) nain.goTo(mouse.x, mouse.y);
            if (mouse.isLeft()) nain.stop();
        });
    }
}
