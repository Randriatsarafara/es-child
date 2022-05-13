package com.example.eschild.view;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;

    @Override
    public int getCount() {
        return this.totalTab;
    }

    int totalTab;

    public LoginAdapter(FragmentManager fm, Context context, int totalTab) {
        super(fm);
        this.context = context;
        this.totalTab = totalTab;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginTab loginTab = new LoginTab();
                return loginTab;
            case 1:
                SignupTab signupTab = new SignupTab();
                return signupTab;
            default:
                return null;
        }
    }
}
