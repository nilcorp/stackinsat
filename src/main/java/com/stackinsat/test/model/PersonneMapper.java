package com.stackinsat.test.model;

import com.stackinsat.test.domain.DomainPersonne;
import com.stackinsat.test.service.PersonneService;

public class PersonneMapper {

    public static DomainPersonne toDomainPersonne(Personne personne){
        DomainPersonne domainPersonne = new DomainPersonne();
        domainPersonne.setNom(personne.nom);
        domainPersonne.setPrenom(personne.prenom);
        domainPersonne.setDateDeNaissance(personne.dateDeNaissance);
        return domainPersonne;
    }
}
