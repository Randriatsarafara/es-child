package com.example.eschild.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class Helper {
    public static void addParameter(String key, String value, ArrayList<NameValuePair> param){
        param.add(new BasicNameValuePair(key, value));
    }

//    public static final String API_URL = "http://192.168.43.131:8080/api/";
    public static final String API_URL = "https://es-child-backend.onrender.com/api/";

    public static void setTheme(Activity activity){
        SharedPreferences sh = activity.getSharedPreferences("preference", Context.MODE_PRIVATE);
        int theme = sh.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(theme);
        saveTheme(activity, theme);
    }

    public static int getTheme(Activity activity){
        SharedPreferences sh = activity.getSharedPreferences("preference", Context.MODE_PRIVATE);
        int theme = sh.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
//        AppCompatDelegate.setDefaultNightMode(theme);
        return theme;
    }


    public static void saveTheme(Activity activity, int theme){
        SharedPreferences sh = activity.getSharedPreferences("preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sh.edit();
        edit.putInt("theme", theme);
        edit.commit();
    }

}
