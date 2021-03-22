package com.bebel.core.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.bebel.api.Global;
import com.bebel.api.elements.basique.AnimableElement;
import com.bebel.api.elements.basique.MovableElement;
import com.bebel.api.resources.animations.AnimationTemplate;
import com.bebel.core.resources.Assets;
import com.bebel.core.scenes.Scene1;
import pythagoras.i.Point;

public class Personnage extends AnimableElement {
    protected final Point lastDirection = new Point();
    protected final Point currentDirection = new Point();
    protected float speed;

    protected boolean controlClavier;
    protected Vector2 objectif = new Vector2(-1, -1);

    public Personnage(final String name, float w, float h) {
        this(name, w, h, true);
    }
    public Personnage(final String name, float w, float h, final boolean controlClavier) {
        super(name, w, h);
        this.controlClavier = controlClavier;
    }

    @Override
    protected void createImpl() {
        super.createImpl();
    }

    public Personnage speed(final float speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public void body(Body body) {
        super.body(body);
        body.setTransform(x, y, rotation);
    }

    @Override
    public MovableElement move(final float ox, final float oy, final int from) {
        super.move(ox, oy, from);
        if (body != null) body.setLinearDamping(ox);
        return this;
    }

    /**
     * ANIMABLE
     */
    public Personnage face(final AnimationTemplate animation, final TextureRegion idle) {
        addAnim("FACE", animation);
        addAnim("FACE_IDLE", new AnimationTemplate(1f, idle));
        return this;
    }
    public Personnage droite(final AnimationTemplate animation, final TextureRegion idle) {
        addAnim("DROITE", animation);
        addAnim("DROITE_IDLE", new AnimationTemplate(1f, idle));
        return this;
    }

    /**
     * DRAWABLE
     */
    @Override
    public boolean update(float delta) {
        if (objectif.x != -1) {
            if (objectif.y > y) currentDirection.y = -1;
            else if (objectif.y < y) currentDirection.y = 1;
        }

        if (x == objectif.x && y == objectif.y) objectif.set(-1, -1);

        //IDLE
        if (currentDirection.x == 0 && currentDirection.y == 0) play("FACE_IDLE");
        else {
            if (currentDirection.x != 0) {
                play("DROITE");
                if (currentDirection.x > 0 && isFlipX() || currentDirection.x < 0 && !isFlipX()) flipX();
            } else if (currentDirection.y > 0) play("FACE");
        }

        move(currentDirection.x * speed * delta, currentDirection.y * speed * delta);
        moveZ(currentDirection.y * 0.1f * delta);

        if (body != null) {
            body.setLinearVelocity(currentDirection.x * speed, -currentDirection.y * speed);
        }

        currentDirection.set(0, 0);
        return super.update(delta);
    }

    /**
     * EVENTABLE
     */
    public Personnage goTo(final float x, final float y) {
        Gdx.app.log("GOTO", x + ", " + y);
        objectif.set(x, y); return this;
    }

    @Override
    protected void makeEvents() {
        super.makeEvents();

        input.whileKeyDown(k -> {
            if (!controlClavier) return;
            if (k.contains(Input.Keys.Z)) currentDirection.y = -1;
            if (k.contains(Input.Keys.S)) currentDirection.y = 1;
            if (k.contains(Input.Keys.Q)) currentDirection.x = -1;
            if (k.contains(Input.Keys.D)) currentDirection.x = 1;

            if (k.contains(Input.Keys.RIGHT)) grow(0.01f);
            if (k.contains(Input.Keys.LEFT)) grow(-0.01f);
            if (k.contains(Input.Keys.NUMPAD_1)) {
                Gdx.app.log("ORIGIN", "LEFT, DOWN");
                scaleOrigin(R_LEFT | R_DOWN);
                Gdx.app.log("VECTOR", scaleVector.x + ", " + scaleVector.y);
            }
            if (k.contains(Input.Keys.NUMPAD_9)) {
                Gdx.app.log("ORIGIN", "UP, RIGHT");
                scaleOrigin(R_UP | R_RIGHT);
                Gdx.app.log("VECTOR", scaleVector.x + ", " + scaleVector.y);
            }
            if (k.contains(Input.Keys.NUMPAD_5)) {
                Gdx.app.log("ORIGIN", "CENTER");
                scaleOrigin(CENTERX | CENTERY);
                Gdx.app.log("VECTOR", scaleVector.x + ", " + scaleVector.y);
            }

            lastDirection.set(currentDirection);
        });

        onScaleChanged(oldScale -> {
            Scene1.world.destroyBody(body);
            scaleOrigin(R_DOWN | R_LEFT);
            body(Assets.Nains.Bourru.PHYSICS.get().createBody("face", Scene1.world, Global.scale*scaleX, Global.scale*scaleY));
        });
    }
}
