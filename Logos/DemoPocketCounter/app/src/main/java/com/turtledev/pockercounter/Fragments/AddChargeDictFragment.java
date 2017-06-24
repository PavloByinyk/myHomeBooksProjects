package com.turtledev.pockercounter.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turtledev.pockercounter.R;

/**
 * Created by 1 on 24.04.2016.
 */
public class AddChargeDictFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addcd_layout,container,false);
    }
}
