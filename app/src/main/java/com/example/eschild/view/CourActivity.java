package com.example.eschild.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;
import com.example.eschild.controller.LogoutController;
import com.example.eschild.model.accesDistant.AccesDistanceCour;
import com.example.eschild.model.users.UserSession;

import java.util.ArrayList;
import java.util.List;

public class CourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(View.SYSTEM_UI_FLAG_FULLSCREEN,View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cours);
        TextView text = findViewById(R.id.title_lab);
        text.setText("List of cour");
        dr = findViewById(R.id.drawer_layout);
        RecyclerView recyclerView = findViewById(R.id.list_cour);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Intent intent = getIntent();
        String idcategory = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);

        List<Cour> list = new ArrayList<>();
        initializeProfilPseudo();
        try {
            AccesDistanceCour access = new AccesDistanceCour(this,idcategory);
            list = access.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CourAdapter adapter = new CourAdapter(list,CourActivity.this);
        recyclerView.setAdapter(adapter);
    }
    DrawerLayout dr;
    public void ClickMenu(View view){
        openDrawer(dr);
    }

    public void Deconnecter(View view){
        LogoutController.logout(CourActivity.this);
    }

    private static void openDrawer(DrawerLayout dr) {
        dr.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(dr);
    }

    private static void closeDrawer(DrawerLayout dr) {
        if(dr.isDrawerOpen(GravityCompat.START)){
            dr.closeDrawer(GravityCompat.START);
        }
    }

    public void initializeProfilPseudo(){
        TextView pseudo = findViewById(R.id.profilPseudo);
        try {
            UserSession user = UserSession.getSession(this);
            pseudo.setText(user.getPseudo());
        }
        catch (Exception e){
            Log.d("exception", "---------" + e.getMessage());
        }
    }
}
