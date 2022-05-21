package com.example.eschild.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.eschild.view.LoginActivity;

public class LogoutController {
    public static void logout(Activity activity){
        SharedPreferences sh = activity.getSharedPreferences("userPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sh.edit();
        edit.clear();
        edit.commit();
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
