package com.example.entity;

public class Medecin {
    private String id;
    private String nomComplet;
    private String tel;

    public Medecin(String id, String nomComplet, String tel) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return nomComplet + " (" + id + ")";
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
