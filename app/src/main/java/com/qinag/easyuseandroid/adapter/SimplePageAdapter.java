package com.qinag.easyuseandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**假如不是继承FragmentStatePagerAdapter 滚动条
 * Created by qiang on 2016/4/27.
 */
public class SimplePageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;
    FragmentStatePagerAdapter fragmentStatePagerAdapter;

    public SimplePageAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if(fragments==null) return 0;
        return fragments.size();
    }



}
