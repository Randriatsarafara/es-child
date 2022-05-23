package com.example.eschild.view;

public class Cour {
    private String id;
    private String title;
    private String description;
    private String image;
    private boolean vue;
    private String sousTitre;
    private String [] video;

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public Cour(String id, String title, String description, String image, boolean vue, String sousTitre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.vue = vue;
        this.sousTitre = sousTitre;
    }

    public Cour(String id, String title, String description, String image, boolean vue, String sousTitre,String [] video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.vue = vue;
        this.sousTitre = sousTitre;
        this.video = video;
    }

    public Cour(String id, String title, String description, String image,String sousTitre,String [] video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.sousTitre = sousTitre;
        this.video = video;
    }

    public Cour(String id, String title, String description, String image,String sousTitre,boolean vue) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.sousTitre = sousTitre;
        this.vue = vue;
    }


    public String[] getVideo() {
        return video;
    }

    public void setVideo(String[] video) {
        this.video = video;
    }

    public boolean getVue() {
        return vue;
    }

    public String getVueString() {
        if(this.vue==true){
            return "Lu";
        }
        return "Non lu";
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
