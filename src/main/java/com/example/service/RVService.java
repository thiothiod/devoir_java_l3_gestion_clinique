
package com.example.service;

import com.example.entity.*;
import com.example.enums.StatutRV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RVService {

    private final List<RV> rvs = new ArrayList<>();

    public void creerRV(String code, LocalDate date, int duree,
                        Patient patient, Medecin medecin) {

        // Code unique
        for (RV rv : rvs) {
            if (rv.getCode().equals(code))
                throw new RuntimeException("Code RV déjà utilisé");
        }

        // Date valide
        if (date.isBefore(LocalDate.now()))
            throw new RuntimeException("Date invalide");

        // Durée valide
        if (duree <= 0)
            throw new RuntimeException("Durée invalide");

        rvs.add(new RV(code, date, duree, patient, medecin));
    }

    public void faireConsultation(String code) {
        for (RV rv : rvs) {
            if (rv.getCode().equals(code)) {
                if (rv.getStatut() != StatutRV.EN_ATTENTE)
                    throw new RuntimeException("RV non valide");

                rv.setStatut(StatutRV.FAIT);
                return;
            }
        }
        throw new RuntimeException("RV introuvable");
    }

    public List<RV> getTousRV() {
        return rvs;
    }

    public List<RV> getConsultations() {
        return rvs.stream()
                .filter(rv -> rv.getStatut() == StatutRV.FAIT)
                .toList();
    }

    public void filtrerConsultationsParPatient(String idPatient) {

    boolean trouve = false;

    for (RV rv : rvs) {
        if (rv.getStatut() == StatutRV.FAIT &&
            rv.getPatient().getId().equals(idPatient)) {

            System.out.println(rv);
            trouve = true;
        }
    }

    if (!trouve) {
        System.out.println("Aucune consultation trouvée pour ce patient.");
    }
}

}
