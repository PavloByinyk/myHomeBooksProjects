package com.bignerdranch.android.photogallery;

import android.net.Uri;

/**
 * Created by 1 on 17.06.2016.
 */
public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrl;
    private String mOwner;

    public String getmCaption() {
        return mCaption;
    }


    public String getOwner() {
        return mOwner;
    }
    public void setOwner(String owner) {
        mOwner = owner;
    }
    public Uri getPhotoPageUri() {
        return Uri.parse("http://www.flickr.com/photos/")
                .buildUpon()
                .appendPath(mOwner)
                .appendPath(mId)
                .build();
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    @Override

    public String toString() {
        return mCaption;
    }
}
