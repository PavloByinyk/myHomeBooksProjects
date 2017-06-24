package com.bignerdranch.android.minesweeper.views.grid;

import android.content.Context;
import android.view.View;

import com.bignerdranch.android.minesweeper.GameEngine;

/**
 * Created by 1 on 01.12.2016.
 */

public abstract class BaseCell extends View{

    private int value;
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isClicked;
    private boolean isFlagget;

    private int x, y;
    private int position;

    public BaseCell(Context context) {
        super(context);
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        isBomb = false;
        isRevealed = false;
        isFlagget = false;
        isClicked = false;

        if ( value == -1){
            isBomb = true;
        }

        this.value = value;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
        invalidate();
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        isClicked = true;
        isRevealed = true;

        invalidate();
    }

    public boolean isFlagget() {
        return isFlagget;
    }

    public void setFlagget(boolean flagget) {
        isFlagget = flagget;
    }


    public int getXPos() {
        return x;
    }




    public int getYPos() {
        return y;
    }



    public int getPosition() {
        return position;
    }


    public void setPosition( int x , int y ){
        this.x = x;
        this.y = y;

        this.position = y * GameEngine.WIDTH + x;

        invalidate();
    }
}
