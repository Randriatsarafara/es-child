package com.example.eschild.model.accesDistant;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.eschild.model.users.UserLogin;
import com.example.eschild.utils.AccessHttpPost;
import com.example.eschild.utils.AsyncResponse;
import com.example.eschild.utils.Helper;

import org.json.JSONObject;

public class AccesDistantInscription implements AsyncResponse {
    private  static  final String url = "users/inscription";

    @Override
    public void processFinish(String output, int code) {
        try {
            JSONObject json = new JSONObject(output);
            if(code != 200)
                Toast.makeText(activity, json.getString("message"), Toast.LENGTH_SHORT).show();
            else{
                traitSuccessInscription(json);
            }
        }
        catch (Exception e){
            Log.d("expeeee", e.getMessage());
            Toast.makeText(activity, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
        }
    }

    public void traitSuccessInscription(JSONObject json) throws Exception{
        int code = json.getInt("status");
        if(code != 200){
            Toast.makeText(activity, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
            return;
        }
        AccesDistantLogin accesDistantLogin = new AccesDistantLogin();
        accesDistantLogin.envoi(user, activity);
    }

    UserLogin user;
    public void envoi(UserLogin user, Activity activity){
        AccessHttpPost access = new AccessHttpPost();
        this.user = user;
        access.delegate = this;
        this.activity = activity;
        user.addAttributParametre(access.parametres);
        access.execute(Helper.API_URL + url);
    }

    public Activity activity;
    public AccesDistantInscription(){
        super();
    }
}