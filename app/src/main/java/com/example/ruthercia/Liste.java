package com.example.ruthercia;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.Models.RealmHelper;
import com.example.ruthercia.m_UI.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Liste extends AppCompatActivity {
   Realm realm;
   RealmHelper realmHelper;
   RecyclerView recyclerView;
   MyAdapter adapter;
   List<Formulaire> formlist;
   FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        fab=(FloatingActionButton) findViewById(R.id.fab2);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Liste.this,Inscription.class));
            }
        });

        RealmConfiguration configuration= new RealmConfiguration.Builder().build();
        realm=Realm.getInstance(configuration);

        realmHelper= new RealmHelper(realm,getApplicationContext());
        formlist= new ArrayList<>();
        formlist=realmHelper.getAllFormulaire();
        adapter= new MyAdapter(this,formlist);
        recyclerView.setAdapter(adapter);

    }
}
