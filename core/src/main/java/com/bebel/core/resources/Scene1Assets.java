package com.bebel.core.resources;

import com.bebel.api.resources.assets.PhysicsAsset;
import com.bebel.api.resources.assets.TextureAsset;

/**
 * Liste des assets de la premiere scene
 */
public class Scene1Assets {
    public static TextureAsset BACKGROUND = new TextureAsset("images/game/scene1/background.jpg");
    public static PhysicsAsset PHYSICS = new PhysicsAsset("hitbox/scenes/scene1.xml");

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
