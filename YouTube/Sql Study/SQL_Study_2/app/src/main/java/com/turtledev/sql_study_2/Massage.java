package com.turtledev.sql_study_2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 1 on 27.05.2016.
 */
public class Massage {
    public static void massage(Context context,String massage){
        Toast.makeText(context,massage,Toast.LENGTH_SHORT).show();
    }
}
