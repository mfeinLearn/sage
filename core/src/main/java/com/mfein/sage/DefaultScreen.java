package com.mfein.sage;

import com.badlogic.gdx.Screen;

public abstract class DefaultScreen implements Screen {
    public DefaultScreen() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    // ****required**** //

    protected abstract void setPositions();

    protected abstract void createExtraAssets();

    public abstract void setImageButtonListeners(final int i);

    protected abstract void renderExtraStuff(float delta);

    protected abstract void disposeExtraAssets();

    protected abstract void change();
}
