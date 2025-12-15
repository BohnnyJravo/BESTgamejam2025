package com.dasadweb.buildingsnowman.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.dasadweb.buildingsnowman.assets.Assets;
import com.dasadweb.buildingsnowman.config.GameConfig;
import com.dasadweb.buildingsnowman.properties.Bounds;

public class Player extends Bounds {
    public int peeCounter;
    public int collected;
    public int crackCounter;

    public Boolean animationFinished;

    public Texture texture;
    private int direction;  // 0 = R; 1 = RD; 2 = D; 3 = LD; 4 = L; 5 = LU; 6 = U; 7 = UR
    public static final float SPEED = 0.01f;
    public static final float GROW_MULTIPLIER = .5f;
    public static final float SHRINK_MULTIPLIER = .05f;

    private float crackElapsed;
    private int crackCount;
    private float meltElapsed;

    private static final float CRACK_DURATION = .1f;
    private static final float MELT_DURATION = 1f;
    private static final int CRACK_FRAMES = 5;

    public Player() {
        texture = Assets.getSnowball();
        direction = 0;
        bounds = new Rectangle(x, y, width, height);
        reset();
    }

    public void reset() {
        direction = 0;
        crackElapsed = 0f;
        crackCounter = 0;
        meltElapsed = 0f;
        collected = 0;
        peeCounter = 0;
        width = 1;
        height = 1;
        x = 0;
        y = 0;
        bounds.set(x, y, width, height);
        animationFinished = false;
        texture = Assets.getSnowball();
    }

    public Boolean isOver(){
        return peeCounter >= 4 || width < .9 || crackCounter >= 4;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void update(float delta) {
        if (y < 0) {
            direction = 6;
            crackCounter++;
        } else if (y >= GameConfig.WORLD_HEIGHT - height) {
            direction = 2;
            crackCounter++;
        } else if (x < 0) {
            direction = 0;
            crackCounter++;
        } else if (x >= GameConfig.WORLD_WIDTH - width) {
            direction = 4;
            crackCounter++;
        }
        bounds.y = y;
        bounds.x = x;
        switch (direction) {
            case 0:
                x += SPEED * delta;
                bounds.x = x;
                break;
            case 1:
                x += SPEED/2 * delta;
                y -= SPEED/2 * delta;
                bounds.x = x;
                bounds.y = y;
                break;
            case 2:
                y -= SPEED * delta;
                bounds.y = y;
                break;
            case 3:
                y -= SPEED/2 * delta;
                x -= SPEED/2 * delta;
                bounds.x = x;
                bounds.y = y;
                break;
            case 4:
                x -= SPEED * delta;
                bounds.x = x;
                break;
            case 5:
                x -= SPEED/2 * delta;
                y += SPEED/2 * delta;
                bounds.x = x;
                bounds.y = y;
                break;
            case 6:
                y += SPEED * delta;
                bounds.y = y;
                break;
            case 7:
                x += SPEED/2 * delta;
                y += SPEED/2 * delta;
                bounds.x = x;
                bounds.y = y;
                break;
        }
    }
    public void moveL(float delta) {
        direction = 4;
    }
    public void moveR(float delta) {
        direction = 0;
    }
    public void moveU(float delta) {
        direction = 6;
    }
    public void moveD(float delta) {
        direction = 2;
    }

    public void grow(float delta) {
        collected++;
        width += GROW_MULTIPLIER * delta;
        height += GROW_MULTIPLIER * delta;
        bounds.width = width;
        bounds.height = height;
    }
    public void shrink(float delta) {
        // add sweat animation
        if (collected > 0)
            collected -= 0.000001 * delta;
        width -= SHRINK_MULTIPLIER * delta;
        height -= SHRINK_MULTIPLIER * delta;
        bounds.width = width;
        bounds.height = height;
    }
    public void damage() {
        peeCounter ++;
        switch(peeCounter) {
            case 1:
                texture = Assets.getPissball1();
                break;
            case 2:
                texture = Assets.getPissball2();
                break;
            case 3:
                texture = Assets.getPissball3();
        }
    }

    public void crackAnimation(float delta) {
        crackElapsed += delta;

        if (crackCount >= CRACK_FRAMES)
            animationFinished = true;

        if (crackElapsed < CRACK_DURATION) {
            switch (crackCount) {
                case 0:
                    texture = Assets.getDestroy1();
                    break;
                case 1:
                    texture = Assets.getDestroy2();
                    break;
                case 2:
                    texture = Assets.getDestroy3();
                    break;
                case 3:
                    texture = Assets.getDestroy4();
                    break;
                case 4:
                    texture = Assets.getDestroy5();
                    break;
                case 5:
                    texture = Assets.getDestroy6();
                    break;
            }
        } else {
            crackElapsed = 0;
            crackCount++;
        }
    }

    public void meltAnimation(float delta) {
        meltElapsed += delta;
        texture = Assets.getMeltball();
        if (meltElapsed < MELT_DURATION) {
            if (width > 0) {
                width -= MELT_DURATION * delta;
                height -= MELT_DURATION * delta;
                bounds.width = width;
                bounds.height = height;
            }
        } else
            animationFinished = true;
    }

    public Boolean overlap(Rectangle rect) {
        // chatGPT
        float radius = width / 2;
        // Clamp circle center to rectangle bounds
        float closestX = MathUtils.clamp(x + width / 2, rect.x, rect.x + rect.width);
        float closestY = MathUtils.clamp(y + height / 2, rect.y, rect.y + rect.height);

        // Distance from circle center to closest point
        float dx = x + width /2 - closestX;
        float dy = y + height/2 - closestY;

        return (dx * dx + dy * dy) <= radius * radius;
    }
}
