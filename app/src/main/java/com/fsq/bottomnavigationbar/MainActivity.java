package com.fsq.bottomnavigationbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_DEFAULT;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_STATIC;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    Fragment mFragmentOne, mFragmentTwo, mFramentThree, mFragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mFragmentOne == null){
            mFragmentOne = FragmentOne.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment_container, mFragmentOne).commit();
        }

        final BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setBarBackgroundColor(R.color.white);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                switch (position){
                    case 0:
                        if(mFragmentOne == null){
                            mFragmentOne = FragmentOne.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentOne);
                        Log.d(TAG, "onTabSelected: FragmentOne");
                        break;
                    case 1:
                        if(mFragmentTwo == null){
                            mFragmentTwo = FragmentTwo.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentTwo);
                        Log.d(TAG, "onTabSelected: FragmentTwo");
                        break;
                    case 2:
                        if(mFramentThree == null){
                            mFramentThree = FragmentThree.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFramentThree);
                        Log.d(TAG, "onTabSelected: FragmentThree");
                        break;
                    case 3:
                        if(mFragmentFour == null){
                            mFragmentFour = FragmentFour.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentFour);
                        Log.d(TAG, "onTabSelected: FragmentFour");
                        break;
                    default:
                }
                transaction.commit();
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.all, "动态"))
                .addItem(new BottomNavigationItem(R.drawable.video, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.task, "音乐"))
                .addItem(new BottomNavigationItem(R.drawable.account_filling, "我"))
                .initialise();
    }
}
