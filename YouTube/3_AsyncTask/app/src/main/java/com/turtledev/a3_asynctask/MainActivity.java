package com.turtledev.a3_asynctask;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment2.onSomeEventListener {

    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btnFind);

        Fragment frag2 = new Fragment2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment2, frag2);
        ft.commit();
    }





    @Override
    public void someEvent(String s) {
        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView)frag2.getView().findViewById(R.id.textView2)).setText("Text from Fragment 1:" + s);
    }
}
