package com.bebel.core.resources;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.bebel.api.resources.animations.AnimationTemplate;
import com.bebel.api.resources.assets.AtlasAsset;
import com.bebel.api.resources.assets.PhysicsAsset;

public class NainsAssets {
    public static class Bourru {
        public static AtlasAsset ATLAS = new AtlasAsset("atlas/nains/bourru/bourru.atlas");

        public static AnimationTemplate FACE_IDLE = new AnimationTemplate(ATLAS.get().findRegion("face-idle"));
        public static AnimationTemplate FACE_ANIM = new AnimationTemplate(1 / 6f, ATLAS.get().findRegions("face"), Animation.PlayMode.LOOP);

        public static AnimationTemplate DROITE_IDLE = new AnimationTemplate(ATLAS.get().findRegion("droite-idle"));
        public static AnimationTemplate DROITE_ANIM = new AnimationTemplate(1 / 6f, ATLAS.get().findRegions("droite"), Animation.PlayMode.LOOP);

        public static AnimationTemplate GAUCHE_IDLE = new AnimationTemplate(ATLAS.get().findRegion("droite-idle")).flipX();
        public static AnimationTemplate GAUCHE_ANIM = new AnimationTemplate(1 / 6f, ATLAS.get().findRegions("gauche"), Animation.PlayMode.LOOP);

        public static PhysicsAsset PHYSICS = new PhysicsAsset("hitbox/nains/bourru/bourru.xml");
    }
}
