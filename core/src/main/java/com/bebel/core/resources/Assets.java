package com.bebel.core.resources;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bebel.api.resources.animations.AnimationTemplate;
import com.bebel.api.resources.assets.AtlasAsset;
import com.bebel.api.resources.assets.PhysicsAsset;
import com.bebel.api.resources.assets.TextureAsset;

/**
 *  Liste des assets du jeu
 */
public class Assets {
    public static class Scene1 {
        public static TextureAsset BACKGROUND = new TextureAsset("images/game/scene1/background.jpg");
        public static TextureAsset REF = new TextureAsset("images/game/scene1/ref.png");

        public static class Pont {
            public static TextureAsset LEVE = new TextureAsset("images/game/scene1/pont/leve.png");
        }

        public static class Poutres {
            public static class Droite {
                public static TextureAsset AVANT = new TextureAsset("images/game/scene1/poutres/droite/avant.png");
                public static TextureAsset ARRIERE = new TextureAsset("images/game/scene1/poutres/droite/arriere.png");
            }
        }
    }

    public static class Nains {
        public static class Bourru {
            public static AtlasAsset ATLAS = new AtlasAsset("atlas/nains/bourru/bourru.atlas");

            public static TextureRegion FACE_IDLE = ATLAS.get().findRegion("face-idle");
            public static AnimationTemplate FACE_ANIM = new AnimationTemplate(1/6f, ATLAS.get().findRegions("face"), Animation.PlayMode.LOOP);

            public static TextureRegion DROITE_IDLE = ATLAS.get().findRegion("droite-idle");
            public static AnimationTemplate DROITE_ANIM = new AnimationTemplate(1/6f, ATLAS.get().findRegions("droite"), Animation.PlayMode.LOOP);

            /**
             * Physics
             */
            public static PhysicsAsset PHYSICS = new PhysicsAsset("hitbox/nains/bourru/bourru2.xml");
        }
    }
}
