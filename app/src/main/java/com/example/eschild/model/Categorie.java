package com.example.eschild.model;

// Categorie cours
public class Categorie {
    private String id;
    private String nom;
    private String image;
    private int courTotal;
    private int courVue;

    public int getCourTotal() {
        return courTotal;
    }

    public void setCourTotal(int courTotal) {
        this.courTotal = courTotal;
    }

    public int getCourVue() {
        return courVue;
    }

    public void setCourVue(int courVue) {
        this.courVue = courVue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categorie(String id, String nom, String image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
    }

    public Categorie(String id, String nom, String image, int courTotal, int courVue) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.courTotal = courTotal;
        this.courVue = courVue;
    }
}
