package com.example.eschild.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.eschild.R;
import com.example.eschild.controller.InscriptionController;

public class SignupTab extends Fragment {

    EditText numero,pass, pseudo;
    Button signup;
    InscriptionController controle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_signup, parent, false);
        init(root);
        ecouteSignin();
        return root;
    }


    private void init(ViewGroup root){
        controle = InscriptionController.getInstance(getActivity());
        numero = root.findViewById(R.id.numero);
        pass = root.findViewById(R.id.password);
        pseudo = root.findViewById(R.id.pseudo);
        signup = root.findViewById(R.id.submit);
    }

    private void ecouteSignin(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numero.getText().toString();
                String mdp = pass.getText().toString();
                String ps = pseudo.getText().toString();
                Toast.makeText(getActivity(), "Chargement...", Toast.LENGTH_LONG).show();
                if(mdp.length() == 0 || num.length() == 0 || ps.length() == 0)
                    Toast.makeText(getActivity(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                else
                    controle.login(num, mdp, ps);

            }
        });
    }
}
