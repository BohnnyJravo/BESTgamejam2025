package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dasadweb.buildingsnowman.assets.Assets;

public class Carrot extends Tile {
    private final Texture carrotTexture;
    public Carrot(int x, int y) {
        super (Assets.getSnow(), x, y);
        carrotTexture = Assets.getCarrot();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(carrotTexture, x, y, width, height);
    }
}
