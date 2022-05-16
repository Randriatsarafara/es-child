package com.example.eschild.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eschild.R;

public class HomeActivity extends AppCompatActivity {
    //Initialisation variable
    DrawerLayout dr;
    ListView listeView;
    String titre[] = {"Cartoon","Alphabet","Number","Animal"};
    String desc[] = {"1/12","2/6","3/3","1/10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().hide();
        TextView text = findViewById(R.id.title_lab);
        text.setText("Category");
        dr = findViewById(R.id.drawer_layout);

        listeView = findViewById(R.id.listView);

        CategoryAdapter listAdapter = new CategoryAdapter(this,titre,desc);

        listeView.setAdapter(listAdapter);

    }


    public void ClickMenu(View view){
        openDrawer(dr);
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
}
