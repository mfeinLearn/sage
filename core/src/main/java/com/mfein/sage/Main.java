package com.mfein.sage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mfein.sage.util.AssetManager;

public class Main extends Game {
    private SpriteBatch batch;
    private Texture image;



    @Override
    public void create() {
        boolean runTests = false; // Set to false to skip tests
        if (runTests) {
            testAssetManager();
        }
        setScreen(new LevelScreen(this));// setScreen(new MenuScreen(batch, image));

    }


    public void testAssetManager() {
        AssetManager manager = AssetManager.getInstance();

        // Test 1: Register and get texture
        manager.registerTexture("testTexture", "test.png");
        Texture texture = manager.getTexture("testTexture");
        Gdx.app.log("AssetManagerTest", "Texture loaded: " + (texture != null));

        // Test 2: Register and get audio
        manager.registerAudio("testAudio", "test.wav");
        Sound sound = manager.getSound("testAudio");
        Music music = manager.getMusic("testAudio");
        Gdx.app.log("AssetManagerTest", "Sound loaded: " + (sound != null));
        Gdx.app.log("AssetManagerTest", "Music loaded: " + (music != null));

        // Test 3: Convert texture to drawable
        TextureRegionDrawable drawable = manager.convertTextureToDrawable("testTexture");
        Gdx.app.log("AssetManagerTest", "Drawable created: " + (drawable != null));

        // Test 4: Test non-existent asset
        Texture nonExistent = manager.getTexture("nonExistent");
        Gdx.app.log("AssetManagerTest", "Non-existent texture fallback: " + (nonExistent != null));

        // Test 5: Dispose asset
        manager.dispose("testTexture");
        Gdx.app.log("AssetManagerTest", "Texture after dispose: " + (manager.getAsset("testTexture") == null));

        // Test 6: Dispose all
        manager.disposeAll();
        Gdx.app.log("AssetManagerTest", "All assets after disposeAll: " + (manager.getAsset("testAudio") == null));
    }

    @Override
    public void dispose() {
        AssetManager.getInstance().disposeAll(); // Ensure cleanup
        batch.dispose();
        image.dispose();
        super.dispose();
    }

}
