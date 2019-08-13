package com.africa.cloud.laabal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.africa.cloud.laabal.R;
import com.africa.cloud.laabal.models.Critique;
import com.africa.cloud.laabal.models.Suggestion;
import com.africa.cloud.laabal.services.LaabalServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SuggestionActivity extends AppCompatActivity {


    private static final String TAG = "suggestion" ;
    EditText edit1, edit2, edit3, edit4;
    Button inscrire;
    String nom, prenom, telephone, objet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        edit1 = (EditText) findViewById(R.id.nom);
        edit2 = (EditText) findViewById(R.id.prenom);
        edit3 =(EditText) findViewById(R.id.telephone);
        edit3 =(EditText) findViewById(R.id.adresse);
        inscrire = (Button) findViewById(R.id.enregistrer);


        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom = edit1.getText().toString();
                prenom = edit2.getText().toString();
                telephone = edit2.getText().toString();
                objet = edit3.getText().toString();


                if (nom.isEmpty()| prenom.isEmpty()| telephone.isEmpty() | objet.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tout les champs", Toast.LENGTH_SHORT).show();
                }else {


                    sendPost(nom,prenom,telephone,objet);

                }

            }
        });
    }

    private void sendPost(String nom, String prenom, String telephone, String objet) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.211:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LaabalServices user = retrofit.create(LaabalServices.class);

        user.saveSuggestion(nom,prenom,telephone,objet).enqueue(new Callback<Suggestion>() {
            @Override
            public void onResponse(Call<Suggestion> call, Response<Suggestion> response) {


                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Critique  soumit à l'administration lerci pour votre confiance." + response.body().toString());
                }

                Toast.makeText(getApplicationContext(), response.code()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Suggestion> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Echecs d'enregistrement revoir le code"+t, Toast.LENGTH_SHORT).show();
            }

            private void showResponse(String toString) {


            }

        });


    }
}
