package com.dasadweb.buildingsnowman.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {
    private static AssetManager manager = new AssetManager();

    public static void init() {
        manager.load("gameplay/snow.png", Texture.class);
        manager.load("gameplay/snowball.png", Texture.class);
        manager.load("gameplay/snow-pee.png", Texture.class);
        manager.load("gameplay/button-on-snow.png", Texture.class);
        manager.load("gameplay/carrot-on-snow.png", Texture.class);
        manager.load("gameplay/fire1.png", Texture.class);
        manager.load("gameplay/fire2.png", Texture.class);
        manager.load("gameplay/fire3.png", Texture.class);
        manager.load("gameplay/firewood.png", Texture.class);
        manager.load("gameplay/ground.png", Texture.class);
        manager.load("gameplay/meltball.png", Texture.class);
        manager.load("gameplay/no-snow-diag1.png", Texture.class);
        manager.load("gameplay/no-snow-diag2.png", Texture.class);
        manager.load("gameplay/no-snow-horiz.png", Texture.class);
        manager.load("gameplay/pissball1.png", Texture.class);
        manager.load("gameplay/pissball2.png", Texture.class);
        manager.load("gameplay/pissball3.png", Texture.class);
        manager.load("gameplay/snowball-destroy1.png", Texture.class);
        manager.load("gameplay/snowball-destroy2.png", Texture.class);
        manager.load("gameplay/snowball-destroy3.png", Texture.class);
        manager.load("gameplay/snowball-destroy4.png", Texture.class);
        manager.load("gameplay/snowball-destroy5.png", Texture.class);
        manager.load("gameplay/snowball-destroy6.png", Texture.class);

//       manager.load("sounds/campfire-cracling-sound-439573.ogg", Sound.class);
//       manager.load("sounds/crunching-snow-33462.ogg", Sound.class);

//        manager.load("fonts/MountainsofChristmas-Regular.ttf", BitmapFont.class);
    }

    public static void finishLoading() {
        manager.finishLoading();
    }

    public static void dispose() {
        manager.dispose();
    }


    public static Texture getSnow() {
        return manager.get("gameplay/snow.png");
    }
    public static Texture getSnowball() {
        return manager.get("gameplay/snowball.png");
    }
    public static Texture getSnowPee() {
        return manager.get("gameplay/snow-pee.png");
    }
    public static Texture getButton() {
        return manager.get("gameplay/button-on-snow.png");
    }
    public static Texture getFire1() {
        return manager.get("gameplay/fire1.png");
    }
    public static Texture getCarrot() {
        return manager.get("gameplay/carrot-on-snow.png");
    }
    public static Texture getFire2() {
        return manager.get("gameplay/fire2.png");
    }
    public static Texture getFire3() {
        return manager.get("gameplay/fire3.png");
    }
    public static Texture getFirewood() {
        return manager.get("gameplay/firewood.png");
    }
    public static Texture getGround() {
        return manager.get("gameplay/ground.png");
    }
    public static Texture getMeltball() {
        return manager.get("gameplay/meltball.png");
    }
    public static Texture getNoSnowDiag1() {
        return manager.get("gameplay/no-snow-diag1.png");
    }
    public static Texture getNoSnowDiag2() {
        return manager.get("gameplay/no-snow-diag2.png");
    }
    public static Texture getNoSnowHoriz() {
        return manager.get("gameplay/no-snow-horiz.png");
    }
    public static Texture getPissball1() {
        return manager.get("gameplay/pissball1.png");
    }
    public static Texture getPissball2() {
        return manager.get("gameplay/pissball2.png");
    }
    public static Texture getPissball3() {
        return manager.get("gameplay/pissball3.png");
    }
    public static Texture getPresent() {
        return manager.get("gameplay/present-on-snow.png");
    }
    public static Texture getDestroy2() {
        return manager.get("gameplay/snowball-destroy2.png");
    }
    public static Texture getDestroy3() {
        return manager.get("gameplay/snowball-destroy3.png");
    }
    public static Texture getDestroy4() {
        return manager.get("gameplay/snowball-destroy4.png");
    }
    public static Texture getDestroy5() {
        return manager.get("gameplay/snowball-destroy5.png");
    }
    public static Texture getDestroy6() {
        return manager.get("gameplay/snowball-destroy6.png");
    }
    public static Texture getDestroy1() {
        return manager.get("gameplay/snowball-destroy1.png");
    }
//    public static Sound getCampfireSound() {
//        return manager.get("sounds/campfire-cracling-sound-439573.ogg");
//    }
//    public static Sound getSnowSound() {
//        return manager.get("sounds/crunching-snow-33462.ogg");
//    }
//    public static BitmapFont getFont() {
//        return manager.get("fonts/MountainsofChristmas-Bold.ttf");
//    }
}
