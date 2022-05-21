package com.example.eschild.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;

public class CourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(View.SYSTEM_UI_FLAG_FULLSCREEN,View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cours);
        RecyclerView recyclerView = findViewById(R.id.list_cour);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cour[] c = new Cour[]{
            new Cour("Titre 1","Description 1",R.drawable.documents),
            new Cour("Titre 2","Description 2",R.drawable.videogallery),
            new Cour("Titre 3","Description 3",R.drawable.galerie),
            new Cour("Titre 4","Description 4",R.drawable.videogallery),
            new Cour("Titre 1","Description 1",R.drawable.documents)
        };

        CourAdapter adapter = new CourAdapter(c,CourActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
