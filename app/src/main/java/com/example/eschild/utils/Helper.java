package com.example.eschild.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class Helper {
    public static void addParameter(String key, String value, ArrayList<NameValuePair> param){
        param.add(new BasicNameValuePair(key, value));
    }

//    public static final String API_URL = "http://192.168.43.131:8080/api/";
    public static final String API_URL = "https://es-child-backend.onrender.com/api/";
}
