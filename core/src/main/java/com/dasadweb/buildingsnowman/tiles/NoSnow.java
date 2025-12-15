package com.dasadweb.buildingsnowman.tiles;

import com.dasadweb.buildingsnowman.assets.Assets;

public class NoSnow extends Tile {
    public float timeSpawned;
    public static final float SNOW_SPAWN_TIME = 50f;
    public NoSnow(float x, float y) {
        super(Assets.getNoSnowDiag1(), x, y);
        timeSpawned = 0;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        timeSpawned += delta;
    }
}
