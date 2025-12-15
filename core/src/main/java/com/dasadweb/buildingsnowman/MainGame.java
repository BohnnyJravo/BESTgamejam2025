package com.dasadweb.buildingsnowman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.dasadweb.buildingsnowman.assets.Assets;
import com.dasadweb.buildingsnowman.config.GameConfig;
import com.dasadweb.buildingsnowman.tiles.Tile;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private FitViewport viewport;
    private FitViewport hudViewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;

    private GameStateVars stateVars;

    @Override
    public void create() {
        Assets.init();
        Assets.finishLoading();

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        hudViewport = new FitViewport(GameConfig.WIDTH, GameConfig.HEIGHT);
        batch = new SpriteBatch();

        stateVars = new GameStateVars();
        stateVars.init();
//        font = Assets.getFont();
        font = new BitmapFont(Gdx.files.internal("fonts/santa.fnt"));
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
        hudViewport.update(width, height, true);
    }

    @Override
    public void render() {
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        float delta = Gdx.graphics.getDeltaTime();
        input(delta);
        if (!stateVars.isPaused)
            update(delta);

        batch.begin();
        draw();
        batch.end();

        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();
        drawHUD();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        Assets.dispose();
        stateVars.dispose();
    }

    private void update(float delta) {
        stateVars.update(delta);
    }

    private void input(float delta) {
        if (!stateVars.isPaused && !stateVars.isOver()) {
            if (
                Gdx.input.isKeyPressed(Input.Keys.UP)   ||
                Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
                Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
                Gdx.input.isKeyPressed(Input.Keys.RIGHT)
            ){
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    stateVars.movePlayer("up", delta);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    stateVars.movePlayer("down", delta);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    stateVars.movePlayer("left", delta);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    stateVars.movePlayer("right", delta);
                }
            } else {
                stateVars.playerUpdate(delta);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P))
            stateVars.togglePaused();
        if (Gdx.input.isKeyJustPressed(Input.Keys.R))
            stateVars.reset();
    }

    private void draw() {
        stateVars.draw(batch);
    }
    private void drawHUD() {
//        batch.draw(, GameConfig.HEIGHT - 150f, GameConfig.WIDTH - 40f);
        font.setColor(Color.CORAL);
        font.draw(batch, stateVars.collected()+"/"+GameStateVars.BALL_SIZE_STAGES[stateVars.stageCount], 20f, GameConfig.HEIGHT - 40f);

        for (int i = 0; i < stateVars.stageCount; i++) {
            batch.draw(Assets.getSnowball(), 20f + i * 40f, GameConfig.HEIGHT - 120f, 40f, 40f);
        }
    }
}
