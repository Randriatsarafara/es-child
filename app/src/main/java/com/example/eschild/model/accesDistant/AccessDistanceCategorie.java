package com.example.eschild.model.accesDistant;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.eschild.model.Categorie;
import com.example.eschild.model.users.UserSession;
import com.example.eschild.utils.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccessDistanceCategorie extends AsyncTask<Void, Void, List> {

    OkHttpClient client = new OkHttpClient();
    Activity activity;

    public AccessDistanceCategorie(Activity activity){
        this.activity = activity;
    }
    @Override
    protected List doInBackground(Void... voids) {
        List<Categorie> list = new ArrayList<>();
        UserSession user = null;
        try {
            user = UserSession.getSession(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url(Helper.API_URL+"categories")
                .header("Authorization", "Bearer "+user.getToken())
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();
            JSONObject jsonObject = new JSONObject(res);
            String a = jsonObject.getString("data");
            JSONArray array = new JSONArray(a);
            for(int i = 0; i < array.length(); i++){
                JSONObject m = (JSONObject) array.get(i);
                Categorie cat = new Categorie(m.get("_id").toString(),m.get("nom").toString(),m.get("image").toString(),new Integer(m.get("coursTotal").toString()),new Integer(m.get("coursVue").toString()));
                list.add(i,cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
