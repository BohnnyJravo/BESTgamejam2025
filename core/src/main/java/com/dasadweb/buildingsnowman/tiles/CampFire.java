package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dasadweb.buildingsnowman.assets.Assets;

public class CampFire extends Tile {
    private static final float ANIMATION_TIME = .5f;
    private float animation_elapsed_time;
    private final Texture fireTexture1;
    private final Texture fireTexture2;
    private final Texture fireTexture3;
    private Texture fireTexture;
    private final Boolean fireAnimIncr;

    private final Texture firewoodTexture;

    public static final float DESPAWN_TIME = 10f;
    public static final int RADIUS = 5;
    public float timeSpawned;
    public CampFire(float x, float y) {
        super(Assets.getGround(), x, y);
        timeSpawned = 0f;
        // add firewood and fire animation
        animation_elapsed_time = 0f;
        fireTexture1 = Assets.getFire1();
        fireTexture2 = Assets.getFire2();
        fireTexture3 = Assets.getFire3();
        fireTexture = fireTexture1;
        fireAnimIncr = true;

        firewoodTexture = Assets.getFirewood();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(firewoodTexture, x, y, width, height);
        batch.draw(fireTexture, x, y, width, height);
    }

    @Override
    public void update(float delta) {
        timeSpawned += delta;
        animation_elapsed_time += delta;
        if (animation_elapsed_time > ANIMATION_TIME) {
            animation_elapsed_time = 0;
            if (fireTexture == fireTexture1) {
                fireTexture = fireTexture2;
//                fireAnimIncr = true;
            } else if (fireTexture == fireTexture2) {
                if (fireAnimIncr)
                    fireTexture = fireTexture3;
                else
                    fireTexture = fireTexture1;
            } else if (fireTexture == fireTexture3) {
                fireTexture = fireTexture2;
//                fireAnimIncr = false;
            }
        }
    }
}
