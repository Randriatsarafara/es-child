package com.example.eschild.model.accesDistant;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.eschild.model.users.UserSession;
import com.example.eschild.utils.Helper;
import com.example.eschild.view.Cour;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccesDistanceDetail extends AsyncTask<Void, Void, Cour> {

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();
    Activity activity;
    String idcour;

    public AccesDistanceDetail(Activity activity, String idcour){
        this.activity = activity;
        this.idcour = idcour;
    }
    @Override
    protected Cour doInBackground(Void... voids) {
        List<Cour> list_cour = new ArrayList<>();
        UserSession user = null;
        try {
            user = UserSession.getSession(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url(Helper.API_URL+"cours/"+idcour)
                .header("Authorization", "Bearer "+user.getToken())
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();
            JSONObject jsonObject = new JSONObject(res);
            String a = jsonObject.getString("data");
            JSONObject m = new JSONObject(a);
            String video = m.get("videos").toString();
            JSONArray arr = new JSONArray(video);
            String [] temp = new String[arr.length()];
            for(int i = 0; i < arr.length(); i++){
                temp[i] = arr.get(i).toString();
            }
            Cour cat = new Cour(m.get("_id").toString(),m.get("titre").toString(),m.get("description").toString(),m.get("image").toString(),m.get("sousTitre").toString(),temp);
            return cat;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}