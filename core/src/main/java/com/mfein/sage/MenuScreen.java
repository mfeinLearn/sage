package com.mfein.sage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.mfein.sage.Menu_Options.Training.TrainingSelectionScreen;
import com.mfein.sage.Menu_Options.Journey.CharacterSelectionScreen;
import com.mfein.sage.Menu_Options.ScoreScreen;
import com.mfein.sage.Menu_Options.StoryScreen;
import com.mfein.sage.Menu_Options.Battle.MultiplayerSelectionScreen;
import com.mfein.sage.util.AssetManager;
import com.mfein.sage.util.Constants;

import com.mfein.sage.DefaultScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreen extends DefaultScreen {
    private Main gameInstance;
    private Stage stage;
    private SpriteBatch spriteBatch;
    private Animation<TextureRegion> ring; // Fixed: Added generics
    private float time = 0f;

    /**
     * This is the Constructor.
     * @param gameInstance: Instance of Main for access to variables stored only in the Main class.
     */
    public MenuScreen(Main gameInstance) {
        this.gameInstance = gameInstance;
        stage = new Stage();
        spriteBatch = new SpriteBatch();

        initMainContainer();

        // Add Textures to the main container
        addLogo();
        addButtons();

        Gdx.input.setInputProcessor(stage); // Allows the stage to take in input
    }

//    /**
//     * This function renders the textures and this includes the ring animation.
//     */
//    @Override
//    public void render(float delta) {
//        stage.act();
//        stage.draw();
//        spriteBatch.begin();
//        time += delta;
//        TextureRegion ringFrame = ring.getKeyFrame(time, true); // Use TextureRegion variable
//        float width = Constants.gameWidth(ringFrame.getRegionWidth());
//        float height = Constants.gameHeight(ringFrame.getRegionHeight());
//        float x = Constants.gameX(0.825f, width);
//        float y = Constants.gameY(0.9f, height);
//        spriteBatch.draw(ringFrame, x, y, width, height);
//        spriteBatch.end();
//    }

    /**
     * This function renders the textures and this includes the ring animation.
     */
    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        spriteBatch.begin();
        time += delta;
        spriteBatch.draw(ring.getKeyFrame(time, true),
            Constants.gameX(.825f, Constants.gameWidth(ring.getKeyFrame(time).getRegionWidth())),
            Constants.gameY(.9f, Constants.gameWidth(ring.getKeyFrame(time).getRegionHeight())),
            Constants.gameWidth(ring.getKeyFrame(time).getRegionWidth()),
            Constants.gameHeight(ring.getKeyFrame(time).getRegionHeight()));
        spriteBatch.end();
    }


    /**
     * Initialize the main table (container) with a background. This table holds
     * and positions all buttons on the menu.
     */
    private void initMainContainer() {
        Table mainContainer = new Table();
        mainContainer.setBackground(AssetManager.getInstance()
            .convertTextureToDrawable("menuBackground"));
        mainContainer.setFillParent(true);
        stage.addActor(mainContainer);
    }

//    /**
//     * This function adds the logo and sets up the ring animation.
//     */
//    private void addLogo() {
//        Image projectGemLogo = new Image(AssetManager.getInstance()
//            .convertTextureToDrawable("gameLogo.png"));
//        ring = new Animation<TextureRegion>(1/7f, (new TextureAtlas(
//            Gdx.files.internal("Ring/RingWand.txt"))).getRegions()); // Fixed: Added generics
//        float width = Constants.gameWidth(projectGemLogo.getWidth() * 1.75f);
//        float height = Constants.gameHeight(projectGemLogo.getHeight() * 1.75f);
//        projectGemLogo.setSize(width, height);
//        projectGemLogo.setPosition(Constants.gameX(.4f, width), Constants.gameY(.85f, height));
//        stage.addActor(projectGemLogo);
//    }

    /**
     * This function adds the logo and sets up the ring animation.
     */
//    private void addLogo() {
//        Image projectGemLogo = new Image(AssetManager.getInstance()
//            .convertTextureToDrawable("gameLogo.png"));
//        ring = new Animation<TextureRegion>(1/7f, (new TextureAtlas(
//            Gdx.files.internal("Ring/RingWand.txt"))).getRegions());
///*        chest = new Animation(1/15f, (new TextureAtlas(
//                Gdx.files.internal("Chest/chestOpen.txt"))).getRegions());*/
//        float width = Constants.gameWidth(projectGemLogo.getWidth()*1.75f);
//        float height = Constants.gameHeight(projectGemLogo.getHeight()*1.75f);
//        projectGemLogo.setSize(width, height);
//        projectGemLogo.setPosition(Constants.gameX(.4f, width), Constants.gameY(.85f, height));
//        stage.addActor(projectGemLogo);
//    }
    private void addLogo() {
        Image projectGemLogo = new Image(AssetManager.getInstance()
            .convertTextureToDrawable("gameLogo.png"));

        // Create the ring animation
        TextureAtlas ringAtlas = new TextureAtlas(Gdx.files.internal("Ring/RingWand.txt"));
        Array<TextureAtlas.AtlasRegion> ringRegions = ringAtlas.getRegions();
        TextureRegion[] ringFrames = ringRegions.toArray(TextureRegion.class);
        ring = new Animation<TextureRegion>(1/7f, ringFrames);

        // Uncomment and fix the chest animation similarly
        /*
        TextureAtlas chestAtlas = new TextureAtlas(Gdx.files.internal("Chest/chestOpen.txt"));
        Array<AtlasRegion> chestRegions = chestAtlas.getRegions();
        TextureRegion[] chestFrames = chestRegions.toArray(TextureRegion.class);
        chest = new Animation<TextureRegion>(1/15f, chestFrames);
        */

        float width = Constants.gameWidth(projectGemLogo.getWidth() * 1.75f);
        float height = Constants.gameHeight(projectGemLogo.getHeight() * 1.75f);
        projectGemLogo.setSize(width, height);
        projectGemLogo.setPosition(Constants.gameX(0.4f, width), Constants.gameY(0.85f, height));
        stage.addActor(projectGemLogo);
    }

    /**
     * This function adds the menu buttons to the Screen.
     */
    private void addButtons() {
        setButton("training", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameInstance.setScreen(new TrainingSelectionScreen(gameInstance));
                System.out.println("Playing training Screen");
                dispose();
            }
        }, 0);

        setButton("journey", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //AssetManager.getInstance().getSound("button-click").play();
                gameInstance.setScreen(new CharacterSelectionScreen(gameInstance));
                dispose();
            }
        }, 1);

        setButton("story", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameInstance.setScreen(new StoryScreen(gameInstance));
                System.out.println("Playing Story Screen");
                dispose();
            }
        }, 2);

        setButton("multiplayer", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameInstance.setScreen(new MultiplayerSelectionScreen(gameInstance));
                dispose();
            }
        }, 3);

        setButton("scores", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameInstance.setScreen(new ScoreScreen(gameInstance));
            }
        }, 4);
    }

    /**
     * This function sets up the basic button stuff.
     */
    private void setButton(String s, ChangeListener listener, int i) {
        TextureRegionDrawable buttonIcon = AssetManager.getInstance()
            .convertTextureToDrawable(s + "Button.png");
        TextureRegionDrawable buttonLogo = AssetManager.getInstance()
            .convertTextureToDrawable(s + "Logo.png");
        ImageButton imageButton = new ImageButton(buttonIcon);
        imageButton.add(new Image(buttonLogo));
        float width = Constants.gameWidth(256f + 60f * s.length());
        float height = Constants.gameHeight(192f);
        imageButton.setSize(width, height);
        imageButton.setPosition(Constants.gameX(.35f, 0),
            Constants.gameY(.65f - (.15f * i), height));
        imageButton.addListener(listener);
        stage.addActor(imageButton);
    }

    /**
     * This function disposes of the assets.
     */
    @Override
    public void dispose() {
        stage.dispose();
        spriteBatch.dispose();
        // Dispose of ring animation textures
        for (TextureRegion region : ring.getKeyFrames()) {
            if (region.getTexture() != null) {
                region.getTexture().dispose();
            }
        }
    }



    // ****required*** //

    @Override
    protected void setPositions() {

    }

    @Override
    protected void createExtraAssets() {

    }

    @Override
    public void setImageButtonListeners(int i) {

    }

    @Override
    protected void renderExtraStuff(float delta) {

    }

    @Override
    protected void disposeExtraAssets() {

    }

    @Override
    protected void change() {

    }
}
