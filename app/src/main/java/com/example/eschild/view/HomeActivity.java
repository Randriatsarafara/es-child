package com.example.eschild.view;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.eschild.R;
import com.example.eschild.controller.LogoutController;
import com.example.eschild.model.Categorie;
import com.example.eschild.model.accesDistant.AccessDistanceCategorie;
import com.example.eschild.model.users.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity {
    //Initialisation variable
    DrawerLayout dr;
    ListView listeView;
    SearchView searchView;
    ArrayAdapter<String> arrayAdapter;
    CategoryAdapter listAdapter;

    private List<Categorie> list = new ArrayList<>();
    public final static String EXTRA_MESSAGE = "com.ltm.ltmactionbar.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
//        ecoutePreference();

        TextView text = findViewById(R.id.title_lab);
        text.setText("List of category");
        dr = findViewById(R.id.drawer_layout);
        searchView = findViewById(R.id.search);
        listeView = findViewById(R.id.listView);

        //arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1);
        //listeView.setAdapter(arrayAdapter);

        try {
            AccessDistanceCategorie access = new AccessDistanceCategorie(HomeActivity.this);
            list = access.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Categorie> temp = new ArrayList<>();
                if(query.compareToIgnoreCase("")==0){
                    listAdapter = new CategoryAdapter(getApplicationContext(),list);
                    listeView.setAdapter(listAdapter);
                    return true;
                }
                for(int i = 0; i<list.size(); i++){
                    if(list.get(i).getNom().contains(query)){
                        temp.add(list.get(i));
                    }
                }
                listAdapter = new CategoryAdapter(getApplicationContext(),temp);
                listeView.setAdapter(listAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Toast.makeText(HomeActivity.this, newText, Toast.LENGTH_SHORT).show();
                if(newText.compareToIgnoreCase("")==0){
                    listAdapter = new CategoryAdapter(getApplicationContext(),list);
                    listeView.setAdapter(listAdapter);
                }
                return true;
            }
        });
        listAdapter = new CategoryAdapter(this,list);
        listeView.setAdapter(listAdapter);
        initializeProfilPseudo();


        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, CourActivity.class);
                intent.putExtra(HomeActivity.EXTRA_MESSAGE, list.get(i).getId());
                startActivity(intent);
            }
        });
    }

    public void ClickHome(View view){
        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
        startActivity(intent);
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

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

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
