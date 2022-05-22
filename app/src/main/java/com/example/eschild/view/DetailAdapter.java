package com.example.eschild.view;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DetailAdapter extends FragmentPagerAdapter {
    private Context context;
    Cour c;
    @Override
    public int getCount() {
        return this.totalTab;
    }

    int totalTab;

    public DetailAdapter(FragmentManager fm, Context context, int totalTab,Cour c) {
        super(fm);
        this.context = context;
        this.totalTab = totalTab;
        this.c = c;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                DetailTab tab = new DetailTab(c);
                return tab;
            case 1:
                VideoTab videoTab = new VideoTab(c);
                return videoTab;
            default:
                return null;
        }
    }
}
