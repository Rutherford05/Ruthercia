/*package com.example.ruthercia;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.Models.RealmHelper;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Utilisateurs extends AppCompatActivity {
    FloatingActionButton fab;
    Realm realm;
    ArrayList<String>formulaires;
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateurs);
        lv=(ListView) findViewById(R.id.txt_List);
        fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Utilisateurs.this,Inscription.class));
            }
        });
        RealmConfiguration configuration= new RealmConfiguration.Builder().build();
        realm=Realm.getInstance(configuration);
        RealmHelper realmHelper=new RealmHelper(realm,getApplicationContext());
        formulaires=realmHelper.retrieve();
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,formulaires);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Utilisateurs.this,formulaires.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}*/
