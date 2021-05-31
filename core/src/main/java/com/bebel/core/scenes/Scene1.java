package com.bebel.core.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.bebel.api.Global;
import com.bebel.api.actions.ActionManager;
import com.bebel.api.actions.organisation.SequenceAction;
import com.bebel.api.elements.complex.BebelScene;
import com.bebel.api.elements.complex.Personnage;
import com.bebel.api.utils.Jalon;
import com.bebel.api.utils.Path;
import com.bebel.core.resources.NainsAssets;
import com.bebel.core.resources.Scene1Assets;

import static com.bebel.api.actions.ActionManager.*;

public class Scene1 extends BebelScene {
    protected Personnage selected, bourru, petit;

    public Scene1() {
        super("Premiere Scene - Pont");
    }

    @Override
    protected void createImpl() {
        super.createImpl();

        activeProfondeur(0.02f, 0.27f);
        sortByY();

        activeJalon("G", 87f, 22f)
            .down("F", 88f, 13f).down()
            .left("E", 65f, 13f).left()
            .left("D", 45f, 13f).left()
            .left("C", 25.5f, 13f).left()
            .left("B", 5f, 13f).left()
            .up("A", 5f, 20f);

        background(Scene1Assets.BACKGROUND);

        /**
         * Pont
         */
        add("Pont Gauche", Scene1Assets.Pont.GAUCHE)
            .size(443 * Global.scale, 214 * Global.scale)
            .position(24.10f, 35.85f);
        add("Pont Droite", Scene1Assets.Pont.DROITE)
            .size(427 * Global.scale, 211 * Global.scale)
            .position(45.10f, 35.85f);

        /**
         * Chaines
         */
        add("Chaine arriere gauche", Scene1Assets.Chaines.ARRIERE_GAUCHE)
                .size(657 * Global.scale, 339 * Global.scale)
                .position(13f, 20.85f).setDynamic();
        add("Chaine arriere droite", Scene1Assets.Chaines.ARRIERE_DROITE)
                .size(630 * Global.scale, 313 * Global.scale)
                .position(45.2f, 21.75f).setDynamic();

        /**
         * Leviers / Roues
         */
       add("Levier arriere gauche", Scene1Assets.Leviers.LEVIER_ARRIERE_GAUCHE)
            .size(38 * Global.scale, 72 * Global.scale)
            .position(9.9f, 30.4f).setDynamic();
        add("Roue arriere gauche", Scene1Assets.Leviers.ROUE_ARRIERE_GAUCHE)
            .size(121 * Global.scale, 105 * Global.scale)
            .position(9.30f, 32.35f).setDynamic();

        add("Levier arriere droite", Scene1Assets.Leviers.LEVIER_ARRIERE_DROITE)
            .size(38 * Global.scale, 72 * Global.scale)
            .position(78.2f, 31.00f).setDynamic();
        add("Roue arriere droite", Scene1Assets.Leviers.ROUE_ARRIERE_DROITE)
            .size(123 * Global.scale, 106 * Global.scale)
            .position(74.85f, 32.85f).setDynamic();

        bourru = (Personnage) add(new Personnage("Bourru"))
            .up(NainsAssets.Bourru.DOS_ANIM, NainsAssets.Bourru.FACE_IDLE)
            .down(NainsAssets.Bourru.FACE_ANIM, NainsAssets.Bourru.FACE_IDLE)
            .right(NainsAssets.Bourru.DROITE_ANIM, NainsAssets.Bourru.FACE_IDLE)
            .left(NainsAssets.Bourru.GAUCHE_ANIM, NainsAssets.Bourru.FACE_IDLE)
            .speed(17.5f)
            .activeZ()
            .size(200 * Global.scale, 245 * Global.scale)
            .position(923 * Global.scale, 563 * Global.scale)
            .setDynamic();

        petit = (Personnage) add(new Personnage("Petit"))
            .up(NainsAssets.Petit.DOS_ANIM, NainsAssets.Petit.FACE_IDLE)
            .down(NainsAssets.Petit.FACE_ANIM, NainsAssets.Petit.FACE_IDLE)
            .left(NainsAssets.Petit.GAUCHE_ANIM, NainsAssets.Petit.FACE_IDLE)
            .right(NainsAssets.Petit.DROITE_ANIM, NainsAssets.Petit.FACE_IDLE)
            .speed(17.5f)
            .activeClavier()
            .activeZ()
            .size(184 * Global.scale, 230 * Global.scale)
            .position(923 * Global.scale, 563 * Global.scale)
            .setDynamic();

        /**
         * Chaines
         */
        add("Chaine avant gauche", Scene1Assets.Chaines.AVANT_GAUCHE)
            .size(709 * Global.scale, 566 * Global.scale)
            .position(10.9f, 17.8f).setDynamic();
        add("Chaine avant droite", Scene1Assets.Chaines.AVANT_DROITE)
            .size(709 * Global.scale, 566 * Global.scale)
            .position(45.1f, 17.65f).setDynamic();

        /**
         * Leviers / Roues
         */
        add("Roue avant gauche", Scene1Assets.Leviers.ROUE_AVANT_GAUCHE)
            .size(153 * Global.scale, 131 * Global.scale)
            .position(5.55f, 40.25f).setDynamic();
        add("Levier avant gauche", Scene1Assets.Leviers.LEVIER_AVANT_GAUCHE)
            .size(48 * Global.scale, 90 * Global.scale)
            .position(6.55f, 37.8f).setDynamic();

        add("Roue avant droite", Scene1Assets.Leviers.ROUE_AVANT_DROITE)
            .size(184 * Global.scale, 135 * Global.scale)
            .position(77.35f, 39.70f).setDynamic();
        add("Levier avant droite", Scene1Assets.Leviers.LEVIER_AVANT_DROITE)
            .size(48 * Global.scale, 90 * Global.scale)
            .position(82.35f, 37.15f).setDynamic();

        /**
         * Piliers
         */
        add("Pilier gauche", Scene1Assets.Piliers.GAUCHE)
            .size(169 * Global.scale, 636 * Global.scale)
            .position(18.50f, 15.50f).setDynamic();
        add("Pilier droite", Scene1Assets.Piliers.DROITE)
            .size(433 * Global.scale, 759 * Global.scale)
            .position(63.75f, 16.05f).setDynamic();
    }

    @Override
    protected void paintImpl(SpriteBatch batch) {
        super.paintImpl(batch);
//        for (final Jalon jalon : rootJalon.listAll()) {
//            batch.end();
//            final ShapeRenderer shape = Global.shape;
//            shape.setProjectionMatrix(batch.getProjectionMatrix());
//            shape.setTransformMatrix(batch.getTransformMatrix());
//            shape.setColor(Color.RED.cpy());
//            shape.begin(ShapeRenderer.ShapeType.Line);
//            shape.rect(jalon.x() - 2, jalon.y() - 2, 2, 2);
//            shape.end();
//            batch.begin();
//        }
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
        });

        bourru.onClick(mouse -> {
            Gdx.app.log("SELECT", "BOURRU");
            if (mouse.isLeft()) selected = bourru;
        });
        petit.onClick(mouse -> {
            Gdx.app.log("SELECT", "PETIT");
            if (mouse.isLeft()) selected = petit;
        });

        onClick(mouse -> {
            Gdx.app.log("DESTINATION", mouse.x() + ", " + mouse.y());
            if (mouse.isRight() && selected != null) {
                selected.stop();
                final Vector2 mousePosition = new Vector2(mouse.x(), mouse.y());
                final Vector2 nainPosition = new Vector2(selected.x(), selected.y());

                final Jalon firstJalon = closestJalon(nainPosition);
                final Jalon lastJalon = closestJalon(mousePosition);
                final Path path = firstJalon.findBestPath(lastJalon);

                final SequenceAction sequence = ActionManager.sequence();
                for (final Jalon jalon : path) {
                    sequence.add(walk(selected).to(jalon.x, jalon.y));
                }
//                sequence.add(walk(selected).to(mousePosition.x, mousePosition.y));

                Gdx.app.log("PATH", sequence.toString());

                newSequence(sequence);
            }
        });
    }
}
