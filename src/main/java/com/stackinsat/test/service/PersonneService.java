package com.stackinsat.test.service;


import com.stackinsat.test.domain.DomainPersonne;
import com.stackinsat.test.domain.DomainPersonneMapper;
import com.stackinsat.test.exception.BusinessException;
import com.stackinsat.test.model.Personne;
import com.stackinsat.test.model.PersonneMapper;
import com.stackinsat.test.repository.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneService {

    Logger logger = LoggerFactory.getLogger(PersonneService.class);

    private PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository){
        this.personneRepository = personneRepository;
    }

    public List<DomainPersonne> findAll(){
        return personneRepository.findAll().stream().map(PersonneMapper::toDomainPersonne).collect(Collectors.toList());
    }


    public void creerPersonne(DomainPersonne domainPersonne){
        try {
            if(domainPersonne.controleAvantInsertion()) {
                Personne p = DomainPersonneMapper.toPersonne(domainPersonne);

                personneRepository.save(DomainPersonneMapper.toPersonne(domainPersonne));
                logger.info("Creation !!!");
            }else{
                throw new BusinessException("Creation impossible : age > 150");
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new BusinessException("Create error");
        }

    }
}
