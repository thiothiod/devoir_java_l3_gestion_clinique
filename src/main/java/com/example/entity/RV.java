package com.example.entity;

import java.time.LocalDate;

import com.example.enums.StatutRV;

public class RV {

    private String code; // UNIQUE
    private LocalDate date;
    private int duree;
    private StatutRV statut;

    private Patient patient;   // 1 RV → 1 Patient
    private Medecin medecin;   // 1 RV → 1 Médecin

    public RV(String code, LocalDate date, int duree,
              Patient patient, Medecin medecin) {

        this.code = code;
        this.date = date;
        this.duree = duree;
        this.patient = patient;
        this.medecin = medecin;
        this.statut = StatutRV.EN_ATTENTE;
    }

    public String getCode() { return code; }
    public StatutRV getStatut() { return statut; }
    public void setStatut(StatutRV statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "RV[" + code + ", " + date +
                ", Patient=" + patient +
                ", Medecin=" + medecin +
                ", Statut=" + statut + "]";
    }

    public Patient getPatient() {
    return patient;
}

}
