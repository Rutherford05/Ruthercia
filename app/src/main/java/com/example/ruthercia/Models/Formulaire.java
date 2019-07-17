package com.example.ruthercia.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Formulaire extends RealmObject {
    @PrimaryKey
    private int id;
    private String mNom;
    private String mPrenom;
    private String mEmail;
    private String mMotdePasse;
    private String mConfirm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmNom() {
        return mNom;
    }

    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public String getmPrenom() {
        return mPrenom;
    }

    public void setmPrenom(String mPrenom) {
        this.mPrenom = mPrenom;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmMotdePasse() {
        return mMotdePasse;
    }

    public void setmMotdePasse(String mMotdePasse) {
        this.mMotdePasse = mMotdePasse;
    }

    public String getmConfirm() {
        return mConfirm;
    }

    public void setmConfirm(String mConfirm) {
        this.mConfirm = mConfirm;
    }

    @Override
    public String toString() {
        return "Formulaire{" +
                "id=" + id +
                ", mNom='" + mNom + '\'' +
                ", mPrenom='" + mPrenom + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mMotdePasse='" + mMotdePasse + '\'' +
                ", mConfirm='" + mConfirm + '\'' +
                '}';
    }
}
