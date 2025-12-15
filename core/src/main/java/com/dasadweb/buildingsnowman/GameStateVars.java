package com.dasadweb.buildingsnowman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.dasadweb.buildingsnowman.assets.Assets;
import com.dasadweb.buildingsnowman.config.GameConfig;
import com.dasadweb.buildingsnowman.entities.Player;
import com.dasadweb.buildingsnowman.tiles.CampFire;
import com.dasadweb.buildingsnowman.tiles.Concrete;
import com.dasadweb.buildingsnowman.tiles.NoSnow;
import com.dasadweb.buildingsnowman.tiles.Snow;
import com.dasadweb.buildingsnowman.tiles.Tile;


public class GameStateVars {
    public Boolean isPaused;
    public Boolean isOver;
    private Array<Tile> tiles;
    private Player player;

    private static final float CAMPFIRE_SPAWN_TIME = 10f;
    private float currCampfireSpawnTime;
    private float timeSinceLastCampfire;

    private Sound firecampSound;
    private Sound snowSound;


    public static final int[] BALL_SIZE_STAGES = new int[]{250, 500, 1000};
    public int stageCount;

    public void init() {
        stageCount = 0;
        player = new Player();
        reset();
        firecampSound = Gdx.audio.newSound(Gdx.files.internal("sounds/campfire-crackling-sound-439573.ogg"));
        snowSound = Gdx.audio.newSound(Gdx.files.internal("sounds/crunching-snow-33462.ogg"));
    }

    public void reset() {
        timeSinceLastCampfire = 0f;
        currCampfireSpawnTime = (float)(Math.random() * CAMPFIRE_SPAWN_TIME);
        isPaused = false;
        isOver = false;
        tiles = new Array<Tile>();
        for (int i = 0; i < GameConfig.TILE_COLUMNS; i++) {
            for (int j = 0; j < GameConfig.TILE_ROWS; j++) {
                tiles.add(new Snow(j, i));
            }
        }
        player.reset();
    }

    public void update(float delta) {
        // game over check
        if (player.isOver()){
            if (!player.animationFinished) {
                if (player.width < 1) {
                    player.meltAnimation(delta);
                } else {
                    player.crackAnimation(delta);
                }
            }
        } else {
            for (Tile tile: tiles) {
                player.update(delta);
                tile.update(delta);
                if (
                    tile instanceof CampFire && ((CampFire)tile).timeSpawned > CampFire.DESPAWN_TIME ||
                        tile instanceof Concrete && ((Concrete)tile).campfire.timeSpawned > CampFire.DESPAWN_TIME
                ) {
                    tiles.set((int)(tile.x + GameConfig.TILE_ROWS * tile.y), new NoSnow(tile.x, tile.y));
//                    firecampSound.stop();
                }
                if (tile instanceof NoSnow && ((NoSnow)tile).timeSpawned > NoSnow.SNOW_SPAWN_TIME) {
                    tiles.set((int)(tile.x + GameConfig.TILE_ROWS * tile.y), new Snow(tile.x, tile.y));
                }

                // ovrelap
                if (tile instanceof Snow && player.overlap(tile.bounds)){
                    tiles.set((int)(tile.x + tile.y * GameConfig.TILE_ROWS), new NoSnow(tile.x, tile.y));
                    if (((Snow)tile).isPissed) {
                        player.damage();
                    } else {
                        player.grow(delta);
                    }
//                    snowSound.play(1f);
                }
                if ((tile instanceof Concrete || tile instanceof CampFire) && player.overlap(tile.bounds)) {
                    player.shrink(delta);
//                    player.texture = Assets.getMeltball();
//                } else {
//                    player.texture = Assets.getSnowball();
                }

                if (player.collected >= BALL_SIZE_STAGES[stageCount]) {
                    stageCount++;
                    reset();
                }
            }
            timeSinceLastCampfire += delta;
            if (timeSinceLastCampfire > currCampfireSpawnTime) {
                spawnCampfire();
                timeSinceLastCampfire = 0;
                currCampfireSpawnTime = (float)(Math.random() * CAMPFIRE_SPAWN_TIME);
            }
        }
    }

    public void draw(SpriteBatch batch) {
//        if (player.isOver() && !player.animationFinished) {
            // show game end screen
//        } else {
            for (int i = 0; i < GameConfig.TILE_ROWS * GameConfig.TILE_COLUMNS; i++) {
                tiles.get(i).draw(batch);
            }
            player.draw(batch);
//        }
    }

    private void spawnCampfire() {
        int minX = 0;
        int maxX = (int)GameConfig.WORLD_WIDTH - 1;
        int minY = 0;
        int maxY = (int)GameConfig.WORLD_HEIGHT - 1;
        int randX = (int)(Math.random() * (maxX - minX + 1)) + minX;
        int randY = (int)(Math.random() * (maxY - minY + 1)) + minY;
        CampFire cf = new CampFire(randX, randY);
        if (!(tiles.get(randX + (GameConfig.TILE_ROWS * randY)) instanceof CampFire)) {
            tiles.set(randX + (GameConfig.TILE_ROWS * randY), cf);
        }
        // get used ChatGPT
        // make sure campfire cannot spawn in radius of another campfire
        int r2 = CampFire.RADIUS * CampFire.RADIUS;
        for (int dy = - CampFire.RADIUS; dy <= CampFire.RADIUS; dy++) {
            for (int dx = - CampFire.RADIUS; dx <= CampFire.RADIUS; dx++){
                if (dx == 0 && dy == 0) continue;
                if (dx * dx + dy * dy > r2) continue;

                int nx = randX + dx;
                int ny = randY + dy;

                if (nx < 0 || nx >= GameConfig.TILE_ROWS || ny < 0 || ny >= GameConfig.TILE_COLUMNS) continue;
                if (!(tiles.get(nx + (GameConfig.TILE_ROWS * ny)) instanceof CampFire)) {
                    tiles.set(nx + GameConfig.TILE_ROWS * ny, new Concrete(cf, nx, ny));
                }
            }
        }
//        firecampSound.play(1f);
    }

    public void movePlayer(String direction, float delta) {
        switch (direction) {
            case "up":
                player.moveU(delta);
                break;
            case "down":
                player.moveD(delta);
                break;
            case "left":
                player.moveL(delta);
                break;
            case "right":
                player.moveR(delta);
                break;
        }
    }

    public void togglePaused() {
        isPaused = !isPaused;
    }
    public Boolean isOver() {
        return player.isOver();
    }
    public void playerUpdate(float delta) {
        player.update(delta);
    }
    public int collected() {
        return player.collected;
    }
    public void dispose() {
        firecampSound.dispose();
        snowSound.dispose();
    }
}
