package com.turtledev.tabstrying;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabLayout.Tab tab1, tab2, tab3, tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ViewPager  viewPager;


        viewPager=(ViewPager)findViewById(R.id.pager) ;
        final TabLayout mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));





        tab1=mTabLayout.newTab();

        tab2=mTabLayout.newTab();
        tab3=mTabLayout.newTab();

        mTabLayout.addTab(tab1);
        mTabLayout.addTab(tab2);
        mTabLayout.addTab(tab3);
        mTabLayout.setupWithViewPager(viewPager);

         }





    }
