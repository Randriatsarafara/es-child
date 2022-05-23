package com.example.eschild.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.eschild.R;
import com.example.eschild.utils.DownLoadImageTask;
import com.example.eschild.utils.Helper;

public class DetailTab extends Fragment {

    WebView webView ;
    ImageView imageView;
    Cour c;

    public DetailTab(Cour c){
        this.c = c;
    }
    public Cour getC() {
        return c;
    }

    public void setC(Cour c) {
        this.c = c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_detail, parent, false);
        webView = root.findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://es-child-backend.onrender.com/html/cours/"+c.getDescription());
        imageView = root.findViewById(R.id.image_detail);
        String [] image = {Helper.URL+"images/cours/"+c.getImage()};
        new DownLoadImageTask(imageView).execute(image);
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
        return root;
    }
}
