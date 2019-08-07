package com.africa.cloud.laabal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Critique {

    @SerializedName("nom")
    @Expose
    private
    String nom;

    @SerializedName("prenom")
    @Expose
    private
    String prenom;

    @SerializedName("objets")
    @Expose
    private
    String objets;

    public Critique(String nom, String prenom, String objets) {
        this.nom = nom;
        this.prenom = prenom;
        this.objets = objets;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getObjets() {
        return objets;
    }

    public void setObjets(String objets) {
        this.objets = objets;
    }
}
