package com.turtledev.a3_asynctask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 1 on 14.05.2016.
 */
public class Fragment1 extends Fragment {
    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1_layout, null);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((Button)getActivity().findViewById(R.id.btnFind)).setText("Access from Fragment1");
            }
        });

        return v;
    }
}
