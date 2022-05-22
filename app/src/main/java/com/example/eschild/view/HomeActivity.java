package com.example.eschild.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.eschild.R;
import com.example.eschild.controller.LogoutController;
import com.example.eschild.model.users.UserSession;

public class HomeActivity extends AppCompatActivity {
    //Initialisation variable
    DrawerLayout dr;
    ListView listeView;
    String titre[] = {"Cartoon","Alphabet","Number","Animal","Cartoon","Alphabet","Number","Animal"};
    String desc[] = {"1/12","2/6","3/3","1/10","1/12","2/6","3/3","1/10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        ecoutePreference();
        TextView text = findViewById(R.id.title_lab);
        text.setText("Category");
        dr = findViewById(R.id.drawer_layout);

        listeView = findViewById(R.id.listView);

        CategoryAdapter listAdapter = new CategoryAdapter(this,titre,desc);
        initializeProfilPseudo();
        listeView.setAdapter(listAdapter);

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, CourActivity.class);
                startActivity(intent);
            }
        });
    }


    public void ClickMenu(View view){
        openDrawer(dr);
    }

    public void Deconnecter(View view){
        LogoutController.logout(HomeActivity.this);
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

    public void showPreference(View view){
        Intent intent = new Intent(HomeActivity.this, PreferenceActivity.class);
        startActivity(intent);
        finish();
    }

//    public void ecoutePreference(){
//        ImageView v = findViewById(R.id.setting);
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, PreferenceActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }

}
