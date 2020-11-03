package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe {
    private Integer grade;

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        /*Integer pourcentage = 1 + ((this.grade * 10) /100);
        //Double salaireFinal = salaire * (1 + (((Double) this.grade * 10) / 100));
        this.setSalaire(this.getSalaire() * (Double) pourcentage);*/

        super.setSalaire(salaire * (1 + grade /10.0));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        //return super.getPrimeAnnuelle() * (1+ (grade /10.0)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
        return Entreprise.primeAnnuelleBase() * (1+ (grade /10.0)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }
}
