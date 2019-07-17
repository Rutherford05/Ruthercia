package com.example.ruthercia.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruthercia.Edit;
import com.example.ruthercia.Inscription;
import com.example.ruthercia.MainActivity;
import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.R;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Formulaire> formlist;
    Formulaire form;
    Context context;
    Realm realm;
    public MyAdapter(Context context, List<Formulaire> formlist) {
        this.context=context;
        this.formlist = formlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Nom,Email;
        public ImageView edit, delete;
        public EditText monNom,monPrenom,monEmail,monMotdepasse;
        public RadioGroup rg;

        public MyViewHolder(View view) {
            super(view);
            Nom=(TextView)view.findViewById(R.id.M_nom);
            Email=(TextView) view.findViewById(R.id.M_email);
            delete=(ImageView) view.findViewById(R.id.image_delete);
            edit=(ImageView) view.findViewById(R.id.image_edit);
            monNom=(EditText) view.findViewById(R.id.My_nom);
            monPrenom=(EditText) view.findViewById(R.id.My_prenom);
            monEmail=(EditText) view.findViewById(R.id.My_email);
            monMotdepasse=(EditText) view.findViewById(R.id.My_mot_de_passe);
            rg=(RadioGroup) view.findViewById(R.id.radio_group);


        }
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_formulaire_liste_row,parent,false);
        return new  MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int postion) {
        final Formulaire form= formlist.get(postion);
        holder.Nom.setText(form.getmNom());
        holder.Email.setText(form.getmEmail());
        RealmConfiguration config= new RealmConfiguration.Builder().build();
        realm=Realm.getInstance(config);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent= new Intent(context,Edit.class);
                        intent.putExtra("id",form.getId());
                        intent.putExtra("monNom",form.getmNom());
                        intent.putExtra("monPrenom",form.getmPrenom());
                        intent.putExtra("monEmail",form.getmEmail());
                        intent.putExtra("monMotdepasse",form.getmMotdePasse());
                        context.startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmConfiguration config= new RealmConfiguration.Builder().build();
                realm=Realm.getInstance(config);
               realm.executeTransaction(new Realm.Transaction() {
                   @Override
                   public void execute(Realm realm) {
                       List<Formulaire> formList = new ArrayList<>();
                       RealmResults<Formulaire> results=realm.where(Formulaire.class).equalTo("mEmail",form.getmEmail()+postion).findAll();
                       form.deleteFromRealm();
                       notifyDataSetChanged();

                   }
               });
            }
        });

    }


    @Override
    public int getItemCount() {
        return formlist.size();
    }

}
