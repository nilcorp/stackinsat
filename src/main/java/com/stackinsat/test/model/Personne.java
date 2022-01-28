package com.stackinsat.test.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personne_generator")
    @SequenceGenerator(name="personne_generator", sequenceName = "personne_seq", allocationSize=1)
    @Column(name="id")
    Long id;

    @Column(name="nom")
    String nom;

    @Column(name="prenom")
    String prenom;

    @Column(name="date")
    LocalDate dateDeNaissance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
