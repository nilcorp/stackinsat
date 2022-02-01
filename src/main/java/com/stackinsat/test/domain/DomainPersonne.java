package com.stackinsat.test.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class DomainPersonne {

    public String nom;
    public String prenom;
    public LocalDate dateDeNaissance;


    public Boolean controleAvantInsertion(){
        Boolean controle = true;
        if(Period.between(dateDeNaissance, LocalDate.now()).getYears() > 150){
            controle = false;
        }
        return controle;
    }

    public Long getAge(){
        return Long.valueOf( Period.between(dateDeNaissance, LocalDate.now()).getYears());
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
