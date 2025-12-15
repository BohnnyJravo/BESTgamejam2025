package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dasadweb.buildingsnowman.assets.Assets;

public class Button extends Tile {
    private final Texture buttonTexture;
    public Button(int x, int y) {
        super(Assets.getSnow(), x, y);
        buttonTexture = Assets.getButton();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(buttonTexture, x, y, width, height);
    }
}
