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
import com.africa.cloud.laabal.models.Reclamation;
import com.africa.cloud.laabal.services.LaabalServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CritiqueActivity extends AppCompatActivity {

    private static final String TAG = "poubelle" ;
    EditText edit1, edit2, edit3;
    Button inscrire;
    String nom, prenom, objets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critique);

        edit1 = (EditText) findViewById(R.id.nom);
        edit2 = (EditText) findViewById(R.id.prenom);
        edit3 =(EditText) findViewById(R.id.critique);
        inscrire = (Button) findViewById(R.id.enregistrer);

        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom = edit1.getText().toString();
                prenom = edit2.getText().toString();
                objets = edit3.getText().toString();
                if (nom.isEmpty()| prenom.isEmpty()| objets.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tout les champs", Toast.LENGTH_SHORT).show();
                }else {


                    sendPost(nom,prenom,objets);


                }


            }
        });

    }

    private void sendPost(String nom, String prenom, String objets) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.211:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LaabalServices user = retrofit.create(LaabalServices.class);

        user.saveCritique(nom,prenom,objets).enqueue(new Callback<Critique>() {
            @Override
            public void onResponse(Call<Critique> call, Response<Critique> response) {


                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Critique  soumit à l'administration lerci pour votre confiance." + response.body().toString());
                }

                Toast.makeText(getApplicationContext(), response.code()+"", Toast.LENGTH_SHORT).show();
            }

            private void showResponse(String toString) {


            }

            @Override
            public void onFailure(Call<Critique> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Echecs d'enregistrement revoir le code"+t, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
