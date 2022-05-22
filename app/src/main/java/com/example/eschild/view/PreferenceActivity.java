package com.example.eschild.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.eschild.R;
import com.example.eschild.controller.LogoutController;
import com.example.eschild.model.users.UserSession;
import com.example.eschild.utils.Helper;

public class PreferenceActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView themeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        getSupportActionBar().hide();
        TextView text = findViewById(R.id.title_lab);
        text.setText("Preference");
        dr = findViewById(R.id.drawer_layout);
        // initializing all our variables.
        radioGroup = findViewById(R.id.idRGgroup);
        themeTV = findViewById(R.id.idtvTheme);
        RadioButton light = findViewById(R.id.idRBLight);
        RadioButton dark = findViewById(R.id.idRBDark);
        light.setChecked(true);
        final int theme = Helper.getTheme(this);
        if(theme == AppCompatDelegate.MODE_NIGHT_YES)
            dark.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.idRBLight:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case R.id.idRBDark:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                }
                int newTheme = theme == AppCompatDelegate.MODE_NIGHT_YES? AppCompatDelegate.MODE_NIGHT_NO: AppCompatDelegate.MODE_NIGHT_YES;
                Helper.saveTheme(PreferenceActivity.this, newTheme);
            }

        });
    }

    DrawerLayout dr;
    public void ClickHome(View view){
        Intent intent = new Intent(PreferenceActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void ClickMenu(View view){
        openDrawer(dr);
    }

    public void Deconnecter(View view){
        LogoutController.logout(PreferenceActivity.this);
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