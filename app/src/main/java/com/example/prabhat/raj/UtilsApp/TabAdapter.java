package com.example.prabhat.raj.UtilsApp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by fluper on 12/2/18.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    private ArrayList<String> titleList = new ArrayList<String>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addTab(Fragment f, String tabTitle){

        fragmentArrayList.add(f);
        titleList.add(tabTitle);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){

        return titleList.get(position);
    }
}
