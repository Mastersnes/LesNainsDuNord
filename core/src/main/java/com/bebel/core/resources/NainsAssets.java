package com.bebel.core.resources;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.bebel.api.resources.animations.AnimationTemplate;
import com.bebel.api.resources.assets.AtlasAsset;
import com.bebel.api.resources.assets.PhysicsAsset;

public class NainsAssets {
    public static class Bourru {
        public static AtlasAsset ATLAS = new AtlasAsset("game/nains/bourru/bourru.atlas");

        public static AnimationTemplate FACE_IDLE = new AnimationTemplate(ATLAS.get().findRegion("face-idle"));

        /**
         * 30 images par seconde
         * 4 temps par image
         * donc 4/30 secondes pour 1 image
         */
        public static AnimationTemplate DOS_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("dos"), Animation.PlayMode.LOOP);
        public static AnimationTemplate FACE_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("face"), Animation.PlayMode.LOOP);
        public static AnimationTemplate DROITE_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("droite"), Animation.PlayMode.LOOP);
        public static AnimationTemplate GAUCHE_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("gauche"), Animation.PlayMode.LOOP);
    }

    public static class Petit {
        public static AtlasAsset ATLAS = new AtlasAsset("game/nains/petit/petit.atlas");

        public static AnimationTemplate FACE_IDLE = new AnimationTemplate(ATLAS.get().findRegion("face-idle"));

        /**
         * 30 images par seconde
         * 4 temps par image
         * donc 4/30 secondes pour 1 image
         */
        public static AnimationTemplate FACE_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("face"), Animation.PlayMode.LOOP);
        public static AnimationTemplate DROITE_ANIM = new AnimationTemplate(4 / 30f, ATLAS.get().findRegions("droite"), Animation.PlayMode.LOOP);
        public static AnimationTemplate GAUCHE_ANIM = new AnimationTemplate(DROITE_ANIM).flipX();
    }
}
