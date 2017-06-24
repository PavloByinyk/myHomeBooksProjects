package ua.com.pbyinyk.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 1 on 15.04.2016.
 */
public class Crime {
    private String mTitle;
    private UUID mId;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;

    public String getmSuspect() {
        return mSuspect;
    }

    public void setmSuspect(String mSuspect) {
        this.mSuspect = mSuspect;
    }

    public Crime() {
// Генерирование уникального идентификатора
        mId = UUID.randomUUID();
        mDate = new Date();
       }
    public Crime(UUID id) {
        mId = id;

    }

    public String getmTitle() {
        return mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getmId() {

        return mId;
    }
    public String toString() {
        return mTitle;
    }

    public String getPhotoFilename() {
        return "IMG_" + getmId().toString() + ".jpg";


    }

}