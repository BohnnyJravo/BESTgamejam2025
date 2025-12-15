package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dasadweb.buildingsnowman.assets.Assets;

public class Snow extends Tile {
    public Boolean isPissed;
    private Texture pissTexture;
    public Snow(float x, float y) {
        super(Assets.getSnow(), x, y);
        isPissed = Math.random() > .99;
        pissTexture = Assets.getSnowPee();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (isPissed)
            batch.draw(pissTexture, x, y, width, height);
    }
}
