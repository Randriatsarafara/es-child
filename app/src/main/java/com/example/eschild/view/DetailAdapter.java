package com.example.eschild.view;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DetailAdapter extends FragmentPagerAdapter {
    private Context context;

    @Override
    public int getCount() {
        return this.totalTab;
    }

    int totalTab;

    public DetailAdapter(FragmentManager fm, Context context, int totalTab) {
        super(fm);
        this.context = context;
        this.totalTab = totalTab;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                DetailTab tab = new DetailTab();
                return tab;
            case 1:
                VideoTab videoTab = new VideoTab();
                return videoTab;
            default:
                return null;
        }
    }
}
