package com.bignerdranch.android.beatbox;

/**
 * Created by 1 on 14.06.2016.
 */
public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;

    }

    public String getName() {
        return mName;
    }

    public Integer getmSoundId() {
        return mSoundId;
    }

    public void setmSoundId(int mSoundId) {
        this.mSoundId = mSoundId;
    }
}
