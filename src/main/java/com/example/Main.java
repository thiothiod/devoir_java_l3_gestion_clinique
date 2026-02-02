package com.example;

import com.example.entity.*;
import com.example.enums.StatutRV;
import com.example.service.RVService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final RVService rvService = new RVService();

    // ===== DONNÉES EN LISTES (INITIALISÉES) =====
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Medecin> medecins = new ArrayList<>();
    private static final List<Medicament> medicaments = new ArrayList<>();

    public static void main(String[] args) {

        initialiserDonnees();

        int choix;
        do {
            System.out.println("\n========== MENU GESTION CLINIQUE ==========");
            System.out.println("1. Voir les Rendez-vous");
            System.out.println("2. Créer un Rendez-vous");
            System.out.println("3. Faire une Consultation");
            System.out.println("4. Voir les Consultations");
            System.out.println("0. Quitter");
            System.out.println("==========================================");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 -> afficherRV();
                case 2 -> creerRV();
                case 3 -> faireConsultation();
                case 4 -> afficherConsultations();
                case 0 -> System.out.println("Fin du programme 👋");
                default -> System.out.println("Choix invalide ❌");
            }

        } while (choix != 0);
    }

    // ================= USE CASES =================

    private static void afficherRV() {
        rvService.getTousRV().forEach(System.out::println);
    }

    private static void afficherConsultations() {
        rvService.getConsultations().forEach(System.out::println);
    }

    private static void creerRV() {

        System.out.print("Code du RV : ");
        String code = sc.nextLine();

        System.out.print("Date du RV (JJ/MM/AAAA) : ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(sc.nextLine(), formatter);

        System.out.print("Durée (minutes) : ");
        int duree = sc.nextInt();
        sc.nextLine();

        // Choix patient
        System.out.println("Choisissez un patient :");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getNomComplet());
        }
        int choixPatient = sc.nextInt() - 1;
        sc.nextLine();
        Patient patient = patients.get(choixPatient);

        // Choix medecin
        System.out.println("Choisissez un médecin :");
        for (int i = 0; i < medecins.size(); i++) {
            System.out.println((i + 1) + ". " + medecins.get(i).getNomComplet());
        }
        int choixMedecin = sc.nextInt() - 1;
        sc.nextLine();
        Medecin medecin = medecins.get(choixMedecin);

        try {
            rvService.creerRV(code, date, duree, patient, medecin);
            System.out.println("RV créé avec succès ✅");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void faireConsultation() {

        System.out.print("Code du RV : ");
        String code = sc.nextLine();

        try {
            rvService.faireConsultation(code);
            System.out.println("Consultation effectuée ✅");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= INIT DONNÉES =================

    private static void initialiserDonnees() {

        patients.add(new Patient("P01", "Diallo Mamadou", "770000001"));
        patients.add(new Patient("P02", "Sarr Awa", "770000002"));

        medecins.add(new Medecin("M01", "Dr Ndiaye", "780000001"));

        rvService.creerRV(
                "RV_INIT",
                LocalDate.now().plusDays(1),
                30,
                patients.get(0),
                medecins.get(0)
        );
    }
}
