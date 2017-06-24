package com.bignerdranch.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 14.06.2016.
 */
public class BeatBox {
    //для вывода информации в журнал
    private static final String TAG = "BeatBox";

    //для имени папки, в которой были сохранены звуки.
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;


    private List<Sound> mSounds;
    private SoundPool mSoundPool;
    //Для обращения к активам используется класс AssetManager.
    // Экземпляр этого класса можно получить для любой разновидности Context.
    // Так как BeatBox понадобится такой экземпляр, предоставьте ему конструктор,
    // который получает Context, извлекает AssetManager и сохраняет на будущее.
    private AssetManager mAssets;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds() {
        mSounds = new ArrayList<>();
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
            for (String filename : soundNames) {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            }
            }catch(IOException ioe){
                Log.e(TAG, "Could not list assets", ioe);
                return;
            }

        }


    public List<Sound> getSounds() {
        return mSounds;
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setmSoundId(soundId);
    }
    public void play(Sound sound) {
        Integer soundId = sound.getmSoundId();
        if (soundId == null) {
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }
    public void release() {
        mSoundPool.release();
    }
    }
