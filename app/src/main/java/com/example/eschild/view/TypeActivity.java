package com.example.eschild.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.eschild.R;
import com.example.eschild.controller.LogoutController;
import com.example.eschild.model.users.UserSession;

public class TypeActivity extends AppCompatActivity {

    GridView grid_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(View.SYSTEM_UI_FLAG_FULLSCREEN,View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_type_cour);
        getSupportActionBar().hide();
        dr = findViewById(R.id.drawer_layout);
        TextView text = findViewById(R.id.title_lab);
        text.setText("Type of cour");
        grid_list = findViewById(R.id.listGrid);

        TypeAdapter listAdapter = new TypeAdapter(this);
        grid_list.setAdapter(listAdapter);
    }

    public void ClickPhoto(View view){
        Intent intent = new Intent(TypeActivity.this, VideoActivity.class);
        startActivity(intent);
    }

    public void ClickVideo(View view){
        new AlertDialog.Builder(TypeActivity.this)
                .setTitle("Your Alert")
                .setMessage("View movies")
                .setCancelable(true)
                .show();
    }
    public void ClickDocuments(View view){
        Intent intent = new Intent(TypeActivity.this, VideoActivity.class);
        startActivity(intent);
    }
    public void ClickExercise(View view){
        new AlertDialog.Builder(TypeActivity.this)
                .setTitle("Your Alert")
                .setMessage("View exercise")
                .setCancelable(true)
                .show();
    }

    DrawerLayout dr;
    public void ClickMenu(View view){
        openDrawer(dr);
    }

    public void Deconnecter(View view){
        LogoutController.logout(TypeActivity.this);
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
