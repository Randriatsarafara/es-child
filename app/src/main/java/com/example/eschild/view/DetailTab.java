package com.example.eschild.view;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.eschild.R;

public class DetailTab extends Fragment {

    WebView webView ;
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

        return root;
    }
}
