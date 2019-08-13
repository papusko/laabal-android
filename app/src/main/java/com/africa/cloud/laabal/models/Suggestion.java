package com.africa.cloud.laabal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("nom")
    @Expose
    private
    String nom;

    @SerializedName("prenom")
    @Expose
    private
    String prenom;

    @SerializedName("telephone")
    @Expose
    private
    String telephone;

    @SerializedName("objet")
    @Expose
    private
    String objet;



}
