package com.example.eschild.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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
    private LoginController controle;
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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_login, parent, false);
        init(root);
        ecouteLogin();
        return root;
    }

    private void init(ViewGroup root){
        controle = LoginController.getInstance();
        numero = root.findViewById(R.id.numero);
        pass = root.findViewById(R.id.password);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
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
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                //Toast.makeText(getActivity(), "Chargement...", Toast.LENGTH_LONG).show();
                if(mdp.length() == 0 || num.length() == 0){
                    Toast.makeText(getActivity(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                }
                else{
                    controle.login(num, mdp, getActivity());
                }
            }
        });
    }

}
