package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dasadweb.buildingsnowman.assets.Assets;

public class Present extends Tile {
    private final Texture presentTexture;
    public Present(int x, int y) {
        super (Assets.getSnow(), x, y);
        presentTexture = Assets.getPresent();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(presentTexture, x, y, width, height);
    }
}
