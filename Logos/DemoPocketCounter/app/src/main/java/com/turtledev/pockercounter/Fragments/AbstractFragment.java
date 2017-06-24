package com.turtledev.pockercounter.Fragments;

import android.support.v4.app.Fragment;

/**
 * Created by 1 on 26.04.2016.
 */
public class AbstractFragment extends Fragment implements com.turtledev.pockercounter.Interface.Fragment {
    @Override
    public int GetContFragment() {
        return 0;
    }

    @Override
    public int GetItemFragment() {
        return 0;
    }

    @Override
    public void work() {

    }
}
