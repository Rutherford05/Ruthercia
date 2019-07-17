package com.example.ruthercia;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.Models.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Inscription extends AppCompatActivity {
    private EditText mNom;
    private EditText mPrenom;
    private EditText mEmail;
    private EditText mMotdePasse;
    private EditText mConfirm;
    private Button mInscription;
    private RadioGroup rg;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    Realm realm;
    RealmHelper realmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mNom=(EditText)findViewById(R.id.M_nom);
        mPrenom=(EditText)findViewById(R.id.M_prenom);
        mEmail=(EditText)findViewById(R.id.M_email);
        mMotdePasse=(EditText)findViewById(R.id.M_mot_Passe);
        mConfirm=(EditText)findViewById(R.id.M_confirm);
       // lv=(ListView)findViewById(R.id.txt_List);
        RealmConfiguration configuration= new RealmConfiguration.Builder().build();
        realm= Realm.getInstance(configuration);
        rg=(RadioGroup)findViewById(R.id.radio_group);
        mInscription=(Button)findViewById(R.id.txt_inscription2);
        mInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name=mNom.getText().toString();
               String prenom=mPrenom.getText().toString();
               String email=mEmail.getText().toString();
                String mp=mMotdePasse.getText().toString();
                String confirm=mConfirm.getText().toString();
                int selectedId=rg.getCheckedRadioButtonId();
                RadioButton radioButton=(RadioButton)findViewById(selectedId);
                if(mNom.getText().toString().isEmpty() || mPrenom.getText().toString().isEmpty() || mEmail.getText().toString().isEmpty() || mMotdePasse.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ce champs est obligatoire",Toast.LENGTH_LONG).show();
                }
                   else if(!mEmail.getText().toString().trim().matches(emailPattern)){
                    Toast.makeText(getApplicationContext(), "L'adresse saisie n'est pas valide", Toast.LENGTH_LONG).show();
                } else if(mMotdePasse.getText().toString().length()<6&&(mConfirm.getText().toString().length()<6)){
                    Toast.makeText(getApplicationContext(),"Le mot de passe doit contenir 6 caractères au minimun",Toast.LENGTH_LONG).show();
                }else if(!mConfirm.getText().toString().equals(mMotdePasse.getText().toString())){
                    Toast.makeText(Inscription.this,"Les mots de passe ne sont pas identiques",Toast.LENGTH_LONG).show();
                }else{
                       Formulaire formulaire=new Formulaire();
                       formulaire.setmNom(name);
                       formulaire.setmPrenom(prenom);
                      formulaire.setmEmail(email);
                      formulaire.setmMotdePasse(mp);
                      formulaire.setId(selectedId);
                      realmHelper= new RealmHelper(realm,getApplicationContext());
                      realmHelper.save(formulaire);
                      formulaire.setmNom("");
                      formulaire.setmPrenom("");
                      formulaire.setmEmail("");
                      formulaire.setmMotdePasse("");
                      formulaire.setId(selectedId);
                    Intent intentMain=new Intent(Inscription.this,Liste.class);
                    startActivity(intentMain);
                }
            }
        });
    }
    public void Connection(View C){
        Intent intentMain=new Intent(this,MainActivity.class);
        startActivity(intentMain);
    }
}
