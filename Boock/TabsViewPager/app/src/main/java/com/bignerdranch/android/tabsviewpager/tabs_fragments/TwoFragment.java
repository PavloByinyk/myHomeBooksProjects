package com.bignerdranch.android.tabsviewpager.tabs_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.tabsviewpager.R;

/**
 * Created by 1 on 19.07.2016.
 */
public class TwoFragment extends Fragment {

    private static final String ARGS_EXEMPLE ="arguments" ;
    private String exampleData;

    public TwoFragment() {
    }

    public static TwoFragment newInstance(String arguments){
        TwoFragment oneFragment=new TwoFragment();
        Bundle args=new Bundle();
        args.putSerializable(ARGS_EXEMPLE,arguments);
        oneFragment.setArguments(args);
        return oneFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleData=getArguments().getString(ARGS_EXEMPLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two_fragment,container,false);
    }
}
