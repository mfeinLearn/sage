package com.mfein.sage.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Manages the background music and sound effects in the game.
 * @author Faizaan Datoo
 */
public class MusicManager {

    private Array<Music> musics;
    private Music currentMusic = null;
    private int currentId = -1;
    private float volume = 1.0f; // Default volume to audible level

    public MusicManager() {
        musics = new Array<Music>();
        registerMusic();
        // Start the first track
        getNextTrack();
    }

    /**
     * Register all the background music.
     */
    private void registerMusic() {
        musics.add(AssetManager.getInstance().getMusic("music0"));
        musics.add(AssetManager.getInstance().getMusic("music1"));
        musics.add(AssetManager.getInstance().getMusic("music2"));
        System.out.println("Registered " + musics.size + " music tracks");
    }

    /**
     * Play a sound effect or music track by key.
     */
    public void playMusic(String name) {
        if (name.startsWith("music")) { // Assuming music keys start with "music"
            Music music = AssetManager.getInstance().getMusic(name);
            if (music != null) {
                System.out.println("Playing music: " + name);
                music.setVolume(1.0f);
                music.setLooping(false); // Set to true if looping is desired
                music.play();
            } else {
                System.out.println("Music not found: " + name);
            }
        } else {
            Sound sound = AssetManager.getInstance().getSound(name);
            if (sound != null) {
                System.out.println("Playing sound: " + name);
                sound.play(1.0f);
            } else {
                System.out.println("Sound not found: " + name);
            }
        }
    }

    /**
     * Play a sequence of music tracks from the registered music list.
     */
    public void playMusic(final String[] list) {
        if (list.length == 0) {
            System.out.println("No music tracks provided in list");
            return;
        }

        // Stop current background music
        if (currentMusic != null) {
            currentMusic.pause(); // Pause instead of stop to resume later
        }

        final Music[] musicList = new Music[list.length];
        for (int i = 0; i < list.length; i++) {
            musicList[i] = AssetManager.getInstance().getMusic(list[i]);
            if (musicList[i] == null) {
                System.out.println("Music not found: " + list[i]);
                return;
            }
        }

        for (int i = 0; i < musicList.length; i++) {
            musicList[i].setVolume(1.0f);
            musicList[i].setLooping(false);
            final int finalI = i;
            musicList[i].setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(Music music) {
                    System.out.println("Completed music: " + list[finalI]);
                    if (finalI == list.length - 1) {
                        // Resume background music
                        if (currentMusic != null) {
                            System.out.println("Resuming background music: " + currentId);
                            currentMusic.play();
                        }
                    } else {
                        musicList[finalI + 1].play();
                    }
                }
            });
        }
        System.out.println("Playing music sequence: " + list[0]);
        musicList[0].play();
    }

    /**
     * Stop all playing music.
     */
    public void dispose() {
        if (currentMusic != null) {
            currentMusic.stop();
            System.out.println("Stopped current music");
        }
        // Music objects are managed by AssetManager, so no need to dispose here
        musics.clear();
    }

    /**
     * Get the next track from the music list.
     */
    private void getNextTrack() {
        if (musics.size == 0) {
            System.out.println("No music tracks available");
            return;
        }

        currentId++;
        if (currentId >= musics.size) {
            currentId = 0;
        }

        currentMusic = musics.get(currentId);
        currentMusic.setLooping(false); // Set to true if continuous looping is desired
        currentMusic.setVolume(volume);
        currentMusic.setOnCompletionListener(completionListener);

        System.out.println("Playing background music track " + currentId + ": music" + currentId);
        currentMusic.play();
    }

    /** Play the next track when the song completes. */
    OnCompletionListener completionListener = new OnCompletionListener() {
        @Override
        public void onCompletion(Music music) {
            System.out.println("Music track completed, switching to next");
            getNextTrack();
        }
    };

    /**
     * Set the volume for background music.
     */
    public void setVolume(float volume) {
        this.volume = MathUtils.clamp(volume, 0.0f, 1.0f);
        if (currentMusic != null) {
            currentMusic.setVolume(this.volume);
        }
    }
}

//package com.mfein.sage.util;
//
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Music.OnCompletionListener;
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.async.AsyncExecutor;
//
///**
// * Manages the background music in the game.
// * @author Faizaan Datoo
// */
//public class MusicManager {
//
//    private Array<Music> musics;
//    private Music currentMusic = null;
//    private int currentId = -1;
//    private float volume = 0f;
//
//    public MusicManager() {
//        musics = new Array<Music>();
//        registerMusic();
//        // Start the first track
//        if (currentId == -1) {
//            // Choose a random song and play it
//            currentId = MathUtils.random(musics.size) - 1;
//            getNextTrack();
//            return;
//        }
//    }
//
//    /**
//     * Register all the background music.
//     */
//    private void registerMusic() {
//        musics.add(AssetManager.getInstance().getMusic("music0"));
//        musics.add(AssetManager.getInstance().getMusic("music1"));
//        musics.add(AssetManager.getInstance().getMusic("music2"));
//    }
//
//    /**
//     * Play gameplay music while turning down the background music.
//     */
//    public void playMusic(String name) {
//        AssetManager.getInstance().getSound(name).play(1f);
//    }
//
//    /**
//     * Play gameplay music while turning down the background music.
//     */
//    public void playMusic(final String[] list) {
//        //currentMusic.stop();
//        final Music[] musicList = new Music[list.length];
//        for(int i = 0; i < list.length; i++) {
//            musicList[i] = Gdx.audio.newMusic(AssetManager.getInstance().getAssetFile(list[i]));
//        }
//        for (int i = 0; i < musicList.length; i++) {
//            musicList[i].setVolume(1f);
//            musicList[i].setLooping(false);
//            final int finalI = i;
//            musicList[i].setOnCompletionListener(new Music.OnCompletionListener() {
//                @Override
//                public void onCompletion(Music music) {
//                    if (finalI == list.length - 1) {
//                        musicList[finalI].dispose();
//                        // currentMusic.play();
//                    } else {
//                        musicList[finalI + 1].play();
//                        musicList[finalI].dispose();
//                    }
//                }
//            });
//        }
//        musicList[0].play();
//    }
//
//    /**
//     * Stop all playing music.
//     */
//    public void dispose() {
//        currentMusic.stop();
//        musics.clear();
//    }
//
//    /**
//     * Get the next track from the music list.
//     */
//    private void getNextTrack() {
//        currentId++;
//        if (currentId > musics.size - 1) currentId = 0;
//
//        // Get the next music and set it to not loop and set the volume to the
//        // set volume above.
//        currentMusic = musics.get(currentId);
//        currentMusic.setLooping(false);
//        currentMusic.setVolume(volume);
//
//        // Add the completion listener, so the music changes to the next when it
//        // finishes.
//        currentMusic.setOnCompletionListener(completionListener);
//
//        currentMusic.play();
//    }
//
//    /** Play the next track when the song completes. */
//    OnCompletionListener completionListener = new OnCompletionListener() {
//        @Override
//        public void onCompletion(Music music) {
//            getNextTrack();
//        }
//    };
//
//}
