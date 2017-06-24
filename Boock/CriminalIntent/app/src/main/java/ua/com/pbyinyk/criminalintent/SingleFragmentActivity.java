package ua.com.pbyinyk.criminalintent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 1 on 01.05.2016.
 */
abstract class SingleFragmentActivity extends AppCompatActivity{


        protected abstract Fragment createFragment();
    @LayoutRes
    protected int getLayoutResId(){

        return R.layout.activity_twopane;
}


    @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.d("MyLog", " зайшли в мейн SingleFragmentActivity");
            super.onCreate(savedInstanceState);
            setContentView(getLayoutResId());

            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
            if (fragment == null) {
                fragment = createFragment();
                fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
            }
        }



}