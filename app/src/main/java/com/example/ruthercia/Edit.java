package com.example.ruthercia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.Models.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Edit extends AppCompatActivity  {
    EditText nom,prenom,email,motdepasse;
    int id;
    private String monNom,monPrenom,monEmail,monMotdepasse;
    Button modifier;
    Realm realm;
    Context context;
    RecyclerView recyclerView;
    RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        nom=(EditText)findViewById(R.id.My_nom);
        prenom=(EditText) findViewById(R.id.My_prenom);
        email=(EditText) findViewById(R.id.My_email);
        motdepasse=(EditText) findViewById(R.id.My_mot_de_passe);
        modifier=(Button) findViewById(R.id.My_Modifier);
        monNom=getIntent().getStringExtra("monNom");
        monPrenom=getIntent().getStringExtra("monPrenom");
        monEmail=getIntent().getStringExtra("monEmail");
        monMotdepasse=getIntent().getStringExtra("monMotdepasse");
        nom.setText(monNom);
        prenom.setText(monPrenom);
        email.setText(monEmail);
        motdepasse.setText(monMotdepasse);
       modifier.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(Edit.this,Liste.class);
               startActivity(intent);
           }
       });
        RealmConfiguration configuration= new RealmConfiguration.Builder().build();
        realm= Realm.getInstance(configuration);


    }
}
