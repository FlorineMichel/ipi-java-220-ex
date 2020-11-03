package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe{

    private HashSet<Technicien> equipe = new HashSet<>();

    public Manager(){
        super();
    }

    public Manager(String nom, String prenom, String matricule, org.joda.time.LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    @Override
    public void setSalaire(Double salaire) {
        /*ma méthode super longue*/
//        Double indManager = salaire * Entreprise.INDICE_MANAGER;
//        Double ajout = 0.0;
//        Integer nbrTech = this.equipe.size();
//        for (Integer i = 0 ; i < this.equipe.size(); i++){
//            ajout = salaire * 0.1;
//        }
//        super.setSalaire(ajout + indManager);
        Double salaireCalcule = salaire * Entreprise.INDICE_MANAGER;
        salaireCalcule = salaireCalcule + this.equipe.size() * salaire * 0.1;
        super.setSalaire(salaireCalcule);
    }

    public void ajoutTechnicienEquipe(Technicien t){
        this.equipe.add(t);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        Technicien t = new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade);
        this.ajoutTechnicienEquipe(t);
    }

    @Override
    public Double getPrimeAnnuelle() {
        //Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
        return Entreprise.primeAnnuelleBase() + this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    private void augmenterSalaireEquipe(Double pourcentage){
        for (Technicien t : this.equipe){
            t.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public void augmenterSalaire(Double pourcentageAugmentation) {
        for (Technicien t : this.equipe){
            t.augmenterSalaire(pourcentageAugmentation);
        }
        super.augmenterSalaire(pourcentageAugmentation);
    }
}
