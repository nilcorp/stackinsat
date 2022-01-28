package com.stackinsat.test.service;


import com.stackinsat.test.domain.DomainPersonne;
import com.stackinsat.test.domain.DomainPersonneMapper;
import com.stackinsat.test.exception.BusinessException;
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
        return personneRepository.findAllByOrderByNomAsc().stream().map(PersonneMapper::toDomainPersonne).collect(Collectors.toList());
    }


    public void creerPersonne(DomainPersonne domainPersonne){
        try {
            if(domainPersonne.controleAvantInsertion()) {
                personneRepository.save(DomainPersonneMapper.toPersonne(domainPersonne));
            }else{
                throw new BusinessException("Erreur age > 150 ans");
            }
        }catch(Exception e){
           if( ! (e instanceof BusinessException)) {
                logger.error(e.getMessage());
                throw new BusinessException("Create error");
           }else{
               throw e;
           }
        }

    }
}
