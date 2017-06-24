package ua.com.pbyinyk.firstapp;

/**
 * Created by 1 on 30.03.2016.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(boolean mTrueQuestion, int mQuestion) {
        this.mTrueQuestion = mTrueQuestion;
        this.mQuestion = mQuestion;
    }


    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
