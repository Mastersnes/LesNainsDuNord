package com.bebel.core.resources;

import com.bebel.api.resources.assets.AtlasAsset;
import com.bebel.api.resources.assets.PhysicsAsset;
import com.bebel.api.resources.assets.TextureAsset;

/**
 * Liste des assets de la premiere scene
 */
public class Scene1Assets {
    public static TextureAsset BACKGROUND = new TextureAsset("game/scenes/1/background.jpg");
    public static PhysicsAsset PHYSICS = new PhysicsAsset("game/scenes/1/scene1.xml");

    public static class Pont {
        public static AtlasAsset ATLAS = new AtlasAsset("game/scenes/1/pont.atlas");
        public static TextureAsset GAUCHE = ATLAS.findRegion("gauche");
        public static TextureAsset DROITE = ATLAS.findRegion("droite");
    }

    public static class Piliers {
        public static AtlasAsset ATLAS = new AtlasAsset("game/scenes/1/piliers.atlas");
        public static TextureAsset GAUCHE = ATLAS.findRegion("gauche");
        public static TextureAsset DROITE = ATLAS.findRegion("droite");
    }

    public static class Leviers {
        public static AtlasAsset ATLAS = new AtlasAsset("game/scenes/1/leviers.atlas");
        public static TextureAsset ROUE_AVANT_GAUCHE = ATLAS.findRegion("roue_avant_gauche");
        public static TextureAsset ROUE_AVANT_DROITE = ATLAS.findRegion("roue_avant_droite");
        public static TextureAsset ROUE_ARRIERE_GAUCHE = ATLAS.findRegion("roue_arriere_gauche");
        public static TextureAsset ROUE_ARRIERE_DROITE = ATLAS.findRegion("roue_arriere_droite");

        public static TextureAsset LEVIER_AVANT_GAUCHE = ATLAS.findRegion("levier_avant_gauche");
        public static TextureAsset LEVIER_AVANT_DROITE = ATLAS.findRegion("levier_avant_droite");
        public static TextureAsset LEVIER_ARRIERE_GAUCHE = ATLAS.findRegion("levier_arriere_gauche");
        public static TextureAsset LEVIER_ARRIERE_DROITE = ATLAS.findRegion("levier_arriere_droite");
    }

    public static class Chaines {
        public static AtlasAsset ATLAS = new AtlasAsset("game/scenes/1/chaines.atlas");
        public static TextureAsset AVANT_GAUCHE = ATLAS.findRegion("avant_gauche");
        public static TextureAsset AVANT_DROITE = ATLAS.findRegion("avant_droite");
        public static TextureAsset ARRIERE_GAUCHE = ATLAS.findRegion("arriere_gauche");
        public static TextureAsset ARRIERE_DROITE = ATLAS.findRegion("arriere_droite");
    }
}
