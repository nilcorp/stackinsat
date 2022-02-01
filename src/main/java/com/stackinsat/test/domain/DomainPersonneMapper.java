package com.stackinsat.test.domain;

import com.stackinsat.test.dto.PersonneDto;
import com.stackinsat.test.model.Personne;

public class DomainPersonneMapper {

    public static Personne toPersonne(DomainPersonne domainPersonne){
        Personne personne = new Personne();
        personne.setNom(domainPersonne.nom);
        personne.setPrenom(domainPersonne.prenom);
        personne.setDateDeNaissance(domainPersonne.dateDeNaissance);
        return personne;
    }

    public static PersonneDto toPersonneDto(DomainPersonne domainPersonne){
        PersonneDto personneDto = new PersonneDto();
        personneDto.setNom(domainPersonne.nom);
        personneDto.setPrenom(domainPersonne.prenom);
        personneDto.setDateDeNaissance(domainPersonne.dateDeNaissance.toString());
        personneDto.setAge(domainPersonne.getAge());
        return personneDto;
    }
}
