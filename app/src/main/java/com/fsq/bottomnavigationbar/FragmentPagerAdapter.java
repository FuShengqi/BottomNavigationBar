package com.fsq.bottomnavigationbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FuShengqi on 2017/8/7.
 *
 * ViewPager适配器
 *
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "FragmentPagerAdapter";

    private List<Fragment> mFragments = new ArrayList<>();

    public FragmentPagerAdapter(FragmentManager manager){
        super(manager);
        mFragments.add(FragmentOne.newInstance());
        mFragments.add(FragmentTwo.newInstance());
        mFragments.add(FragmentThree.newInstance());
        mFragments.add(FragmentFour.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
