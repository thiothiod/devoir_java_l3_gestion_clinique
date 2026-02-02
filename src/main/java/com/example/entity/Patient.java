package com.example.entity;


public class Patient {
    private String id;
    private String nomComplet;
    private String tel;
    public Patient(String id, String nomComplet, String tel) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tel = tel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
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

    public String getId() { return id; }

    @Override
    public String toString() {
        return nomComplet + " (" + id + ")";
    }
}
