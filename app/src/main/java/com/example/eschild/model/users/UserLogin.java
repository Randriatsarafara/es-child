package com.example.eschild.model.users;

import com.example.eschild.utils.Helper;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

public class UserLogin implements java.io.Serializable {
    String pseudo;
    String motDePasse;
    String numero;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public UserLogin(String numero, String motDePasse) {
        this.numero = numero;
        this.motDePasse = motDePasse;
    }

    public UserLogin( String numero, String motDePasse, String pseudo) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.numero = numero;
    }

    public UserLogin(){}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void addAttributParametre(ArrayList<NameValuePair> list){
//        list.addAll;
        Helper.addParameter("pseudo", pseudo, list);
        Helper.addParameter("motDePasse", motDePasse, list);
        Helper.addParameter("numero", numero, list);
    }
}
