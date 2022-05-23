package com.example.eschild.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.InputType;
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
    private ProgressDialog progressDialog;

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.getProgressDialog().dismiss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        this.progressDialog = new ProgressDialog(getActivity());
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_signup, parent, false);
        init(root);
        ecouteSignin();
        return root;
    }


    private void init(ViewGroup root){
        controle = InscriptionController.getInstance(getActivity());
        numero = root.findViewById(R.id.numero);
        pass = root.findViewById(R.id.password);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
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
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                //Toast.makeText(getActivity(), "Chargement...", Toast.LENGTH_LONG).show();
                if(mdp.length() == 0 || num.length() == 0 || ps.length() == 0)
                    Toast.makeText(getActivity(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                else
                    controle.login(num, mdp, ps);

            }
        });
    }
}
