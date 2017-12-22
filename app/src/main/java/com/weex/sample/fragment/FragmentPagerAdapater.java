package com.weex.sample.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yangjingchou on 2017/12/19.
 */

//管理fragment

public class FragmentPagerAdapater extends FragmentPagerAdapter {

    private FragmentManager fragmentManager;
    private List<Fragment> listFragment;

    public FragmentPagerAdapater(FragmentManager fm, List<Fragment> list){
            super(fm);
            this.fragmentManager = fm;
            this.listFragment = list;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
