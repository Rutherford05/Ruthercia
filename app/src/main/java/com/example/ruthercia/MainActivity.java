package com.example.ruthercia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mNomUtilisateur;
    private EditText mPassword;
    private Button mConnect;
    private Button mConnect2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNomUtilisateur=(EditText)findViewById(R.id.txt_utilisateur);
        mPassword=(EditText)findViewById(R.id.txt_password);
        mConnect=(Button)findViewById(R.id.btn_connecter);
        mConnect2=(Button) findViewById(R.id.btn_inscription);
        mConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utilisateur=mNomUtilisateur.getText().toString();
                String password=mPassword.getText().toString();
                Toast.makeText(MainActivity.this,utilisateur,Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,password,Toast.LENGTH_LONG).show();
            }
        });
        mConnect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentInscription= new Intent(MainActivity.this,Inscription.class);
                startActivity(intentInscription);
            }
        });
    }

}
