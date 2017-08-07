package com.fsq.bottomnavigationbar;


import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by FuShengqi on 2017/8/7.
 *
 * 在MainActivity中未使用此类，而是使用了匿名的OnTabSelectedListener类
 *
 */

public class TabSelectedListener implements BottomNavigationBar.OnTabSelectedListener {

    private ViewPager mViewPager;

    public TabSelectedListener(ViewPager viewPager){
        mViewPager = viewPager;
    }

    @Override
    public void onTabSelected(int position) {

        switch (position){
            case 0:
                        /*if(mFragmentOne == null){
                            mFragmentOne = FragmentOne.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentOne);
                        Log.d(TAG, "onTabSelected: FragmentOne");*/
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                        /*if(mFragmentTwo == null){
                            mFragmentTwo = FragmentTwo.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentTwo);
                        Log.d(TAG, "onTabSelected: FragmentTwo");*/
                mViewPager.setCurrentItem(1);
                break;
            case 2:
                        /*if(mFramentThree == null){
                            mFramentThree = FragmentThree.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFramentThree);
                        Log.d(TAG, "onTabSelected: FragmentThree");*/
                mViewPager.setCurrentItem(2);
                break;
            case 3:
                        /*if(mFragmentFour == null){
                            mFragmentFour = FragmentFour.newInstance();
                        }
                        transaction.replace(R.id.fragment_container, mFragmentFour);
                        Log.d(TAG, "onTabSelected: FragmentFour");*/
                mViewPager.setCurrentItem(3);
                break;
            default:
        }
        //transaction.commit();
    }
    @Override
    public void onTabUnselected(int position) {
    }
    @Override
    public void onTabReselected(int position) {
    }

}
