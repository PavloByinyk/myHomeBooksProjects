package com.bignerdranch.android.tabsviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bignerdranch.android.tabsviewpager.tabs_fragments.OneFragment;
import com.bignerdranch.android.tabsviewpager.tabs_fragments.TwoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private SmartTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(SmartTabLayout) findViewById(R.id.viewpagertab);
        tabLayout.setViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(OneFragment.newInstance("its for Fragment 1"),"Title FR 1");
        viewPagerAdapter.addFragment(TwoFragment.newInstance("its for Fragment 2"),"Title FR 2");
        //viewPagerAdapter.addFragment(OneFragment.newInstance("its for Fragment 3"),"Title FR 3");
        viewPager.setAdapter(viewPagerAdapter);

        //TODO write adapter for it

    }
}
