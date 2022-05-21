package com.example.eschild.model.accesDistant;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.eschild.model.users.UserLogin;
import com.example.eschild.model.users.UserSession;
import com.example.eschild.utils.AccessHttpPost;
import com.example.eschild.utils.AsyncResponse;
import com.example.eschild.utils.Helper;
import com.example.eschild.view.HomeActivity;

import org.json.JSONObject;

public class AccesDistantLogin implements AsyncResponse {
    private  static  final String url = "users/connexion";

    @Override
    public void processFinish(String output, int code) {
        try {
            JSONObject json = new JSONObject(output);
            if(code != 200)
                Toast.makeText(activity, json.getString("message"), Toast.LENGTH_SHORT).show();
            else{
                traitSuccessLogin(json);
            }
        }
        catch (Exception e){
            Log.d("expeeee", e.getMessage());
            Toast.makeText(activity, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
        }
    }

    public void traitSuccessLogin(JSONObject json) throws Exception{
        Log.d("expeeee", "sssssssssssss");
        int code = json.getInt("status");
        if(code != 200){
            Toast.makeText(activity, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
            return;
        }
        JSONObject data = json.getJSONObject("data");
        UserSession user = new UserSession(data);
        UserSession.saveSession(user, activity);
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void envoi(UserLogin user, Activity activity){
        AccessHttpPost access = new AccessHttpPost();
        access.delegate = this;
        this.activity = activity;
        user.addAttributParametre(access.parametres);
        access.execute(Helper.API_URL + url);
    }

    public Activity activity;
    public AccesDistantLogin(){
        super();
    }
}
