package com.dasadweb.buildingsnowman.tiles;

import com.dasadweb.buildingsnowman.assets.Assets;

public class Concrete extends Tile {
    public CampFire campfire;
    public Concrete(CampFire campfire, int x, int y) {
        super(Assets.getGround(), x, y);
        this.campfire = campfire;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}
