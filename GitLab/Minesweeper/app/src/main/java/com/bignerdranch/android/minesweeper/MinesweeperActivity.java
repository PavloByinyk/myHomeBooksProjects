package com.bignerdranch.android.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MinesweeperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minesweeper);

        GameEngine.getInstance().createGrid(this);
    }
}
