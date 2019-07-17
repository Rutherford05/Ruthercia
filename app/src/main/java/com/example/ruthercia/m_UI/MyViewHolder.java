package com.example.ruthercia.m_UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruthercia.Models.Formulaire;
import com.example.ruthercia.R;

import java.util.List;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mName;
    TextView mEmail;
    ImageView editbtn;
    ImageView deletebtn;
    EditText monNom,monPrenom,monEmail,monMotdepasse;
    Button modif;


    public MyViewHolder(View itemView) {
        super(itemView);
        mName=(EditText)itemView.findViewById(R.id.M_nom);
        mEmail=(EditText)itemView.findViewById(R.id.M_email);
        monNom=(EditText) itemView.findViewById(R.id.My_nom);
        monPrenom=(EditText) itemView.findViewById(R.id.My_prenom);
        monEmail=(EditText) itemView.findViewById(R.id.My_email);
        monMotdepasse=(EditText) itemView.findViewById(R.id.My_mot_de_passe);
        editbtn=(ImageView) itemView.findViewById(R.id.image_edit);
        deletebtn=(ImageView) itemView.findViewById(R.id.image_delete);
        modif=(Button) itemView.findViewById(R.id.My_Modifier);

    }
}
