package com.example.eschild.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.eschild.R;
import com.example.eschild.controller.LoginController;

public class LoginTab extends Fragment {

    EditText numero,pass;
    TextView forget;
    Button login;
    int v = 0;
    private LoginController controle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_login, parent, false);
//        login = root.findViewById(R.id.submit);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), HomeActivity.class);
//                startActivity(intent);
//            }
//        });
        init(root);
        ecouteLogin();
        /*
        numero = root.findViewById(R.id.numero);
        pass = root.findViewById(R.id.password);
        forget = root.findViewById(R.id.forget);


        numero.setTranslationX(800);
        pass.setTranslationX(800);
        forget.setTranslationX(800);
        login.setTranslationX(800);

        numero.setAlpha(v);
        pass.setAlpha(v);
        forget.setAlpha(v);
        login.setAlpha(v);

        numero.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forget.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        */

        return root;
    }

    private void init(ViewGroup root){
        controle = LoginController.getInstance();
        numero = root.findViewById(R.id.numero);
        pass = root.findViewById(R.id.password);
        forget = root.findViewById(R.id.forget);
        login = root.findViewById(R.id.submit);
    }

    private void ecouteLogin(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), HomeActivity.class);
//                startActivity(intent);
                String num = numero.getText().toString();
                String mdp = pass.getText().toString();
                Toast.makeText(getActivity(), "Chargement...", Toast.LENGTH_LONG).show();
                if(mdp.length() == 0 || num.length() == 0)
                    Toast.makeText(getActivity(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                else
                    controle.login(num, mdp, getActivity());
            }
        });
    }

}
