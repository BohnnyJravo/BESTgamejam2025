package com.dasadweb.buildingsnowman.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dasadweb.buildingsnowman.properties.Bounds;


public class Tile extends Bounds {
    private final Texture texture;

    public Tile(Texture texture, float x, float y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        bounds = new Rectangle(x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void update(float delta) {
    }
}
