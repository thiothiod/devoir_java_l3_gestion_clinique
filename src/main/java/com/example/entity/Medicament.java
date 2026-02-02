package com.example.entity;

public class Medicament {
    private String code;
    private String nom;
    private String dose;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Medicament(String code, String nom, String dose) {
        this.code = code;
        this.nom = nom;
        this.dose = dose;
    }
}
