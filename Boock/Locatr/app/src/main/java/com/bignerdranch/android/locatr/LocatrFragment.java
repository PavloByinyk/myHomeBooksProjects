package com.bignerdranch.android.locatr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by 1 on 12.10.2016.
 */

public class LocatrFragment extends Fragment {

    private ImageView mImageView;
    private Button btn1,btn2;
    private GoogleApiClient mClient;


    public static LocatrFragment newInstance() {
        return new LocatrFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_locatr, container, false);
        mImageView = (ImageView) v.findViewById(R.id.image);
        btn1 = (Button) v.findViewById(R.id.button1);
        btn2 = (Button) v.findViewById(R.id.button2);


        mClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .build();

        return v;
    }

    public void onStart() {
        super.onStart();
        getActivity().invalidateOptionsMenu();
        mClient.connect();
    }
    @Override
    public void onStop() {
        super.onStop();
        mClient.disconnect();
    }
}
