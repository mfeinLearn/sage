package com.mfein.sage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelScreen extends DefaultScreen {

    private Main gameInstance;
    private Skin skin;
    private Stage stage;
    private Integer start, end;
    private Table stageContainer;

    /**
     * This is the Constructor.
     * @param gameInstance: Main variable.
     * */
    public LevelScreen(Main gameInstance) {
        this.gameInstance = gameInstance;
        start = 0;
        end = 0; // gameInstance.gameStages.size();
        Initialize();
    }

    /**
     * This is the Constructor.
     * @param gameInstance: Main variable.
     * @param start: The position of the starting stage.
     * @param end: The position of the ending stage.
     * */
    public LevelScreen(Main gameInstance, int start, int end) {
        this.gameInstance = gameInstance;
        this.start = start;
        this.end = end;
        Initialize();
    }

    /**
     * This function initializes central components
     */
    private void Initialize() {
        // Initialize the Stage with a ScreenViewport
        stage = new Stage(new ScreenViewport());
        // Set the Stage as the input processor
        Gdx.input.setInputProcessor(stage);

        // Create a Table to hold UI elements
        Table table = new Table();
        table.setFillParent(true); // Make the table fill the stage
        stage.addActor(table);

        // Create a default BitmapFont
        BitmapFont font = new BitmapFont();
        // Create a Label to display text
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);
        Label label = new Label("Level Selection Screen", style);
        label.setAlignment(Align.center);

        // Add the label to the table, centered
        table.add(label).expand().center();
    }

    /**
     * This function calls displayStage of every stage in gameStages
     */
    private void getStage() {
        // Stub: Iterate through stages
    }

    /**
     * This function creates the level button.
     */
    private Button createLevelButton(int stageIndex, int levelIndex) {
        return null; // Stub: Return null button
    }

    /**
     * This function sets up the skin.
     */
    private void initializeSkin() {
        // Stub: Initialize skin
    }

    /**
     * This function handles the button clicks/taps and plays the level assigned to the button.
     * This function also plays the tutorials for the practice mode gameplay and the battle mode.
     * It is assumed the first battle mode is always the 3rd level of the first stage.
     */
    private void addClickListener(Button button, final int stageIndex, final int levelIndex) {
        // Stub: Add click listener to button
    }

    /**
     * This function renders the textures.
     */
    @Override
    public void render(float delta) {
        // Clear the screen with a black background
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        // Update and render the stage
        stage.act(delta);
        stage.draw();
    }

    /**
     * This function disposes of the assets.
     */
    @Override
    public void dispose() {
        // Dispose of the stage and its actors
        if (stage != null) {
            stage.dispose();
        }
    }
}
