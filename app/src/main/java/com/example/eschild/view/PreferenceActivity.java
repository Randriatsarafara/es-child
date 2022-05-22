package com.example.eschild.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.eschild.R;
import com.example.eschild.utils.Helper;

public class PreferenceActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView themeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

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
}