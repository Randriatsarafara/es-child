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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccesDistanceCour extends AsyncTask<Void, Void, List> {

    OkHttpClient client = new OkHttpClient();
    Activity activity;
    String idcategory;

    public AccesDistanceCour(Activity activity, String idcategory){
        this.activity = activity;
        this.idcategory = idcategory;
    }
    @Override
    protected List doInBackground(Void... voids) {
        List<Cour> list_cour = new ArrayList<>();
        UserSession user = null;
        try {
            user = UserSession.getSession(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url(Helper.API_URL+"categories/"+idcategory+"/cours")
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
                Cour cat = new Cour(m.get("_id").toString(),m.get("titre").toString(),m.get("_id").toString(),m.get("image").toString(),m.get("sousTitre").toString(),Boolean.parseBoolean(m.get("vue").toString()));
                list_cour.add(i,cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list_cour;
    }
}
