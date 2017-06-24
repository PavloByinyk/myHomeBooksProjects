package com.turtledev.tabstrying;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 1 on 26.05.2016.
 */
public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;
        if(position==0){
            fragment=new Fragment1();
        }
        if(position==1){
            fragment=new Fragment2();
        }
        if(position==2){
            fragment=new Fragment3();
        }

        return fragment;
    }
    public CharSequence getPageTitle(int position) {
        String title="";
        if(position==0){
            title="First";
        }
        if(position==1){
            title="Second";
        }
        if(position==2){
            title="Theerd";
        }

        return title;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
