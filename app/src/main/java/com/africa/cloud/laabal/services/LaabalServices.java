package com.africa.cloud.laabal.services;

import com.africa.cloud.laabal.models.Clients;
import com.africa.cloud.laabal.models.Critique;
import com.africa.cloud.laabal.models.Reclamation;
import com.paydunya.neptune.PaydunyaCheckoutStore;
import com.paydunya.neptune.PaydunyaOnsiteInvoice;
import com.paydunya.neptune.PaydunyaSetup;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LaabalServices {


    @POST("clients/")
    @FormUrlEncoded
    Call<Clients> saveClients(@Field("nom") String nom,
                           @Field("prenom") String prenom,
                           @Field("adresse") String adresse,
                           @Field("telephone") String telephone);


    @POST("reclamation/")
    @FormUrlEncoded
    Call<Reclamation> saveReclamation(@Field("nom") String nom,
                                  @Field("prenom") String prenom,
                                  @Field("objets") String objets);


    @POST("critique/")
    @FormUrlEncoded
    Call<Critique> saveCritique(@Field("nom") String nom,
                                   @Field("prenom") String prenom,
                                   @Field("objets") String objets);






}
