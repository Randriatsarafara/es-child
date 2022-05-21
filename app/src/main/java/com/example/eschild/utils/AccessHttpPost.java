package com.example.eschild.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.util.ArrayList;

public class AccessHttpPost extends AsyncTask <String, Integer, Long>{

    public AsyncResponse delegate;
    String ret;
    int code; // status code
    public ArrayList<NameValuePair> parametres;

    public AccessHttpPost(){
        parametres = new ArrayList<NameValuePair>();
    }

    @Override
    protected Long doInBackground(String... strings) {
        Log.d("*******", "skssksksksksk");
        Log.d("*******", strings[0]);
        HttpClient cnx = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(strings[0]);
        try{
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));
//            paramCnx.getParams().setParameter("pseudo", "pseudo");
//            paramCnx.getParams().setParameter("motDePasse", "pseudo");
            HttpResponse resp = cnx.execute(paramCnx);
            code = resp.getStatusLine().getStatusCode();
            ret = EntityUtils.toString(resp.getEntity());
        }
        catch(Exception e){
            e.printStackTrace();
            Log.d("*******", e.toString());
//            Log.d("*******", e.);
            Log.d("*******", e.getMessage());
        }
        return null;
    }

//    @Override
//    protected Void doInBackground(Void... voids) {
//        return null;
//        AndroidNetworking.post("http://localhost:8080/api/categories")
//                .setPriority(Priority.LOW)
//                .build()
//                .getAsJSONArray(new JSONArrayRequestListener() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        // do anything with response
//                        Log.d("***********************", response.toString());
//                    }
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                        error.printStackTrace();
//                        Log.d("***********************", error.getMessage());
//                    }
//                });
//        AndroidNetworking.post("http://localhost:8080/api/").addBodyParameter(null)
//                .build()
//                .getAsJSONArray(new JSONArrayRequestListener() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        // do anything with response
//                        Log.d("***********************", response.toString());
//                    }
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                        error.printStackTrace();
//                        Log.d("***********************", error.getMessage());
//                    }
//                });
//        return null;
//    }

    @Override
    protected void onPostExecute(Long res){
        delegate.processFinish(ret, code);
    }
}
