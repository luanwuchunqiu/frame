package com.example.zyt.frame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by zyt on 2017/9/7.
 */

public class MianViewPaperAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    public MianViewPaperAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }



}
