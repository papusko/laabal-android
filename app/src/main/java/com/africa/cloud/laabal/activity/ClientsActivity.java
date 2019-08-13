package com.africa.cloud.laabal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import com.paydunya.neptune.*;
import com.africa.cloud.laabal.R;

public class ClientsActivity extends AppCompatActivity {

    CardView inscription,reclamation,critique;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);






        inscription = (CardView) findViewById(R.id.bankcardId2);
        reclamation = (CardView) findViewById(R.id.bankcardId3);
        critique = (CardView) findViewById(R.id.bankcardId5);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription=new Intent(ClientsActivity.this, InscriptionClientsActivity.class);
        startActivity(inscription);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reclamation=new Intent(ClientsActivity.this, ReclamationActivity.class);
                startActivity(reclamation);

            }
        });



        critique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent critique=new Intent(ClientsActivity.this, CritiqueActivity.class);
                startActivity(critique);
            }
        });




    }




}
