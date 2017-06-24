package com.turtledev.dynimickfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turtledev.dynimickfragments.R;

/**
 * Created by 1 on 20.04.2016.
 */
public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two_fragment,null);
    }
}
