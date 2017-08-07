package com.fsq.bottomnavigationbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取ViewPager并添加适配器
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.fragment_container);

        FragmentManager manager = getSupportFragmentManager();
        final FragmentPagerAdapter adapter = new FragmentPagerAdapter(manager);
        mViewPager.setAdapter(adapter);


        //获取BottomNavigationBar
        final BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        //设置BottomNavigationBar的背景颜色和外观
        bottomNavigationBar.setBarBackgroundColor(R.color.white);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

//        TabSelectedListener listener = new TabSelectedListener(mViewPager);
//        bottomNavigationBar.setTabSelectedListener(listener);

        //在ViewPager滑动时，重写onPageSelected函数设置底部的bottomNavigationBar
        //会跟着ViewPager滑动的位置来选择并高亮bottomNavigationBar上的Item
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置BottomNavigationBar上item的监听函数
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                switch (position){
                    case 0:
                        //mViewPager.clearAnimation();
                        mViewPager.setCurrentItem(0, false);   //点击BottomNavigationBar上第0个item，同时将ViewPager设为第0页
                        break;                                 //设置第2个参数为false，去掉页面切换的平滑过渡；不设置第2个参数则平滑过渡
                    case 1:
                        //mViewPager.clearAnimation();
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case 2:
                        //mViewPager.clearAnimation();
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case 3:
                        //mViewPager.clearAnimation();
                        mViewPager.setCurrentItem(3, false);
                        break;
                    default:
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });


        //在BottomNavigationBar上添加4个项目，对应4个Fragment
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.all, "动态"))
                .addItem(new BottomNavigationItem(R.drawable.video, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.task, "音乐"))
                .addItem(new BottomNavigationItem(R.drawable.account_filling, "我"))
                .initialise();
    }
}
