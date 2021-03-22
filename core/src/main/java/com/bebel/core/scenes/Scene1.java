package com.bebel.core.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.bebel.api.Global;
import com.bebel.api.manager.BebelScene;
import com.bebel.core.elements.Personnage;
import com.bebel.core.resources.Assets;

public class Scene1 extends BebelScene {
    public static final float STEP_TIME = 1f / 60f;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;

    protected Personnage nain;

    public static World world;
    public Box2DDebugRenderer b2dr;
    private float accumulator;

    public Scene1() {
        super("Premiere Scene - Pont");
    }

    @Override
    protected void createImpl() {
        super.createImpl();

        Gdx.graphics.setWindowedMode(800, 600);

        Box2D.init();
        world = new World(new Vector2(0, 0), true);

        b2dr = new Box2DDebugRenderer();

        background(Assets.Scene1.BACKGROUND);

        add("Pont", Assets.Scene1.Pont.LEVE, 673 * Global.scale, 665 * Global.scale, 520 * Global.scale, 183 * Global.scale);

        add("Poutre arriere droite", Assets.Scene1.Poutres.Droite.ARRIERE, 1211 * Global.scale, 349 * Global.scale, 119 * Global.scale, 341 * Global.scale);

        nain = (Personnage) add(new Personnage("Bourru", 180 * Global.scale, 245 * Global.scale))
                .face(Assets.Nains.Bourru.FACE_ANIM, Assets.Nains.Bourru.FACE_IDLE)
                .droite(Assets.Nains.Bourru.DROITE_ANIM, Assets.Nains.Bourru.DROITE_IDLE)
                .speed(175f * Global.scale)
                .position(923 * Global.scale, 563 * Global.scale);

        final Body body = Assets.Nains.Bourru.PHYSICS.get().createBody("face", world, Global.scale, Global.scale);
        nain.body(body);

        add("Poutre avant droite", Assets.Scene1.Poutres.Droite.AVANT, 1224 * Global.scale, 359 * Global.scale, 449 * Global.scale, 721 * Global.scale);
    }

    @Override
    protected void makeEvents() {
        super.makeEvents();

        parent.onClick(mouse -> {
            Gdx.app.log("NAIN", nain.x() + ", " + nain.y());

            if (mouse.isRight()) nain.goTo(mouse.x, mouse.y);
            if (mouse.isLeft()) nain.goTo(-1, -1);
        });

        input.onKeyDown(k -> {
            if (k.is(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
            }
            if (k.is(Input.Keys.TAB)) {
                if (Gdx.graphics.isFullscreen()) Gdx.graphics.setWindowedMode(800, 600);
                else Gdx.graphics.setFullscreenMode(Global.displayModes.get(0));
            }
        });
    }

    @Override
    protected void paintImpl(SpriteBatch batch) {
        super.paintImpl(batch);
        b2dr.render(world, screen.getCamera().combined);
    }

    @Override
    public boolean update(float delta) {
        super.update(delta);

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= STEP_TIME) {
            accumulator -= STEP_TIME;

            world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        }

        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
        world.dispose();
        b2dr.dispose();
    }
}
