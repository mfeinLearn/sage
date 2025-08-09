package com.mfein.sage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png"); // Ensure you have an image named "badlogic.jpg" in the assets folder
        setScreen(new MenuScreen(batch, image));
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        super.dispose();
    }
}
