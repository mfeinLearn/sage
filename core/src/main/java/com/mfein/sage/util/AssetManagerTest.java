//package com.mfein.sage.util;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.backends.headless.HeadlessApplication;
//import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//
//import static org.junit.Assert.*;
//
//public class AssetManagerTest {
//    private static HeadlessApplication application;
//
//    @BeforeClass
//    public static void setUp() {
//        // Initialize headless application
//        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
//        application = new HeadlessApplication(new com.badlogic.gdx.ApplicationAdapter() {}, config);
//        Gdx.files = new com.badlogic.gdx.backends.headless.HeadlessFiles();
//        Gdx.audio = new com.badlogic.gdx.backends.headless.HeadlessAudio();
//        Gdx.gl = new com.badlogic.gdx.backends.headless.mock.graphics.MockGL20();
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        // Clean up application
//        application.exit();
//        application = null;
//    }
//
//    @Test
//    public void testSingletonInstance() {
//        AssetManager instance1 = AssetManager.getInstance();
//        AssetManager instance2 = AssetManager.getInstance();
//        assertNotNull("Instance should not be null", instance1);
//        assertSame("Instances should be the same (singleton)", instance1, instance2);
//    }
//
//    @Test
//    public void testRegisterAndGetTexture() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerTexture("testTexture", "test.png");
//        Texture texture = manager.getTexture("testTexture");
//        assertNotNull("Texture should not be null", texture);
//        assertTrue("Asset should be a Texture", texture instanceof Texture);
//    }
//
//    @Test
//    public void testRegisterAndGetAudio() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerAudio("testAudio", "test.wav");
//
//        Sound sound = manager.getSound("testAudio");
//        assertNotNull("Sound should not be null", sound);
//        assertTrue("Asset should be a Sound", sound instanceof Sound);
//
//        Music music = manager.getMusic("testAudio");
//        assertNotNull("Music should not be null", music);
//        assertTrue("Asset should be a Music", music instanceof Music);
//    }
//
//    @Test
//    public void testGetNonExistentAsset() {
//        AssetManager manager = AssetManager.getInstance();
//        Object asset = manager.getAsset("nonExistent");
//        assertNull("Non-existent asset should return null", asset);
//
//        Texture texture = manager.getTexture("nonExistent");
//        assertNotNull("Non-existent texture should return placeholder", texture);
//
//        Sound sound = manager.getSound("nonExistent");
//        assertNotNull("Non-existent sound should return error.wav", sound);
//
//        Music music = manager.getMusic("nonExistent");
//        assertNotNull("Non-existent music should return error.wav", music);
//    }
//
//    @Test
//    public void testConvertTextureToDrawable() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerTexture("testTexture", "test.png");
//        TextureRegionDrawable drawable = manager.convertTextureToDrawable("testTexture");
//        assertNotNull("Drawable should not be null", drawable);
//        assertTrue("Should be a TextureRegionDrawable", drawable instanceof TextureRegionDrawable);
//    }
//
//    @Test
//    public void testDisposeAsset() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerTexture("testTexture", "test.png");
//        manager.dispose("testTexture");
//        assertNull("Asset should be removed after disposal", manager.getAsset("testTexture"));
//    }
//
//    @Test
//    public void testDisposeAll() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerTexture("texture1", "test.png");
//        manager.registerAudio("audio1", "test.wav");
//        manager.disposeAll();
//        assertNull("Texture should be removed after disposeAll", manager.getAsset("texture1"));
//        assertNull("Audio should be removed after disposeAll", manager.getAsset("audio1"));
//    }
//
//    @Test
//    public void testInvalidAssetPath() {
//        AssetManager manager = AssetManager.getInstance();
//        manager.registerTexture("invalidTexture", "nonexistent.png");
//        Texture texture = manager.getTexture("invalidTexture");
//        assertNotNull("Invalid texture should return placeholder", texture);
//    }
//}
