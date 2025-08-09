package com.mfein.sage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen extends DefaultScreen {
    private SpriteBatch batch;
    private Texture image;

    public MenuScreen(SpriteBatch batch, Texture image) {
        this.batch = batch;
        this.image = image;
    }

    @Override
    public void render(float delta) {
        // Clear the screen with a solid color (e.g., black)
        ScreenUtils.clear(1, 1, 0, 1);

        // Begin the SpriteBatch
        batch.begin();
        // Draw the image at coordinates (0, 0)
        batch.draw(image, 0, 0);
        // End the SpriteBatch
        batch.end();
    }

    @Override
    public void dispose() {
        // Resources are disposed of in MainGame, so no need to dispose here
    }
}
