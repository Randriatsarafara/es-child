package com.example.eschild.controller;

import android.app.Activity;
import android.util.Log;

import com.example.eschild.model.accesDistant.AccesDistantInscription;
import com.example.eschild.model.users.UserLogin;

public class InscriptionController {
    private static InscriptionController instance = null;
    private UserLogin login;
    private static AccesDistantInscription accessDistant;
    private InscriptionController(){
        super();
    }
    private Activity activity;

    public static InscriptionController getInstance(Activity activity){
        if(instance == null){
            instance = new InscriptionController();
            accessDistant = new AccesDistantInscription();
        }
        instance.activity = activity;
        return instance;
    }

    public void login(String numero, String motDePasse, String pseudo){
        login = new UserLogin(numero, motDePasse, pseudo);
        accessDistant.envoi(login, activity);
    }

}
