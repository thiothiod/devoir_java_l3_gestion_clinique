package com.example.core;

import java.util.List;

import com.example.entity.Medecin;
import com.example.entity.Medicament;
import com.example.entity.Patient;

public class DataSource {

    private static DataSource instance;

    public List<Patient> patients;
    public List<Medecin> medecins;
    public List<Medicament> medicaments;

    private DataSource() {}

    public static DataSource getInstance() {
        if (instance == null)
            instance = new DataSource();
        return instance;
    }
}

