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

    protected abstract void setPositions();

    protected abstract void createExtraAssets();

    public abstract void setImageButtonListeners(final int i);

    protected abstract void renderExtraStuff(float delta);

    protected abstract void disposeExtraAssets();

    protected abstract void change();
}
//
//package com.mfein.sage;
//
//import com.badlogic.gdx.Screen;
///**
// * A custom abstract class that implements the LibGDX Screen interface.
// * Extend this class when creating new screens to avoid overriding unused Screen methods.
// * This is a project-specific base class and not part of the LibGDX library.
// */
//public abstract class DefaultScreen implements Screen {
//
//    public DefaultScreen() {
//    }
//
//    @Override
//    public void show() {
//    }
//
//    @Override
//    public void render(float delta) {
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void dispose() {
//    }
//}
