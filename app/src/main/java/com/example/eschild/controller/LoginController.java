package com.example.eschild.controller;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.eschild.model.accesDistant.AccesDistantLogin;
import com.example.eschild.model.users.UserLogin;

public final class LoginController {
    private static LoginController instance = null;
    private UserLogin login;
    private static AccesDistantLogin accessDistant;
    private LoginController(){
        super();
    }

////    private ac
//    public void setActivity(Activity activity){
//        LoginController.activity = activity;
//    }
    public static LoginController getInstance(){
        if(instance == null){
            instance = new LoginController();
            accessDistant = new AccesDistantLogin();
//            Toast.makeText(activity, "sjsjsjsjjsjs", Toast.LENGTH_LONG);
        }
        return instance;
    }

    public void login(String numero, String motDePasse, Activity activity){
        login = new UserLogin(numero, motDePasse);
        Log.d("*", "loginController");
        accessDistant.envoi(login, activity);
    }
}
