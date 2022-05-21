package com.example.eschild.model.users;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONObject;

public class UserSession extends UserLogin {
    String token;
    String id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserSession(String pseudo, String motDePasse, String numero, String token, String id) {
        super(pseudo, motDePasse, numero);
        this.token = token;
        this.id = id;
    }

    public UserSession(JSONObject json) throws  Exception{
        super(json.getString("pseudo"), json.getString("motDePasse"), json.getString("numero"));
        try{
            setToken(json.getString("token"));
        }
        catch (Exception e){}
        setId(json.getString("_id"));
    }

    public JSONObject toJSONObject()throws  Exception{
        JSONObject rep = new JSONObject();
        rep.put("pseudo", pseudo);
        rep.put("motDePasse", motDePasse);
        rep.put("numero", numero);
        rep.put("token", token);
        rep.put("_id", id);
        return rep;
    }

    public static void saveSession(UserSession session, Activity activity)throws Exception{
        Log.d("---------1", "__________________________________________");
        JSONObject json = session.toJSONObject();
        SharedPreferences sh = activity.getSharedPreferences("userPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sh.edit();
        edit.putString("user", json.toString());
        edit.commit();
        String st = sh.getString("user", null);
        Log.d("---------1", st);
    }

    public static UserSession getSession(Activity activity) throws Exception{
        SharedPreferences sh = activity.getSharedPreferences("userPref", Context.MODE_PRIVATE);
        String st = sh.getString("user", null);
//        Log.d("---------", st);
        if(st == null)
            return null;
        JSONObject json = new JSONObject(st);
        return new UserSession(json);
    }
}
