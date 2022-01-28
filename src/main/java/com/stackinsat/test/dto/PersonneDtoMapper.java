package com.stackinsat.test.dto;

import com.stackinsat.test.domain.DomainPersonne;
import com.stackinsat.test.utils.Utils;

public class PersonneDtoMapper {

    public static DomainPersonne toDomain(PersonneDto personneDto){
        DomainPersonne domainPersonne = new DomainPersonne();
        domainPersonne.setNom(personneDto.nom);
        domainPersonne.setPrenom(personneDto.prenom);
        domainPersonne.setDateDeNaissance(Utils.convertStingToLocalDate(personneDto.dateDeNaissance));
        return domainPersonne;
    }
}
