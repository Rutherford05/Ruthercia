package com.example.ruthercia.Models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;
    Context context;
    Formulaire form= new Formulaire();

    public RealmHelper(Realm realm,Context context) {
        this.realm = realm;
        this.context=context;
    }
    public void save(final Formulaire formulaire){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if(realm!=null){
                    Toast.makeText(context,"Inscription réussie",Toast.LENGTH_LONG).show();
                    Number curruntidNum=realm.where(Formulaire.class).max("id");
                    int nexId;
                    if(curruntidNum==null){
                        nexId=1;
                    }else{
                        nexId=curruntidNum.intValue()+1;
                    }
                    formulaire.setId(nexId);
                    Formulaire f=realm.copyToRealm(formulaire);
                }else{
                    Toast.makeText(context,"base de données inexistante",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
     public List<Formulaire> getAllFormulaire(){
        RealmResults<Formulaire> Formulaieresult=realm.where(Formulaire.class).findAll();
        return Formulaieresult;
     }
      public void update(final int id, final String mNom, final String mPrenom, final String mEmail, final String mMotdepasse, final int rg){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmConfiguration config = new RealmConfiguration.Builder().build();
                realm = Realm.getInstance(config);
                RealmResults<Formulaire> formulaire=realm.where(Formulaire.class)
                        .equalTo("id",id)
                        .findAll();
                form.setId(id);
                form.setmNom(mNom);
                form.setmPrenom(mPrenom);
                form.setmEmail(mEmail);
                form.setmMotdePasse(mMotdepasse);
                form.setId(rg);
                realm.copyToRealmOrUpdate(form);
            }
        });
     }

}
